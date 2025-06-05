package main.java.com.algorithms.longestsubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // Если символ уже есть в множестве, двигаем левую границу
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Добавляем текущий символ в множество
            set.add(currentChar);
            
            // Обновляем максимальную длину
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Тестовые случаи
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // 3
    }
} 