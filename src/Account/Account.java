package Account;

import Account.Exceptions.InsufficientFundsException;
import Account.Exceptions.InvalidAmountException;
import Account.Exceptions.InvalidPinException;


import java.util.Objects;

public class Account {
    private final String name;
    private int balance;
    private final String pin;
    protected int number;


    public Account(String name, String pin, int accountNumber){
        if (pin.length() != 4)throw new InvalidPinException("Pin Should be four digits");
        this.name = name;
        this.pin = pin;
        this.number = accountNumber;


    }
    public int checkBalance(String pin){
        validatePin(pin);
        return balance;
    }

    public int getAccountNumber(){

        return number;
    }


    public void deposit(int amount){
        if (amount < 0)throw new InvalidAmountException("Cannot deposit negative amount");
        balance += amount;
    }

    private void validatePin(String pin){
        if (!this.pin.equals(pin))throw new InvalidPinException("Invalid Pin Try " +
                "Again");

    }

    public boolean verifyPin(String pin){
        return this.pin.equals(pin);
    }
    public void withdraw(int amount,String pin){
        validatePin(pin);
        if (amount < 0 || amount > balance)throw new InsufficientFundsException("Insufficient " +
                "Funds");
        balance -= amount;
    }
}
