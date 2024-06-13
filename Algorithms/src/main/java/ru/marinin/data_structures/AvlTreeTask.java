package ru.marinin.data_structures;

import java.util.Scanner;

public class AvlTreeTask {
    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine();
            if (string.startsWith("pop")) {
                String[] strings = string.split(" ");
                avlTree.delete(Integer.parseInt(strings[1]));
            } else if (string.startsWith("push")) {
                String[] strings = string.split(" ");
                avlTree.insert(Integer.parseInt(strings[1]));
            } else if (string.startsWith("find")) {
                String[] strings = string.split(" ");
                System.out.println((avlTree.find(Integer.parseInt(strings[1])) + "").toUpperCase());
            } else if (string.equals("get_max")) {
                System.out.println(avlTree.getMax());
            } else if (string.equals("get_min")) {
                System.out.println(avlTree.getMin());
            }
        }
    }
}

class AvlTree {

    private NodeForAvlTree root;

    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public boolean find(int key) {
        NodeForAvlTree current = root;
        while (current != null) {
            if (current.key == key) {
                return true;
            }
            current = current.key < key ? current.right : current.left;
        }
        return false;
    }

    public int getMax() {
        if (root == null) return 0;
        NodeForAvlTree current = root;
        int max = current.key;
        while (current.right != null) {
            current = current.right;
            max = current.key;
        }
        return max;
    }

    public int getMin() {
        if (root == null) return 0;
        NodeForAvlTree current = root;
        int min = current.key;
        while (current.left != null) {
            current = current.left;
            min = current.key;
        }
        return min;
    }


    private void updateHeight(NodeForAvlTree node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(NodeForAvlTree node) {
        return node == null ? -1 : node.height;
    }

    private int getBalance(NodeForAvlTree node) {
        return node == null ? 0 : height(node.right) - height(node.left);
    }

    private NodeForAvlTree rotateRight(NodeForAvlTree node) {
        NodeForAvlTree xNode = node.left;
        NodeForAvlTree zNode = node.right;
        xNode.right = node;
        node.left = zNode;
        updateHeight(node);
        updateHeight(xNode);
        return xNode;
    }

    private NodeForAvlTree rotateLeft(NodeForAvlTree node) {
        NodeForAvlTree xNode = node.right;
        NodeForAvlTree zNode = xNode.left;
        xNode.left = node;
        node.right = zNode;
        updateHeight(node);
        updateHeight(xNode);
        return xNode;
    }

    private NodeForAvlTree rebalance(NodeForAvlTree node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (height(node.right.right) > height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (height(node.left.left) > height(node.left.right)) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
        return node;
    }

    private NodeForAvlTree insert(NodeForAvlTree root, int key) {
        if (root == null) {
            return new NodeForAvlTree(key);
        } else if (root.key >= key) {
            root.left = insert(root.left, key);
        } else if (root.key < key) {
            root.right = insert(root.right, key);
        }
        return rebalance(root);
    }

    private NodeForAvlTree delete(NodeForAvlTree node, int key) {
        if (node == null) {
            return node;
        } else if (node.key > key) {
            node.left = delete(node.left, key);
        } else if (node.key < key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                NodeForAvlTree tempNode = mostLeftChild(node.right);
                node.key = tempNode.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private NodeForAvlTree mostLeftChild(NodeForAvlTree node) {
        NodeForAvlTree current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }


}

class NodeForAvlTree {
    public int key;
    public int height;
    NodeForAvlTree left;
    NodeForAvlTree right;

    public NodeForAvlTree() {
    }

    public NodeForAvlTree(int key) {
        this.key = key;
    }
}
