package ru.marinin;

import java.util.Scanner;

public class Task_2_2 { // сортировка выбором
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int secondIndex = i;
            for (int j = i; j < n; j++) {
                if (array[j] < array[secondIndex]) {
                    secondIndex = j;
                }
            }
            swap(array, i, secondIndex);
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
