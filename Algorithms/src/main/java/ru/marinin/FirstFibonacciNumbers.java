package ru.marinin;

import java.util.Scanner;

public class FirstFibonacciNumbers {    // первые числа Фибоначчи
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();

        int first = 0;
        int second = 1;

        StringBuilder stringBuilder = new StringBuilder().append(first);

        if (n == 0) {
            System.out.println(stringBuilder);
        } else if (n == 1) {
            stringBuilder.append(" ").append(second);
            System.out.println(stringBuilder);
        } else {
            stringBuilder.append(" ").append(second);
            for (int i = 2; i < n;  i++) {
                int number = first + second;
                first = second;
                second = number;
                stringBuilder.append(" " + number);
            }
            System.out.println(stringBuilder);
        }
    }
}
