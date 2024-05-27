package ru.marinin;

import java.util.Scanner;
import java.util.Stack;

public class ReversePolishNotationTask {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (!line.equals("*") && !line.equals("+") && !line.equals("-") && !line.equals(":")) {
                stack.push(Integer.parseInt(line));
            } else if (line.equals("+")) {
                stack.push(stack.pop()+stack.pop());
            } else if (line.equals("-")) {
                stack.push(-stack.pop()+stack.pop());
            } else if (line.equals("*")) {
                stack.push(stack.pop()*stack.pop());
            } else if (line.equals(":")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second/first);
            } else {
                throw new RuntimeException("некорректный пользовательский ввод!");
            }
        }
        System.out.println(stack.pop());
    }
}


