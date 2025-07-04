package com.basic;

public class Parentheses<T extends Comparable<T>> {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false; // Нечетная длина строки не может быть валидной
        }

        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false; // Закрывающая скобка без соответствующей открывающей
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false; // Несоответствие скобок
                }
            }
        }
        return stack.isEmpty(); // Если стек пуст, все скобки закрыты правильно
    }

    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        Parentheses solution = new Parentheses();
        
        // Тестовые случаи
        System.out.println(solution.isValid("()")); // true
        System.out.println(solution.isValid("()[]{}")); // true
        System.out.println(solution.isValid("(]")); // false
        System.out.println(solution.isValid("([)]")); // false
        System.out.println(solution.isValid("{[]}")); // true
    }
}
