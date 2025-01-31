import org.junit.jupiter.api.Test;

import com.skypay.exception.customExceptions.InsufficientBalanceException;
import com.skypay.exception.customExceptions.InvalidDepositAmountException;
import com.skypay.exception.customExceptions.InvalidWithdrawAmountException;
import com.skypay.model.Account;
import com.skypay.model.Transaction;
import com.skypay.service.Impl.AccountServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

public class AccountServiceTest {
    
    @Test
    public void depositSuccess(){
        Account mockAccount = mock(Account.class);
        AccountServiceImpl accountService = new AccountServiceImpl(mockAccount);
        when(mockAccount.getBalance()).thenReturn(0); 
        accountService.deposit(300);
        verify(mockAccount).setBalance(300); 
    }

    @Test
    public void depositFailShouldThrow(){
        Account mockAccount = mock(Account.class);
        AccountServiceImpl accountService = new AccountServiceImpl(mockAccount);
        when(mockAccount.getBalance()).thenReturn(0); 
        assertThrows(InvalidDepositAmountException.class, ()->{accountService.deposit(-100);});
        verify(mockAccount, never()).setBalance(anyInt());
    }

    @Test
    public void withdrawSuccess(){
        Account mockAccount = mock(Account.class);
        AccountServiceImpl accountService = new AccountServiceImpl(mockAccount);
        when(mockAccount.getBalance()).thenReturn(500); 
        accountService.withdraw(300); 
        verify(mockAccount).setBalance(200);
    }

    @Test
    public void withdrawFailShouldThrowInvalidWithdrawAmountException(){
        Account mockAccount = mock(Account.class);
        AccountServiceImpl accountService = new AccountServiceImpl(mockAccount);
        when(mockAccount.getBalance()).thenReturn(0); 
        assertThrows(InvalidWithdrawAmountException.class, ()->{accountService.withdraw(-100);});
        verify(mockAccount, never()).setBalance(anyInt());
    }

    @Test
    public void withdrawFailShouldThrowInsufficientBalance(){
        Account mockAccount = mock(Account.class);
        AccountServiceImpl accountService = new AccountServiceImpl(mockAccount);
        when(mockAccount.getBalance()).thenReturn(300); 
        assertThrows(InsufficientBalanceException.class, ()->{accountService.withdraw(500);});
        verify(mockAccount, never()).setBalance(anyInt());
    } 

    @Test
    public void testPrintStatement() {
        Account mockAccount = mock(Account.class);
        AccountServiceImpl accountService = new AccountServiceImpl(mockAccount);

        Transaction transaction1 = new Transaction(LocalDate.of(2023, 10, 1), 1000, 1000);
        Transaction transaction2 = new Transaction(LocalDate.of(2023, 10, 5), 2000, 3000);
        Transaction transaction3 = new Transaction(LocalDate.of(2023, 10, 10), -500, 2500);

        when(mockAccount.getTransactions()).thenReturn(List.of(transaction1, transaction2, transaction3));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        accountService.printStatement();
        System.setOut(originalOut);
       
        String actualOutput = outputStream.toString()
                .replaceAll("\\r\\n", "\n") 
                .replaceAll("\\s+", " ")   
                .trim();                   

        String expectedOutput =
                "Date || Amount || Balance\n" +
                "2023-10-01 || 1000 || 1000\n" +
                "2023-10-05 || 2000 || 3000\n" +
                "2023-10-10 || -500 || 2500\n";
        expectedOutput = expectedOutput
                .replaceAll("\\s+", " ")    
                .trim();                   
        assertEquals(expectedOutput, actualOutput);
    }

}
