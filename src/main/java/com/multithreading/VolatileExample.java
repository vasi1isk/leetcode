package com.multithreading;

public class VolatileExample {
    private volatile static boolean running = true; // Try with/without volatile
    private static int counter = 0;
    
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (running) {
                counter++; // This might prevent optimization
            }
            System.out.println("Worker stopped. Counter: " + counter);
        });
        
        worker.start();
        
        Thread.sleep(1000);
        
        System.out.println("Main thread setting running to false");
        running = false; // Worker might not see this change immediately
        
        worker.join();
        System.out.println("Main thread finished");
    }
}