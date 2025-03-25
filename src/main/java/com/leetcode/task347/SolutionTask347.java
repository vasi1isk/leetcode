package main.java.com.leetcode.task347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 347. Top K Frequent Elements
 */
public class SolutionTask347 {
    public List<Integer> topKFrequent(List<Integer> nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>(); // Define map to store frequency of nums
        nums.forEach(num -> frequencyMap.merge(num, 1, Integer::sum)); // fill in this map
        return frequencyMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sorting by frequency in desc order
                .limit(k) // Select first k the most frequent elements in sorted map
                .map(Map.Entry::getKey)// transform map saying give me only keys
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SolutionTask347 solutionTask347 = new SolutionTask347();
        List<Integer> nums = Arrays.asList(1, 1, 1, 2, 2, 3);
        int k = 2;
        List<Integer> result = solutionTask347.topKFrequent(nums, k);
        System.out.println("Result: " + result);
    }
} 