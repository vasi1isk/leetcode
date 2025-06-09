package com.algorithms;

public class MaxNumberInArray {
    public int maxNumberInArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxNumberInArray solution = new MaxNumberInArray();
        int[] array = {1, 2, 3, 4, -5};
        int max = solution.maxNumberInArray(array);
        System.out.println("Max number in array: " + max);
    }

}
