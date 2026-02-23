package Palindrome;

import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Deque<Character> deque = new LinkedList<>();

        System.out.print("Enter word: ");
        String word = sc.nextLine();

        for (char c : word.toCharArray()) {
            deque.add(c);
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

        sc.close();
    }
}