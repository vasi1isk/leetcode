package com.patterns;

public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    
    private EagerSingleton() {
        // Конструктор
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}