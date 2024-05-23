package ru.marinin;

import java.util.Arrays;
import java.util.Scanner;

public class Backpack {   //рюкзак и поиск максимального веса
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        String[] firstLineStr = firstLine.split(" ");
        String[] secondLineStr = secondLine.split(" ");
        int w = Integer.parseInt(firstLineStr[0]);
        int n = Integer.parseInt(firstLineStr[1]);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(secondLineStr[i]);
        }

        System.out.println(calculation(nums, w, n));

    }

    public static int calculation(int[] nums, int w, int n) {
        int[][] array = new int[n + 1][w + 1];
        array[0][0] = 0;
        for (int i = 1; i < w + 1; i++) {
            array[0][i] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            array[i][0] = nums[i - 1];
        }


        for (int i = 1; i < w + 1; i++) {
            if (array[0][i] >= array[1][0]) {
                array[1][i] = array[1][0];
            }
        }


        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                int tW = array[0][j];
                int tN = array[i][0];
                if (tW < tN) {
                    array[i][j] = array[i - 1][j];
                } else {
                    if (array[i-1][j]+tN<=tW) {
                        array[i][j]=array[i-1][j]+tN;
                    } else {
                        array[i][j]=Math.max(array[i-1][j], tN);
                    }
                }

            }
        }



        for(
    int[] line :array)
            System.out.println(Arrays.toString(line));
        return 0;
}
}
