package ru.marinin.sort;

import java.util.Scanner;

public class BubbleSort {  // сортировка пузырьком
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }

        for (int num : array) {
            System.out.println(num);
        }
    }

    public static void swap(int[] array, int indexFirst, int indexSecond) {
        int temp = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = temp;
    }
}
