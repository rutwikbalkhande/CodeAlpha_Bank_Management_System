package com.bank.service;

import java.util.ArrayList;
import java.util.List;

import com.bank.entity.Customer;

public class BankService {
    public List<Customer> customers;

    public BankService() {
        this.customers = new ArrayList<>();
    }

    // Add customer to the bank
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Deposit money into a customer's account
    public void deposit(String accountNumber, double amount) {
        for (Customer customer : customers) {
            if (customer.getAccountNumber().equals(accountNumber)) {
                double currentBalance = customer.getBalance();
                customer.setBalance(currentBalance + amount);
                System.out.println("Deposit of $" + amount + " successful.");
                return;
            }
        }
        System.out.println("Customer with account number " + accountNumber + " not found.");
    }

    // Withdraw money from a customer's account
    public void withdraw(String accountNumber, double amount) {
        for (Customer customer : customers) {
            if (customer.getAccountNumber().equals(accountNumber)) {
                double currentBalance = customer.getBalance();
                if (currentBalance >= amount) {
                    customer.setBalance(currentBalance - amount);
                    System.out.println("Withdrawal of $" + amount + " successful.");
                } else {
                    System.out.println("Insufficient balance.");
                }
                return;
            }
        }
        System.out.println("Customer with account number " + accountNumber + " not found.");
    }

    // Check balance of a customer's account
    public void checkBalance(String accountNumber) {
        for (Customer customer : customers) {
            if (customer.getAccountNumber().equals(accountNumber)) {
                System.out.println("Balance for account number " + accountNumber + ": $" + customer.getBalance());
                return;
            }
        }
        System.out.println("Customer with account number " + accountNumber + " not found.");
    }
}
