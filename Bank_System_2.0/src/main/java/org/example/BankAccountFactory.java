package org.example;

public class BankAccountFactory {

    public BankAccount createBankAccount(String accountType, String accountNumber, String accountName){
        if(accountType == null) return null;
        switch(accountType.toLowerCase()){
            case "savings": return new SavingsAccount(accountType,accountNumber,accountName);
            case "checking": return new CheckingAccount(accountType,accountNumber,accountName);
            default: return null;
        }
    }
}
