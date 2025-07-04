package com.basic;
import java.util.*;

public class OptimalPrimeGenerator {
    private final int maxValue;
    private final List<Integer> primes;
    private final Random random;
    
    public OptimalPrimeGenerator(int maxValue) {
        this.maxValue = maxValue;
        this.random = new Random();
        this.primes = new ArrayList<>();
        sieveOfEratosthenes(); // Используем эффективный алгоритм
    }
    
    private void sieveOfEratosthenes() {
        if (maxValue < 2) {
            return; // Нет простых чисел меньше 2
        }
        
        // Создаем булев массив и помечаем все числа как потенциально простые
        // Сложность по памяти: O(n)
        boolean[] isPrime = new boolean[maxValue + 1];
        Arrays.fill(isPrime, true); // Заполняем массив значениями true
        isPrime[0] = isPrime[1] = false; // 0 и 1 не являются простыми
        
        // Основной алгоритм решета
        // Проходим только до квадратного корня из maxValue
        for (int i = 2; i * i <= maxValue; i++) {
            if (isPrime[i]) {
                // Помечаем все кратные i как составные числа
                // Начинаем с i², так как меньшие кратные уже обработаны
                for (int j = i * i; j <= maxValue; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Собираем все простые числа в список
        for (int i = 2; i <= maxValue; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        System.out.println("Найдено простых чисел: " + primes.size() + 
                          " в диапазоне до " + maxValue);
    }
    
    public int getRandomPrime() {
        if (primes.isEmpty()) {
            throw new IllegalStateException("Нет простых чисел в диапазоне до " + maxValue);
        }
        return primes.get(random.nextInt(primes.size()));
    }
    
    public List<Integer> getPrimesInRange(int start, int end) {
        // Используем Stream API для фильтрации - современный подход Java
        return primes.stream()
                    .filter(prime -> prime >= start && prime <= end)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    public boolean isPrime(int number) {
        if (number > maxValue) {
            throw new IllegalArgumentException("Число " + number + 
                                             " превышает максимальное значение " + maxValue);
        }
        return Collections.binarySearch(primes, number) >= 0;
    }
    
    public List<Integer> getAllPrimes() {
        return new ArrayList<>(primes);
    }
    
    // Дополнительный метод для демонстрации работы с большими числами
    public long getPrimeProduct(int count) {
        if (count > primes.size()) {
            throw new IllegalArgumentException("Запрошено больше простых чисел, чем доступно");
        }
        
        return primes.stream()
                    .limit(count)
                    .mapToLong(Integer::longValue)
                    .reduce(1L, (a, b) -> a * b);
    }
}