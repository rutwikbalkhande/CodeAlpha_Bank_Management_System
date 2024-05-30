package com.bank.controller;

import java.util.Scanner;

import com.bank.entity.Customer;
import com.bank.service.BankService;

public class BankController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService();

        // Temporary data for 5 customers
        bankService.addCustomer(new Customer("John Doe", "123456", 1000));
        bankService.addCustomer(new Customer("Jane Smith", "654321", 500));
        bankService.addCustomer(new Customer("Alice Johnson", "987654", 1500));
        bankService.addCustomer(new Customer("Bob Brown", "456789", 200));
        bankService.addCustomer(new Customer("Charlie Davis", "987123", 3000));

        while (true) {
            System.out.println("\nWelcome to the Bank Management System");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String depositAccount = scanner.next();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankService.deposit(depositAccount, depositAmount);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String withdrawAccount = scanner.next();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankService.withdraw(withdrawAccount, withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String checkBalanceAccount = scanner.next();
                    bankService.checkBalance(checkBalanceAccount);
                    break;
                case 4:
                    System.out.println("Thank you for using the Bank Management System.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
