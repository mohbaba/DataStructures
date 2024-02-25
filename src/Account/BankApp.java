package Account;

import Account.Exceptions.InvalidPinException;

import javax.swing.*;
import java.util.Scanner;

import static java.lang.System.exit;

public class BankApp {

    private static final Bank bank = new Bank("MohBank");

    public static void main(String[] args) {
        mainMenu();
    }
    public static void print(String message){
//        System.out.println(message);
        JOptionPane.showMessageDialog(null, message);
    }

    public static String input(String message){
//        print(message);
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextLine();
        return JOptionPane.showInputDialog(null, message);
    }

    public static void mainMenu(){
        print("""
                Welcome To MohBank!
                1-> Register Account
                2-> Deposit
                3-> Withdraw
                4-> Transfer
                5-> Check Balance
                6-> Exit App
                """);
        String input = input("");
        switch (input.charAt(0)){
            case '1':
                registerAccount();
                break;
            case  '2':
                deposit();
                break;
            case '3':
                withdraw();
                break;

            case '4':
                transfer();
                break;

            case '5':
                checkBalance();
                break;

            case '6':
                print("Thanks for banking with us ");
                exit(0);
            default:
                mainMenu();
        }
    }




    private static void registerAccount() {
        try {
            String firstName = input("Please enter your firstname");
            String lastName = input("Please enter your lastname");
            String pin = input("Please enter 4 character pin");
            Account account = bank.registerCustomer(firstName,lastName,pin);
            print("\n");
            print("*****Account Registered Successfully*****\n");
            print("Hello "+ firstName + " "+ lastName +" your account number is " + account.getAccountNumber());
        }catch (InvalidPinException message){
            print(message.getMessage());
        }finally {
            mainMenu();
        }

    }

    private static void deposit(){
        print("DEPOSIT MONEY\n");
        String accountNumber = input("Enter Account Number to deposit into: ");
        String amount = input("Enter amount you will like to deposit");
        try{
            bank.deposit(Integer.parseInt(amount),Integer.parseInt(accountNumber));
            print("***Amount deposited Successfully***\n");
        }catch (Exception message){
            print(message.getMessage());
        }finally {
            print("\n");
            mainMenu();
        }
    }

    public static void withdraw(){
        print("WITHDRAW MONEY");
        String amount = input("Enter Amount you'd like to withdraw: ");
        String accountNumber = input("Enter your account number: ");
        String pin = input("Enter 4 character pin");

        try {
            bank.withdraw(Integer.parseInt(amount),Integer.parseInt(accountNumber),pin);
            print("*****"+ amount +" withdrawn Successfully!*****" );
        }catch (Exception message){
            print(message.getMessage());
        }finally {
            print("\n");
            mainMenu();
        }
    }

    private static void transfer() {
        String sender = input("Enter Account number of the sender: ");
        String receiver = input("Enter Account number of receiver: ");
        String amount = input("Enter amount to transfer: ");
        String pin = input("Enter your pin: ");

        try {
            bank.transfer(Integer.parseInt(sender),Integer.parseInt(receiver),
                    Integer.parseInt(amount),pin);
            print("*****"+ amount+ " transferred successfully from "+ sender +"to "+receiver+
                    "*****");
        }catch (Exception message){
            print(message.getMessage());
        }finally {
            mainMenu();
        }

    }

    private static void checkBalance() {
        print("BALANCE");
        String accountNumber = input("Enter Account Number: ");
        String pin = input("Enter pin: ");

        try {
            int balance = bank.checkBalance(Integer.parseInt(accountNumber),pin);
            print("Your Account balance is "+ balance);
        }catch (Exception message){
            print(message.getMessage());
        }finally {
            mainMenu();
        }

    }
}
