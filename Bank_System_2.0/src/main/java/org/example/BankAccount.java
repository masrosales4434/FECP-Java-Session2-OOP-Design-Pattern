package org.example;

public abstract class BankAccount {
    protected String accountType;
    protected String accountNumber;
    protected String accountName;
    protected double availableBalance;

    public BankAccount(String accountType, String accountNumber, String accountName){
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.availableBalance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.availableBalance += amount;
            System.out.printf("Deposited %.2f%n", amount);
            System.out.printf("New Balance is now %.2f%n", this.availableBalance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.availableBalance) {
            this.availableBalance -= amount;
            System.out.printf("Withdrew %.2f%n", amount);
            System.out.printf("New Balance is now %.2f%n", this.availableBalance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public abstract void computeInterest();

    public void displayDetails() {
        System.out.println("Account Type: " + this.accountType);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Name: " + this.accountName);
        System.out.printf("Available Balance: %.2f%n ", this.availableBalance);
    }
}
