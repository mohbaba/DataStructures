package AccountTests;

import Account.Account;
import Account.Exceptions.InsufficientFundsException;
import Account.Exceptions.InvalidAmountException;
import Account.Exceptions.InvalidPinException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setup() throws InvalidPinException {
        account = new Account("Mohbaba","1234",1);


    }
    @Test
    public void testNewlyCreatedAccountHasAZeroBalance(){
        try {
            assertEquals(0,account.checkBalance("1234"));
        } catch (InvalidPinException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAccountPinThrowsException_whenInvalidPinLengthIsInputWhenCreatingAccount(){
        assertThrows(InvalidPinException.class,()->new Account("Abike","1hdjdk",2));
    }
    @Test
    public void testAccountPinThrowsException_whenInvalidPinIsInputToCheckBalance(){
        assertThrows(InvalidPinException.class,()->account.checkBalance("1235"));
    }

    @Test
    public void testDepositNegativeAmount_ThrowsException(){
        assertThrows(InvalidAmountException.class,()->account.deposit(-5000));
    }

    @Test
    public void testDepositAmount_BalanceIncreases(){
        try {
            account.deposit(10_000);
            assertEquals(10_000, account.checkBalance("1234"));
        } catch (InvalidAmountException | InvalidPinException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void withdrawNegativeAmount_ThrowsExceptionTest(){
        assertThrows(InsufficientFundsException.class,()->account.withdraw(-5000,"1234"));
    }

    @Test
    public void withdrawMoreThanAccountBalance_ThrowsExceptionTest() throws InvalidAmountException {

        account.deposit(10_000);

        assertThrows(InsufficientFundsException.class,()->account.withdraw(15000,"1234"));
    }



    @Test
    public void enterIncorrectPinUponWithdrawal_ThrowExceptionTest(){
        try {
            account.deposit(10_000);
        } catch (InvalidAmountException e) {
            throw new RuntimeException(e);
        }
        assertThrows(InvalidPinException.class,()->account.withdraw(15000,"1432"));
    }
}
