package ru.marinin.algorithmic_tasks;

import java.util.Scanner;

public class BinarySearch {     // бинарный поиск
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String[] firstLineArray = firstLine.split(" ");

        int[] numsArray = new int[Integer.parseInt(firstLineArray[0])];
        for (int i = 0; i < numsArray.length; i++) {
            numsArray[i] = Integer.parseInt(firstLineArray[i + 1]);
        }

        String secondLine = scanner.nextLine();
        String[] secondLineArray = secondLine.split(" ");

        int[] searchingNums = new int[Integer.parseInt(secondLineArray[0])];
        for (int i = 0; i < searchingNums.length; i++) {
            searchingNums[i] = Integer.parseInt(secondLineArray[i + 1]);
        }

        for (int el : searchingNums) {
            System.out.print(search(numsArray, el)+" ");
        }

    }

    public static int search(int[] numsArray, int searchingElement) {
        int rez = -1;
        int l = 0;
        int r = numsArray.length;
        while (l!=r-1) {
            int k = (r+l)/2;
            int mid = numsArray[k];
            if (mid==searchingElement) {
                rez = k + 1;
                break;
            } else if (mid < searchingElement) {
                l = k;
            } else {
                r = k;
            }
        }

        if (numsArray[r-1]==searchingElement) {
            rez = r;
        }

        return rez;
    }
}
