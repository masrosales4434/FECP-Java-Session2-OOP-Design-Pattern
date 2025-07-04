package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> listOfBankAccounts = new ArrayList<>();
        BankAccountFactory bankAccountFactory = new BankAccountFactory();

        Scanner scanner = new Scanner(System.in);
        int choice;
        String accountType = "";
        String accountNumber = "";
        String bankAccountHolderName = "";
        String initialDeposit = "";

        System.out.println("===== Welcome to MyBank =====");

        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Compute Interest");
        System.out.println("5. Display Account");
        System.out.println("6. Exit");

        do {
            System.out.print("\n Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
            case 1:
                System.out.print("Enter Account Type: ");
                accountType = scanner.nextLine();

                System.out.print("Enter Account Number: ");
                accountNumber = scanner.nextLine();

                System.out.print("Enter Holder Name: ");
                bankAccountHolderName = scanner.nextLine();

                System.out.print("Initial deposit? (yes/no): ");
                initialDeposit = scanner.nextLine();

                if(initialDeposit.equals("yes")){
                    System.out.print("Enter initial deposit amount: ");
                    float initialDepositAmount = scanner.nextFloat();
                    scanner.nextLine();

                    BankAccount createdBankAccount = bankAccountFactory.createBankAccount(accountType,accountNumber,bankAccountHolderName);

                    createdBankAccount.deposit(initialDepositAmount);
                    listOfBankAccounts.add(createdBankAccount);


                } else{
                    listOfBankAccounts.add(bankAccountFactory.createBankAccount(accountType,accountNumber,bankAccountHolderName));
                }

                System.out.println("Account created successfully!");
                break;

            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:
                System.out.println("-----Thank you for banking with us!-----");
                break;
        }
    } while(choice != 6);
    }
}