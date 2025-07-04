package org.example;

public class CheckingAccount extends BankAccount{

    public CheckingAccount (String accountType, String accountNumber, String accountName){
        super(accountType,accountNumber,accountName);

    }

    @Override
    public void computeInterest() {
        System.out.println("Computing interest for account " + accountNumber + "...");
        System.out.println("Current balance: " + availableBalance);
        
        double checkingInterest = availableBalance * 0.5;
        System.out.println("Interest earned: " + checkingInterest);

        availableBalance += checkingInterest;

        System.out.println("New balance: " + availableBalance);
    }
}
