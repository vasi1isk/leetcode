package com.talks.barclays.multithreading;

public class BankAccount {
    private volatile double balance = 1000.0;
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            // Simulate some processing time
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + 
                " withdrew: " + amount + ", remaining: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + 
                " insufficient funds for: " + amount);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        
        // Multiple threads trying to withdraw
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> account.withdraw(300), "Thread-" + i);
            threads[i].start();
        }
        
        for (Thread t : threads) {
            t.join();
        }
        
        System.out.println("Final balance: " + account.balance);
    }
}
