package ru.marinin.sort;

import java.util.Scanner;
public class CountingSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] array = new int[n];

        String line = scanner.nextLine();

        String[] strArray = line.split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }

        sortArray(array);

        for (int el : array) {
            System.out.print(el + " ");
        }
    }

    public static int[] sortArray(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }

        int[] array = new int[max - min + 1];

        for(int i = 0; i < nums.length; i++) {
            array[nums[i] - min]++;
        }

        int j = 0;

        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array[i]; k++) {
                nums[j]=i + min;
                j++;
            }
        }

        return nums;
    }
}
