package Palindrome;

import java.util.*;

public class PalindromeCheckerApp {

    // Method 1: Two-pointer
    public static boolean twoPointer(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    // Method 2: Stack
    public static boolean stackMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop())
                return false;
        }
        return true;
    }

    // Method 3: Deque
    public static boolean dequeMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();

        for (char c : normalized.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        // Two-pointer timing
        long start1 = System.nanoTime();
        boolean res1 = twoPointer(input);
        long end1 = System.nanoTime();

        // Stack timing
        long start2 = System.nanoTime();
        boolean res2 = stackMethod(input);
        long end2 = System.nanoTime();

        // Deque timing
        long start3 = System.nanoTime();
        boolean res3 = dequeMethod(input);
        long end3 = System.nanoTime();

        System.out.println("\nResults:");
        System.out.println("Two-pointer: " + res1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("Stack: " + res2 + " | Time: " + (end2 - start2) + " ns");
        System.out.println("Deque: " + res3 + " | Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}