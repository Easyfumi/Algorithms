package ru.marinin;


import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesesTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(checkParentheses(string));
    }

    public static String checkParentheses(String string) {
        Stack<Character> stack = new Stack<>();
        for (char c : string.toCharArray()) {
            if ((c != ']' && c != '}' && c != ')' && c != '[' && c != '{' && c != '(')) {

            } else if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return "INCORRECT";
            }
        }
        if (!stack.isEmpty()) {
            return "INCORRECT";
        } else {
            return "CORRECT";
        }
    }
}


