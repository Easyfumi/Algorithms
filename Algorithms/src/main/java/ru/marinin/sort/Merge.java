package ru.marinin.sort;

import java.util.Scanner;

public class Merge {  // слияние двух отсортированных массивов
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] right = new int[m];
        for (int i = 0; i < m; i++) {
            right[i] = scanner.nextInt();
        }

        int[] result = new int[n+m];

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (left[i] < right[j]) {
                result[i+j] = left[i];
                i++;
            } else {
                result[i+j] = right[j];
                j++;
            }
        }

        while (i < n) {
            result[i+j] = left[i];
            i++;
        }

        while (j < m) {
            result[i+j] = right[j];
            j++;
        }

        for (int el : result) {
            System.out.println(el);
        }
    }
}
