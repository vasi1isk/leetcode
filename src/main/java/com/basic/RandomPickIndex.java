package com.basic;

import java.util.Random;

public class RandomPickIndex {
    private int[] nums;
    private Random rand;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                // С вероятностью 1/count выбираем текущий индекс
                if (rand.nextInt(count) == 0) {
                    result = i;
                }
                
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Пример использования
        int[] nums = {1, 2, 3, 3, 3};
        RandomPickIndex randomPickIndex = new RandomPickIndex(nums);
        
        // Пытаемся выбрать индекс для числа 3
        int index = randomPickIndex.pick(3);
        System.out.println("Random index for target 3: " + index);
        
        // Пытаемся выбрать индекс для числа 1
        index = randomPickIndex.pick(1);
        System.out.println("Random index for target 1: " + index);
    }
}
