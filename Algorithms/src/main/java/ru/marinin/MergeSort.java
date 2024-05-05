package ru.marinin;

import java.util.Comparator;
import java.util.Scanner;

public class MergeSort {
    static Comparator<Integer> comparator = Comparator.comparingInt(Integer::intValue).reversed();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int[] buffer = new int[n];

        mergeSort(array, 0, array.length, buffer);

        for (int el : array) {
            System.out.println(el);
        }
    }


    public static void mergeSort(int[] array, int left, int right, int[] buffer) {
        if (right-left <= 1) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(array, left, middle, buffer);
        mergeSort(array, middle, right, buffer);
        merge(array, left, middle, middle, right, buffer);
    }

    public static void merge(int[] array, int aLeft, int aRight, int bLeft, int bRight, int[] buffer) {
        int left = aLeft;
        int right = bLeft;
        int i = 0;
        while (left < aRight && right < bRight) {
            if (comparator.compare(array[left], array[right]) < 0) {
                buffer[i] = array[left];
                i++;
                left++;
            } else {
                buffer[i] = array[right];
                i++;
                right++;
            }
        }
        while (left < aRight) {
            buffer[i] = array[left];
            i++;
            left++;
        }
        while (right < bRight) {
            buffer[i] = array[right];
            i++;
            right++;
        }
        for (int id = aLeft; id < bRight; id++) {
            array[id] = buffer[id - aLeft];
        }
    }
}
