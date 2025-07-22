package com.talks.barclays.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperations {
    private static int normalCounter = 0;
    private static AtomicInteger atomicCounter = new AtomicInteger(0);
    
    public static void incrementNormal() {
        for (int i = 0; i < 10000; i++) {
            normalCounter++; // Race condition prone
        }
    }
    
    public static void incrementAtomic() {
        for (int i = 0; i < 10000; i++) {
            atomicCounter.incrementAndGet(); // Thread-safe
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread[] normalThreads = new Thread[10];
        Thread[] atomicThreads = new Thread[10];
        
        // Test normal counter
        for (int i = 0; i < 10; i++) {
            normalThreads[i] = new Thread(() -> incrementNormal());
            normalThreads[i].start();
        }
        
        // Test atomic counter
        for (int i = 0; i < 10; i++) {
            atomicThreads[i] = new Thread(() -> incrementAtomic());
            atomicThreads[i].start();
        }
        
        // Wait for all threads
        for (Thread t : normalThreads) {
            t.join();
        }
        for (Thread t : atomicThreads) {
            t.join();
        }
        
        System.out.println("Normal counter (expected 100000): " + normalCounter);
        System.out.println("Atomic counter (expected 100000): " + atomicCounter.get());
    }
}