package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountFactoryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private BankAccountFactory bankAccountFactory;



    @BeforeEach
    void setup(){
        System.setOut(new PrintStream(outContent));
        bankAccountFactory = new BankAccountFactory();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testSavingsAccountCreation(){
        BankAccount savingsAccount = bankAccountFactory.createBankAccount("Savings", "58229", "John Doe");
        String accountType = savingsAccount.accountType;
        String expected = "Savings";
        assertEquals(expected, accountType);

    }

    @Test
    void testCheckingAccountCreation(){
        BankAccount checkingAccount = bankAccountFactory.createBankAccount("Checking", "7384", "John Doe");
        String accountType = checkingAccount.accountType;
        String expected = "Checking";
        assertEquals(expected, accountType);
    }

    @Test
    void testNullAccountTypeAccountCreation(){
        BankAccount nullAccountTypeAccount = bankAccountFactory.createBankAccount(null, "58229", "John Doe");
        assertNull(nullAccountTypeAccount);

    }

    @Test
    void testInvalidAccountTypeAccountCreation(){
        BankAccount invalidAccount = bankAccountFactory.createBankAccount("Invalid", "58229", "John Doe");
        assertNull(invalidAccount);

    }

    @Test
    void testDepositValidAmount(){
        BankAccount savingsAccount = bankAccountFactory.createBankAccount("Savings", "58229", "John Doe");
        savingsAccount.deposit(200);
        double currentBalance = savingsAccount.availableBalance;
        double expected = 200;
        assertEquals(expected, currentBalance);
    }

    @Test
    void testDepositInvalidAmount(){
        BankAccount checkingAccount = bankAccountFactory.createBankAccount("Checking", "7384", "John Doe");
        checkingAccount.deposit(-25);
        double currentBalance = checkingAccount.availableBalance;
        double expected = 0;
        assertEquals(expected, currentBalance);
    }

    @Test
    void testWithdrawValidAmount(){
        BankAccount checkingAccount = bankAccountFactory.createBankAccount("Checking", "7384", "John Doe");
        checkingAccount.deposit(500);
        checkingAccount.withdraw(200);
        double currentBalance = checkingAccount.availableBalance;
        double expected = 300;
        assertEquals(expected, currentBalance);
    }

    @Test
    void testWithdrawInvalidAmount(){
        BankAccount savingsAccount = bankAccountFactory.createBankAccount("Savings", "58229", "John Doe");
        savingsAccount.deposit(500);
        savingsAccount.withdraw(700);
        double currentBalance = savingsAccount.availableBalance;
        double expected = 500;
        assertEquals(expected, currentBalance);
        savingsAccount.withdraw(-50);
        currentBalance = savingsAccount.availableBalance;
        assertEquals(expected, currentBalance);
    }

    @Test
    void testSavingsAccountInterestComputation(){
        BankAccount savingsAccount = bankAccountFactory.createBankAccount("Savings", "58229", "John Doe");
        savingsAccount.deposit(1000);
        savingsAccount.computeInterest();
        double currentBalance = savingsAccount.availableBalance;
        double expected = 1040;

        assertEquals(expected, currentBalance);
    }

    @Test
    void testCheckingAccountInterestComputation(){
        BankAccount checkingAccount = bankAccountFactory.createBankAccount("Checking", "7384", "John Doe");
        checkingAccount.deposit(1000);
        checkingAccount.computeInterest();
        double currentBalance = checkingAccount.availableBalance;
        double expected = 1010;

        assertEquals(expected, currentBalance);
    }

    @Test
    public void testDisplayDetails() {
        BankAccount checkingAccount = bankAccountFactory.createBankAccount("Checking", "7384", "John Doe");

        checkingAccount.displayDetails();

        String expectedOutput = String.format(
                "Account Type: Checking%n" +
                "Account Number: 7384%n" +
                "Account Name: John Doe%n" +
                "Available Balance: 0.00%n: "
        );

        assertEquals(expectedOutput, outContent.toString());
    }

    /*
    Verify account creation
    Test deposit and withdraw accuracy
    Validate interest computation
    Ensure singleton instance

     */
}