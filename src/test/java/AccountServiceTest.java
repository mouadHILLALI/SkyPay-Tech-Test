import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.skypay.model.Account;
import com.skypay.service.Impl.AccountService;
import com.skypay.service.Impl.AccountServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountServiceTest {
    
    @Test
    public void deposit(){
        Account mockAccount = mock(Account.class);
        AccountServiceImpl accountService = new AccountServiceImpl(mockAccount);
        when(mockAccount.getBalance()).thenReturn(0); 
        accountService.deposit(300);
        verify(mockAccount).setBalance(300); 
    }

}
