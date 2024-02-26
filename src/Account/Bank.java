package Account;

import Account.Exceptions.AccountNotFound;
import Account.Exceptions.InvalidPinException;

import java.util.ArrayList;

public class Bank {
    private String name;
    public ArrayList<Account> accounts = new ArrayList<>();
    public int noOfCustomers;

    public Bank(String name){
        this.name = name;
    }

    public void  deposit(int amount, int accountNumber){
        Account account = findAccount(accountNumber);
        validateAccount(account);
        account.deposit(amount);
    }

    private static void validateAccount(Account account){
        if (account == null)throw new AccountNotFound("Account Not found");
    }

    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) return account;
        }

        return null;
    }



    public Account registerCustomer(String firstName, String lastName, String pin) {
        String name = firstName+" "+lastName;
        Account account = new Account(name,pin, generateAccountNumber());
        accounts.add(account);
        return account;
    }

    private int generateAccountNumber(){
        return ++noOfCustomers;
    }

    public void withdraw(int amount, int accountNumber, String pin){
        Account account = findAccount(accountNumber);
        validateAccount(account);
        account.withdraw(amount,pin);
    }

    public void transfer(int transferAccount, int receiverAccount, int amount, String pin){
        withdraw(amount,transferAccount,pin);
        deposit(amount,receiverAccount);
    }

    public int checkBalance(int accountNumber, String pin){
        Account account = findAccount(accountNumber);
        validateAccount(account);
        int  balance = account.checkBalance(pin);
        return balance;
    }

    private boolean validatePin(String pin , Account account){
        return account.verifyPin(pin);
    }

    public void removeAccount(int accountNumber, String pin) {
        Account account = findAccount(accountNumber);
        validateAccount(account);
        if (validatePin(pin,account)){
            accounts.remove(account);
            noOfCustomers--;
        }else{
            throw new InvalidPinException("Pin is Incorrect");
        }


    }



}
