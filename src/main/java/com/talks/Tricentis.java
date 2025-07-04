package com.talks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tricentis {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<>();

		System.out.println("Enter integers (0 to finish):");
		while (true) {
			int num = scanner.nextInt();
			if (num == 0) break;
			numbers.add(num);
		}

		if (numbers.isEmpty()) {
			System.out.println("No numbers entered.");
			return;
		}

		final int sum = computeSum(numbers);
		final double average = computeAverage(sum, numbers.size());
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + average);

		System.out.print("Numbers in reverse: ");

		List<Integer> reverseNumbers = new ArrayList<>();
		for (int i = numbers.size() - 1; i >= 0; i--) {
			reverseNumbers.add(numbers.get(i));
		}

		for(Integer number : reverseNumbers) {
			System.out.print(number + " ");
		}
	}

	// Method wihich shoulde be implemented by the candidate
	private static double computeAverage(int sum, int count) {
		if (count == 0) {
			return 0.0; // Avoid division by zero
		}
		return (double) sum / count;	
	}

	// Method wihich shoulde be implemented by the candidate
	private static int computeSum(List<Integer> numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return 0; // Handle empty list case
		}
		return numbers.stream()
				.mapToInt(Integer::intValue)
				.sum();
	}
}