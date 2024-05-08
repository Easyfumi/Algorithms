package ru.marinin;

import java.util.Scanner;

public class QuickSortH {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        quickSort(array, 0, array.length - 1);

        for (int el : array) {
            System.out.println(el);
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int p = partition(nums, left, right);
            quickSort(nums,left,p);
            quickSort(nums,p+1,right);
        }
    }


    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[getRandomNumber(left, right)];
        int i = left-1, j = right+1;
        while(true) {
            do {
                i++;
            } while(nums[i] > pivot);
            do {
                j--;
            } while(nums[j] < pivot);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            } else return j;
        }
    }


    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
