package com.basic;

import java.util.*;

public class OptimalCardShuffle {
    private final String[] originalDeck;
    private String[] currentDeck;
    private final Random random;
    
    public OptimalCardShuffle() {
        this.originalDeck = createStandardDeck();
        this.currentDeck = Arrays.copyOf(originalDeck, originalDeck.length);
        this.random = new Random();
    }
    
    private String[] createStandardDeck() {
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] deck = new String[52];
        
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + suit;
            }
        }
        return deck;
    }
    
    public String[] shuffle() {
        // Алгоритм Fisher-Yates: O(n) время, O(1) дополнительная память
        // Идем с конца массива к началу
        for (int i = currentDeck.length - 1; i > 0; i--) {
            // Выбираем случайный индекс от 0 до i включительно
            int randomIndex = random.nextInt(i + 1);
            
            // Меняем элементы местами
            String temp = currentDeck[i];
            currentDeck[i] = currentDeck[randomIndex];
            currentDeck[randomIndex] = temp;
        }
        
        return Arrays.copyOf(currentDeck, currentDeck.length);
    }
    
    public String[] reset() {
        currentDeck = Arrays.copyOf(originalDeck, originalDeck.length);
        return currentDeck;
    }
    
    public void printDeck() {
        System.out.println("Текущая колода: " + Arrays.toString(currentDeck));
    }
    
    // Дополнительный метод для демонстрации работы с коллекциями
    public List<String> shuffleAsList() {
        shuffle(); // Сначала перемешиваем массив
        return new ArrayList<>(Arrays.asList(currentDeck));
    }

    public static void main(String[] args) {
        OptimalCardShuffle cardShuffle = new OptimalCardShuffle();
        
        System.out.println("Исходная колода:");
        cardShuffle.printDeck();
        
        System.out.println("\nПеремешанная колода:");
        String[] shuffledDeck = cardShuffle.shuffle();
        cardShuffle.printDeck();
        
        System.out.println("\nСброс колоды:");
        cardShuffle.reset();
        cardShuffle.printDeck();
        
        System.out.println("\nПеремешанная колода как список:");
        List<String> shuffledList = cardShuffle.shuffleAsList();
        System.out.println(shuffledList);
    }
}