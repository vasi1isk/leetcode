package main.java.com.patterns;

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        // Конструктор
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
