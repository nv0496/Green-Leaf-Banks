package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {

    public static void main(String[] args) {

        System.out.println("=== Starting Enhanced Account Tests ===");

        Account acc = new Account("ACC2001", "Bob", 30, 5000.0, "SAVINGS", "Active", "1234");

        System.out.println("Account created successfully: " + acc.getAccountNumber() +
                " (Holder: " + acc.getName() + ", Age: " + acc.getAge() + ")");

        if (acc.validatePin("1234")) {
            System.out.println("PIN Validation (Correct: '1234'): PASS");
        } else {
            System.out.println("PIN Validation (Correct: '1234'): FAIL");
        }

        if (!acc.validatePin("9999")) {
            System.out.println("PIN Validation (Wrong: '9999'): PASS (Correctly rejected)");
        } else {
            System.out.println("PIN Validation (Wrong: '9999'): FAIL");
        }

        if (acc.deposit(2000.0) && acc.getBalance() == 7000.0) {
            System.out.println("Deposit on Active Account: PASS (New Balance: " + acc.getBalance() + ")");
        } else {
            System.out.println("Deposit on Active Account: FAIL");
        }

        acc.setStatus("Inactive");

        double initialBalance = acc.getBalance();

        if (!acc.withdraw(1000.0) && acc.getBalance() == initialBalance) {
            System.out.println("Withdrawal on Inactive Account: PASS (Correctly blocked)");
        } else {
            System.out.println("Withdrawal on Inactive Account: FAIL");
        }

        System.out.println("=== Enhanced Account Tests Completed ===");
    }
}