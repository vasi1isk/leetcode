package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Сортируем интервалы по начальной точке
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            
            // Если интервалы пересекаются, объединяем их
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                // Если не пересекаются, добавляем текущий в результат
                merged.add(current);
                current = next;
            }
        }
        
        // Добавляем последний интервал
        merged.add(current);
        
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        
        // Тестовые случаи
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result1 = mergeIntervals.merge(intervals1);
        System.out.println("Example 1: " + Arrays.deepToString(result1));
        // Output: [[1,6],[8,10],[15,18]]
        
        int[][] intervals2 = {{1,4},{4,5}};
        int[][] result2 = mergeIntervals.merge(intervals2);
        System.out.println("Example 2: " + Arrays.deepToString(result2));
        // Output: [[1,5]]
    }
} 