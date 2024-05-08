package ru.marinin;

import java.util.Scanner;

public class QuickSortL {
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
         if (right - left < 1) {
             return;
         }
         int p = partition(nums, left, right);
         quickSort(nums,left,p-1);
         quickSort(nums,p+1,right);
     }



     public static int partition(int[] nums, int left, int right) {
         int pivot = nums[right];
         int i = left;
         for (int j = left; j <= right; j++) {
             if (nums[j] > pivot) {
                 int temp = nums[i];
                 nums[i] = nums[j];
                 nums[j] = temp;
                 i++;
             }
         }
         nums[right] = nums[i];
         nums[i] = pivot;

         return i;
     }
}
