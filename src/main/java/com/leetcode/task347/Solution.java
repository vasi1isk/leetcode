package com.leetcode.task347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 347. Top K Frequent Elements
 */
public class Solution {
    public List<Integer> topKFrequent(List<Integer> nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        nums.forEach(num -> frequencyMap.merge(num, 1, Integer::sum));
        return frequencyMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> nums = Arrays.asList(1, 1, 1, 2, 2, 3);
        int k = 2;
        List<Integer> result = solution.topKFrequent(nums, k);
        System.out.println("Result: " + result);
    }
} 