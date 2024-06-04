package ru.marinin.data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackTask {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine();
            if (string.equals("is_empty")) {
                System.out.println(stack.isEmpty());
            } else if (string.equals("push")) {
                Integer num = Integer.parseInt(scanner.nextLine());
                stack.push(num);
            } else if (string.equals("top")) {
                System.out.println(stack.top());
            } else if (string.equals("pop")) {
                stack.pop();
            }
        }
    }
}

class Stack {
    private List<Integer> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public void push(Integer num) {
        list.add(num);
    }

    public Integer top() {
        return list.get(list.size()-1);
    }

    public void pop() {
        list.remove(list.size()-1);
    }

    public String isEmpty() {
        if (!list.isEmpty()) {
            return "Не пуст";
        } else {
            return "Пуст";
        }
    }
}
