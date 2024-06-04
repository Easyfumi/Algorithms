package ru.marinin.data_structures;

public class TreapTask {
    public static void main(String[] args) {
        Treap treap = new Treap();
        NodeForTreap root = new NodeForTreap(7, 10);
        treap.root = root;
        treap.root.left = new NodeForTreap(4, 6);
        treap.root.right = new NodeForTreap(13, 8);
        treap.root.left.left = new NodeForTreap(2, 4);
        treap.root.left.right = new NodeForTreap(6, 2);
        treap.root.right.left = new NodeForTreap(9, 7);
        treap.root.right.right = new NodeForTreap(14, 4);
        System.out.println(treap);

        Treap[] treaps = treap.split(treap, 7);


    }
}

class Treap {
    NodeForTreap root;

    public Treap() {
    }

    public Treap[] split(Treap tree, int key) {
        Treap[] treaps = new Treap[2];

        if (tree.root == null) {
            return treaps;
        }
        //todo: некорректно, падает в бесконечный цикл
        if (key > tree.root.x) {
            Treap tempRightTree = new Treap();
            tempRightTree.root = this.root.right;
            Treap[] tempArray = split(tempRightTree, key);
            this.root.right = tempArray[0].root;
            treaps[0].root = this.root;
            treaps[1].root = tempArray[1].root;
            return treaps;
        } else {
            Treap tempLeftTree = new Treap();
            tempLeftTree.root = this.root.left;
            Treap[] tempArray = split(tempLeftTree, key);
            this.root.left = tempArray[1].root;
            treaps[0].root = tempArray[0].root;
            treaps[1].root = this.root;
            return treaps;
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }
}

class NodeForTreap {
    static private int count = 0;
    int x;
    int y;
    NodeForTreap left;
    NodeForTreap right;

    public NodeForTreap(int x, int y) {
        this.x = x;
        this.y = y;
        // count++;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[" + x + ";" + y + "]");
        stringBuilder.append("\n");
        if (left != null) {
            stringBuilder.append(left);
        }
        if (right != null) {
            stringBuilder.append(right);
        }
        return stringBuilder.toString();
    }
}