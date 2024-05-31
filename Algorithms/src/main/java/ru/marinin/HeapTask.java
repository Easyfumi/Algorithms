package ru.marinin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeapTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        Heap heap = new Heap(array);
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String str = scanner.nextLine();
            if (str.equals("GetMax")) {
                System.out.println(heap.getMax());
            } else if (str.equals("PopMax")) {
                heap.popMax();
            } else if (str.startsWith("Push")) {
                String[] strings = str.split(" ");
                heap.push(Integer.parseInt(strings[1]));
            } else if (str.equals("IsEmpty")) {
                System.out.println((heap.isEmpty()+"").toUpperCase());
            }
        }
    }
}

class Heap {
    private List<Integer> array;

    public Heap(int[] array) {
        this.array = new ArrayList<>();
        for (int el : array) {
            this.array.add(el);
        }
        makeHeap();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public String getMax() {
        if (isEmpty()) return "None";
        else return array.get(0) + "";
    }

    public void popMax() {
        if (isEmpty()) return;
        else {
            array.set(0, array.get(array.size() - 1));
            array.remove(array.size() - 1);
            siftDown(0);
        }
    }

    public void push(Integer value) {
        array.add(value);
        siftUp(array.size() - 1);
    }

    private void siftUp(int id) {
        int parent = (id - 1) / 2;
        while (id > 0 && array.get(parent) < array.get(id)) {
            swap(parent, id);
            id = parent;
            parent = (id - 1) / 2;
        }
    }

    private void siftDown(int id) {
        while (id < array.size()) {
            int left = id * 2 + 1;
            int right = id * 2 + 2;
            int idMin = id;
            if (left < array.size() && array.get(left) > array.get(idMin)) {
                idMin = left;
            }
            if (right < array.size() && array.get(right) > array.get(idMin)) {
                idMin = right;
            }
            if (idMin == id) {
                break;
            } else {
                swap(idMin, id);
                id = idMin;
            }
        }
    }

    private void makeHeap() {
        for (int i = array.size() / 2; i >= 0; i--) {
            siftDown(i);
        }
    }


    private void swap(int parent, int id) {
        int temp = array.get(parent);
        array.set(parent, array.get(id));
        array.set(id, temp);
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
