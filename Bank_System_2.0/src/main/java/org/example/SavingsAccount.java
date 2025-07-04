package org.example;

public class SavingsAccount extends BankAccount{

    public SavingsAccount (String accountType, String accountNumber, String accountName){
        super(accountType,accountNumber,accountName);
    }

    @Override
    public void computeInterest() {
        System.out.println("Computing interest for account " + accountNumber + "...");
        System.out.println("Current balance: " + availableBalance);

        // four percent interest
        double savingsInterest = availableBalance * 0.04;
        System.out.println("Interest earned: " + savingsInterest);

        availableBalance += savingsInterest;

        System.out.println("New balance: " + availableBalance);
    }
}
