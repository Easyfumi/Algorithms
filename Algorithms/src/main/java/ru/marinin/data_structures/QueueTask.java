package ru.marinin.data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueueTask {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while (!string.equals("Смена закончилась!")) {

            if (string.equals("новичок:")) {
                String name = scanner.nextLine();
                queue.push(name);
                string = scanner.nextLine();
            } else if (string.equals("следующий")) {
                System.out.println(queue.top());
                queue.pop();
                if (queue.isEmpty()) {
                    System.out.println("Все вылечены!");
                    break;
                } else {
                    string = scanner.nextLine();
                }
            }
        }
    }
}

class Queue {
    private Stack leftStack;
    private Stack rightStack;

    public Queue() {
        leftStack = new Stack();
        rightStack = new Stack();
    }

    public void push(String string) {
        leftStack.push(string);
    }

    public void pop() {
        if (this.isEmpty()) {
            return;
        }
        if (rightStack.isEmpty().equals("Пуст")) {
            transfer();
            rightStack.pop();
        } else {
            rightStack.pop();
        }
    }

    public String top() {
        if (this.isEmpty()) {
            return "";
        }
        if (rightStack.isEmpty().equals("Пуст")) {
            transfer();
            return rightStack.top();
        } else {
            return rightStack.top();
        }
    }


    private void transfer() {
        while (leftStack.isEmpty() != "Пуст") {
            rightStack.push(leftStack.top());
            leftStack.pop();
        }
    }

    public boolean isEmpty() {
        if (leftStack.isEmpty().equals("Пуст") && rightStack.isEmpty().equals("Пуст")) {
            return true;
        } else {
            return false;
        }
    }
}

class Stack {
    private List<String> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public void push(String string) {
        list.add(string);
    }

    public String top() {
        return list.get(list.size() - 1);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public String isEmpty() {
        if (!list.isEmpty()) {
            return "Не пуст";
        } else {
            return "Пуст";
        }
    }
}
