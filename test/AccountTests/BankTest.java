package AccountTests;

import Account.Account;
import Account.Bank;
import Account.Exceptions.AccountNotFound;
import Account.Exceptions.InsufficientFundsException;
import Account.Exceptions.InvalidAmountException;
import Account.Exceptions.InvalidPinException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void testBankCanDepositIntoCustomersAccount(){
        Bank bank = new Bank("MohBank");
        Account account1 = bank.registerCustomer("Moh","baba","1234");
        bank.deposit(5000, account1.getAccountNumber());
        assertEquals(5000, account1.checkBalance("1234"));
    }

    @Test
    public void testBankCanWithdrawFromCustomersAccount(){
        Bank bank = new Bank("MohBank");
        Account account1 = bank.registerCustomer("Moh","baba","1234");

        bank.deposit(5000, 1);
        bank.withdraw(2000, 1,"1234");
        assertEquals(3000, account1.checkBalance("1234"));
    }

    @Test
    public void depositNegativeAmount_ThrowExceptionTest(){
        Bank bank = new Bank("MohBank");
        Account account1 = bank.registerCustomer("Moh","baba","1234");

        assertThrows(InvalidAmountException.class,()->bank.deposit(-5000,
                1));
    }

    @Test
    public void withdrawNegativeAmount_ThrowExceptionTest(){
        Bank bank = new Bank("MohBank");
        Account account1 = bank.registerCustomer("Moh","baba","1234");
        assertThrows(InsufficientFundsException.class,()->bank.withdraw(-5000,
                1,"1234"));
    }

    @Test
    public void withdrawAmountWithIncorrectPin_ThrowExceptionTest(){
        Bank bank = new Bank("MohBank");
        Account account1 = bank.registerCustomer("Moh","baba","1234");
        assertThrows(InvalidPinException.class,()->bank.withdraw(5000,
                1,"12y4"));
    }

    @Test
    public void transferMoneyFromAccountToAccountTest() throws InvalidAmountException, InvalidPinException, InsufficientFundsException {
        Bank bank = new Bank("MohBank");
        Account account1 = bank.registerCustomer("Moh","baba","1234");
        Account account2 = bank.registerCustomer("Bolaji","Dayo","1234");
        Account account3 = bank.registerCustomer("Abike","Dayo","1234");

        bank.deposit(250_000,1);
        bank.transfer(1,2,200_000,"1234");
        assertEquals(200_000,bank.checkBalance(2,"1234"));

    }

    @Test
    public void transferNegativeMoneyFromAccountToAccount(){
        Bank bank = new Bank("MohBank");
        Account account1 = bank.registerCustomer("Moh","baba","1234");
        Account account2 = bank.registerCustomer("Bolaji","Dayo","1234");
        Account account3 = bank.registerCustomer("Abike","Dayo","1234");
        assertThrows(InsufficientFundsException.class,()->bank.transfer(1,2,-50_000,"1234"));

    }

    @Test
    public void removeAccountFromListOfAccountsTest(){
        Bank bank = new Bank("MohBank");
        Account account1 = bank.registerCustomer("Moh","baba","1234");
        bank.removeAccount(1,"1234");
        assertEquals(0,bank.noOfCustomers);
    }

    @Test
    public void testFindAccountReturnsAccount() throws InvalidPinException {
        Bank bank = new Bank("MohBank");
        Account account1 = bank.registerCustomer("Moh","baba","1234");
        assertNotNull(bank.findAccount(1));
    }

    @Test
    public void testFindUnexistingAccount_returnsNull(){
        Bank bank = new Bank("MohBank");
        assertNull(bank.findAccount(99));
    }

    @Test
    public void testDepositIntoAnAccountThatDoesntExist_ThrowsAccountNotFoundError(){
        Bank bank = new Bank("MohBank");
        assertThrows(AccountNotFound.class, ()->bank.deposit(1000,99));
    }

    @Test
    public void testWithdrawFromAnAccountThatDoesntExist_ThrowsAccountNotFoundError(){
        Bank bank = new Bank("MohBank");
        assertThrows(AccountNotFound.class, ()->bank.withdraw(1000,99,"1234"));
    }

    @Test
    public void removeAccount_TestIfAccountStillExistsAfterRemoving(){
        Bank bank = new Bank("MohBank");
        Account account1 = bank.registerCustomer("Moh","baba","1234");
        Account account2 = bank.registerCustomer("Beejay","Lasgidi","1234");
        Account account3 = bank.registerCustomer("Magnus","Carlsen","1234");

        bank.removeAccount(2,"1234");
        assertNull(bank.findAccount(2));
        assertEquals(2,bank.noOfCustomers);
    }

    @Test
    public void removeAccount_TestIfAccountCanBeDepositedIntoAfterRemoving(){
        Bank bank = new Bank("MohBank");
        Account account1 = bank.registerCustomer("Moh","baba","1234");
        Account account2 = bank.registerCustomer("Beejay","Lasgidi","1234");
        Account account3 = bank.registerCustomer("Magnus","Carlsen","1234");

        bank.removeAccount(2,"1234");
        assertThrows(AccountNotFound.class,()->bank.deposit(2000,2));
    }


}
