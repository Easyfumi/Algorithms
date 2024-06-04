package ru.marinin.data_structures;

import java.util.LinkedList;
import java.util.Scanner;

public class HashTableTask {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] strings = scanner.nextLine().split(" ");
            if (strings[0].equals("push")) {
                hashTable.push(strings[1]);
            } else if (strings[0].equals("search")) {
                System.out.println((hashTable.search(strings[1])+"").toUpperCase());
            } else if (strings[0].equals("pop")) {
                System.out.println((hashTable.pop(strings[1])+"").toUpperCase());
            }
        }
    }
}


class HashTable {
    private LinkedList<String>[] buckets;
    private int size;
    private int capacity;

    public HashTable() {
        size = 0;
        capacity = 10;
        buckets = new LinkedList[capacity];
    }

    private int hashFunction(String object) {
        return Math.abs(object.hashCode() % capacity);
    }

    public void push(String object) {
        if (size >= capacity / 2) {
            resize();
        }
        if (search(object)==false) {
            int hash = hashFunction(object);
            if (buckets[hash] == null) {
                buckets[hash] = new LinkedList<>();
            }
            buckets[hash].push(object);
            size++;
        }
    }

    public boolean pop(String object) {
        int hash = hashFunction(object);
        if (buckets[hash] != null) {
            if (buckets[hash].contains(object)) {
                size--;
            }
            return buckets[hash].remove(object);
        }
        return false;
    }

    public boolean search(String object) {
        int hash = hashFunction(object);
        if (buckets[hash] != null) {
            return buckets[hash].contains(object);
        }
        return false;
    }

    private void resize() {
        LinkedList<String>[] oldBuckets = buckets;
        buckets = new LinkedList[capacity * 2];
        capacity = capacity * 2;
        size = 0;
        for (LinkedList<String> bucket : oldBuckets) {
            if (bucket != null) {
                while (!bucket.isEmpty()) {
                    this.push(bucket.pop());
                }
            }
        }
    }
//    @Override
//    public String toString() {
//        StringBuilder str = new StringBuilder();
//        str.append("______________");
//        str.append("\n");
//        for (LinkedList list : buckets) {
//            str.append(list);
//            str.append("\n");
//        }
//        return str.toString();
//    }
}