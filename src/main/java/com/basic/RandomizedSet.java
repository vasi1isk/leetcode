package com.basic;
import java.util.*;


public class RandomizedSet {
    private final List<Integer> nums;
    private final Map<Integer, Integer> valToIndex;
    private final Random rand;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        nums.add(val);
        valToIndex.put(val, nums.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int idx = valToIndex.get(val);
        int lastVal = nums.get(nums.size() - 1);
        nums.set(idx, lastVal);
        valToIndex.put(lastVal, idx);
        nums.remove(nums.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int idx = rand.nextInt(nums.size());
        return nums.get(idx);
    }

    public static void main(String[] args) {
       RandomizedSet randomizedSet = new RandomizedSet();
       System.out.println(randomizedSet.insert(1)); // true
       System.out.println(randomizedSet.remove(2)); // false
       System.out.println(randomizedSet.insert(2)); // true 

    }
}