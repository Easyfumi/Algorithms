package ru.marinin;

import java.util.Arrays;
import java.util.Scanner;

public class Kleptomaniac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxWeight = scanner.nextInt();
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(countValue(array, maxWeight));
    }
    public static int countValue(int[] array, int maxWeight) {
        Arrays.sort(array);
        int count = 0;
        while (maxWeight>0) {
            maxWeight-=array[count];
            count++;
        }
        return count-1;
    }
}
