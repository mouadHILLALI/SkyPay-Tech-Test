import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.skypay.exception.customExceptions.InsufficientBalanceException;
import com.skypay.exception.customExceptions.InvalidDepositAmountException;
import com.skypay.exception.customExceptions.InvalidWithdrawAmountException;
import com.skypay.model.Account;
import com.skypay.service.Impl.AccountServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

}
