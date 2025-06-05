package main.java.com.patterns;

class LazySingletonSync {
    private static LazySingletonSync instance;

    private LazySingletonSync() {
        // Конструктор
    }

    public static synchronized LazySingletonSync getInstance() {
        if (instance == null) {
            instance = new LazySingletonSync();
        }
        return instance;
    }
}
