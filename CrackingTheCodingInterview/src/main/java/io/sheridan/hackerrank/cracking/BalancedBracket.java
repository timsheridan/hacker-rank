package io.sheridan.hackerrank.cracking;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public final class BalancedBracket {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            System.out.println(isBalanced(expression) ? "YES" : "NO");
        }

        scanner.close();
    }

    private static boolean isBalanced(String input) {
        if (input == null) {
            return true;
        }

        Deque<Character> deque = new ArrayDeque<>(input.length());

        for (int i = 0; i < input.length(); i++) {
            Character character = input.charAt(i);
            switch (character) {
            case '{':
            case '(':
            case '[':
                deque.push(character);
                break;
            case '}':
                if (deque.isEmpty() || deque.pop() != '{') {
                    return false;
                }
                break;
            case ']':
                if (deque.isEmpty() || deque.pop() != '[') {
                    return false;
                }
                break;
            case ')':
                if (deque.isEmpty() || deque.pop() != '(') {
                    return false;
                }
                break;
            }
        }
        return deque.isEmpty();
    }
}

