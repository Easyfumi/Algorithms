package ru.marinin.data_structures;

public class TreapTask {
    public static void main(String[] args) {
        NodeForTreap node1 = new NodeForTreap(10);
        NodeForTreap node2 = new NodeForTreap(3);
        NodeForTreap node3 = new NodeForTreap(8);
        NodeForTreap node4 = new NodeForTreap(6);
        NodeForTreap node5 = new NodeForTreap(5);
        NodeForTreap node6 = new NodeForTreap(9);
        NodeForTreap node7 = new NodeForTreap(7);

        Treap treap = new Treap();
        treap.root = node7;
        treap.root.left = node5;
        treap.root.right = node6;
        treap.root.left.left = node2;
        treap.root.left.right = node4;
        treap.root.right.left = node3;
        treap.root.right.right = node1;

        System.out.println(treap);

        System.out.println("");

        for (Treap t : Treap.split(treap,7)) {
            System.out.println(t);
        }


    }
}

class Treap {

    public NodeForTreap root;


    public Treap() {

    }

    public static Treap[] split(Treap tree, int key) {
        Treap[] treaps = new Treap[2];
        if (tree.root==null) return treaps;
        if (key > tree.root.x && tree.root.right == null) {
            return new Treap[]{tree,null};
        }
        if (key <= tree.root.x && tree.root.left == null) {
            return new Treap[]{null, tree};
        }
        if (key > tree.root.x) {
            Treap newTreap = new Treap();
            newTreap.root = tree.root.right;
            Treap[] newTreaps = split(newTreap, key);
            tree.root.right = newTreaps[0].root;
            treaps[0] = tree;
            treaps[1] = newTreaps[1];
            return treaps;
        } else {
            Treap newTreap = new Treap();
            newTreap.root = tree.root.left;
            Treap[] newTreaps = split(newTreap, key);
            tree.root.left = newTreaps[1] == null ? null : newTreaps[1].root;
            treaps[0] = newTreaps[0];
            treaps[1] = tree;
            return treaps;
        }
    }

    public Treap merge(Treap left, Treap right) {
        return null;
    }

    public void insert(int x) {

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

    public NodeForTreap(int x) {
        this.x = x;
        this.y = count;
        count++;
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