package com.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OptimalRandomGenerator {
    private final List<Integer> availableNumbers;
    private int currentIndex;
    private final Random random;
    
    public OptimalRandomGenerator(int maxValue) {
        // Инициализируем список всех доступных чисел
        this.availableNumbers = new ArrayList<>(maxValue);
        for (int i = 1; i <= maxValue; i++) {
            availableNumbers.add(i);
        }
        this.currentIndex = availableNumbers.size();
        this.random = new Random();
    }
    
    public int getNextRandom() {
        if (currentIndex == 0) {
            throw new IllegalStateException("Все числа уже использованы");
        }
        
        // Выбираем случайный индекс из оставшихся доступных
        int randomIndex = random.nextInt(currentIndex);
        
        // Получаем число по выбранному индексу
        int selectedNumber = availableNumbers.get(randomIndex);
        
        // Применяем алгоритм Fisher-Yates: меняем местами выбранный элемент 
        // с последним доступным элементом
        availableNumbers.set(randomIndex, availableNumbers.get(currentIndex - 1));
        availableNumbers.set(currentIndex - 1, selectedNumber);
        
        currentIndex--; // Уменьшаем количество доступных чисел
        return selectedNumber;
    }
    
    public void reset() {
        // Восстанавливаем исходное состояние
        currentIndex = availableNumbers.size();
        // Можно также пересоздать список, если нужна исходная последовательность
    }
    
    public boolean hasNext() {
        return currentIndex > 0;
    }
    public static void main(String[] args) {
        OptimalRandomGenerator generator = new OptimalRandomGenerator(10);
        
        while (generator.hasNext()) {
            System.out.println(generator.getNextRandom());
        }
        
        // Пример повторного использования
        generator.reset();
        System.out.println("После сброса:");
        while (generator.hasNext()) {
            System.out.println(generator.getNextRandom());
        }
    }
}
