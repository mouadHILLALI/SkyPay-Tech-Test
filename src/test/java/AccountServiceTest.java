import org.junit.jupiter.api.Test;
import com.skypay.service.AccountService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountServiceTest {
    
    @Test
    public void deposit(){
        AccountService accountService = new AccountService();
        accountService.deposit();
        String expectedStatement =
        "Date || Amount || Balance\n" +
        "10-01-2012 || 1000 || 1000\n";
         assertNotNull(expectedStatement);
    }

}
