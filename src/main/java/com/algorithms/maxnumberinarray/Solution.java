package main.java.com.algorithms.maxnumberinarray;

public class Solution {
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
        Solution solution = new Solution();
        int[] array = {1, 2, 3, 4, -5};
        int max = solution.maxNumberInArray(array);
        System.out.println("Max number in array: " + max);
    }

}
