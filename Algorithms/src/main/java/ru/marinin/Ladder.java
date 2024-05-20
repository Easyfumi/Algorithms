package ru.marinin;

import java.util.Arrays;
import java.util.Scanner;

public class Ladder {       // Лестница
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int n = Integer.parseInt(firstLine);

        String secondLine = scanner.nextLine();
        String[] strings = secondLine.split(" ");
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(checkCount(values, n));
    }

    public static int checkCount(int[] values, int n) {
        if (n==1) return values[0];
        if (values[0]>0) {
            values[1] += values[0];
        }
        for (int i = 2; i < n; i++) {
            values[i] += Math.max(values[i-1], values[i - 2]);
        }
        return values[n-1];
    }
}
