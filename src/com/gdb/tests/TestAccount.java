package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {

    public static void main(String[] args) {

        System.out.println("=== Starting Account Test Suite ===");

        Account acc = new Account("ACC1001", "Rajesh Sharma", 28, 5000.0, "SAVINGS", "ACTIVE");

        if (acc.getAccountNumber().equals("ACC1001") &&
                acc.getName().equals("Rajesh Sharma") &&
                acc.getAge() == 28 &&
                acc.getBalance() == 5000.0 &&
                acc.getAccountType().equals("SAVINGS") &&
                acc.getStatus().equals("ACTIVE")) {
            System.out.println("Test 1: Initial Account Creation -> PASS");
        } else {
            System.out.println("Test 1: Initial Account Creation -> FAIL");
        }

        boolean depositResult = acc.deposit(1500.0);

        if (depositResult && acc.getBalance() == 6500.0) {
            System.out.println("Test 2: Valid Deposit (+1500.0) -> PASS [New Balance: " + acc.getBalance() + "]");
        } else {
            System.out.println("Test 2: Valid Deposit (+1500.0) -> FAIL");
        }

        boolean invalidDeposit = acc.deposit(-500.0);

        if (!invalidDeposit && acc.getBalance() == 6500.0) {
            System.out.println("Test 3: Invalid Deposit (-500.0) -> PASS [Rejected, Balance: " + acc.getBalance() + "]");
        } else {
            System.out.println("Test 3: Invalid Deposit (-500.0) -> FAIL");
        }

        boolean withdrawResult = acc.withdraw(2000.0);

        if (withdrawResult && acc.getBalance() == 4500.0) {
            System.out.println("Test 4: Valid Withdrawal (-2000.0) -> PASS [New Balance: " + acc.getBalance() + "]");
        } else {
            System.out.println("Test 4: Valid Withdrawal (-2000.0) -> FAIL");
        }

        double initialBalance = acc.getBalance();
        boolean overdraftResult = acc.withdraw(10000.0);

        if (!overdraftResult && acc.getBalance() == initialBalance) {
            System.out.println("Test 5: Overdraft Withdrawal (-10000.0) -> PASS [Rejected, Balance: " + acc.getBalance() + "]");
        } else {
            System.out.println("Test 5: Overdraft Withdrawal (-10000.0) -> FAIL");
        }

        System.out.println("=== All Tests Completed Successfully ===");
    }
}