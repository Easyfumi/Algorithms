package ru.marinin.data_structures;


import java.util.Arrays;
import java.util.Scanner;

public class DynamicArrayTask {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            if (str.equals("size")) {
                System.out.println(dynamicArray.size());
            } else if (str.equals("index")) {
                int el = Integer.parseInt(scanner.nextLine());
                System.out.println(dynamicArray.index(el));
            } else if (str.equals("push_back")) {
                int el = Integer.parseInt(scanner.nextLine());
                dynamicArray.pushBack(el);
            } else if (str.equals("pop_back")) {
                System.out.println(dynamicArray.popBack());
            }
        }
    }
}

class DynamicArray {
    private int size = 0;
    private int capacity = 10;
    private int[] array = new int[10];

    public DynamicArray() {
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public int index(int i) {
        return array[i];
    }

    public void setByIndex(int i, int num) {
        array[i] = num;
    }

    private void resize() {
        capacity *= 2;
        int[] copyArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            copyArray[i] = array[i];
        }
        array = copyArray;
    }

    public void pushBack(int num) {
        if (size - 1 == capacity) {
            this.resize();
        }
        array[size] += num;
        size++;
    }

    public int popBack() {
        int el = array[size - 1];
        size--;
        return el;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
