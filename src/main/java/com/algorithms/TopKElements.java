package com.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 347. Top K Frequent Elements
 */
public class TopKElements {
    public List<Integer> topKFrequent(List<Integer> nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>(); // Define map to store frequency of nums
        nums.forEach(num -> frequencyMap.merge(num, 1, Integer::sum)); // fill in this map
        return frequencyMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sorting by frequency in desc order
                .limit(k) // Select first k the most frequent elements in sorted map
                .map(Map.Entry::getKey)// transform map saying give me only keys
                .collect(Collectors.toList());
    }

    public List<Integer> topKFrequentWithoutStream(List<Integer> nums, int k){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if(!frequencyMap.containsKey(nums.get(i))) {
                frequencyMap.put(nums.get(i), 1);
            } else {
                frequencyMap.put(nums.get(i), frequencyMap.get(nums.get(i)) + 1);
            }
        }
        return frequencyMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sorting by frequency in desc order
                .limit(k)
                .map(Map.Entry::getKey) // transform map saying give me only keys
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        TopKElements solutionTask347 = new TopKElements();
        List<Integer> nums = Arrays.asList(1, 1, 1, 2, 2, 3);
        int k = 2;
        List<Integer> result = solutionTask347.topKFrequent(nums, k);
        System.out.println("Result: " + result);
    }
} 