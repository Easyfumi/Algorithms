package ru.marinin;

import java.util.Scanner;

public class InsertionSort {  // сортировка вставками
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j > 0 && j < n && array[j - 1] > array[j]) {
                swap(array, j - 1, j);
                j--;
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
