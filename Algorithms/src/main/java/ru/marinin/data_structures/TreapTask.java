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
        treap.push(12);
        Treap[] treaps = Treap.split(treap, 3);
        System.out.println("LEFT:");
        System.out.println(treaps[0]);
        System.out.println("RIGHT:");
        System.out.println(treaps[1]);

        System.out.println("MAX");
        System.out.println(treaps[0].getMax());
        System.out.println("MIN");
        System.out.println(treaps[0].getMin());

        System.out.println(treap.find(3));
    }

}

class Treap {

    public NodeForTreap root;


    public Treap() {

    }

    public static Treap[] split(Treap tree, int key) {
        Treap[] treaps = new Treap[2];
        if (tree.root == null) return treaps;
        if (key >= tree.root.x) {
            Treap newTreap = new Treap();
            newTreap.root = tree.root.right;
            Treap[] newTreaps = split(newTreap, key);
            tree.root.right = newTreaps[0] == null ? null : newTreaps[0].root;
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

    public static Treap merge(Treap left, Treap right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.root == null) return right;
        if (right.root == null) return left;
        if (left.root.y >= right.root.y) {
            Treap tempTreap = new Treap();
            tempTreap.root = left.root.right;
            left.root.right = merge(tempTreap, right).root;
            return left;
        } else {
            Treap tempTreap = new Treap();
            tempTreap.root = right.root.left;
            right.root.left = merge(left, tempTreap).root;
            return right;
        }
    }

    public void push(int x) {
        NodeForTreap newNode = new NodeForTreap(x);
        Treap newTreap = new Treap();
        newTreap.root = newNode;
        Treap[] treaps = Treap.split(this, x);
        if (treaps[1] == null) {
            this.root = Treap.merge(treaps[0], newTreap).root;
        } else {
            treaps[1].root = Treap.merge(newTreap, treaps[1]).root;
            this.root = Treap.merge(treaps[0], treaps[1]).root;
        }
    }
    public int getMax() {
        if (this.root==null) {
            return 0;
        }
        NodeForTreap tempRoot = this.root;
        int max = tempRoot.x;
        while (tempRoot.right!=null) {
            max = tempRoot.right.x;
            tempRoot.right = tempRoot.right.right==null ? null : tempRoot.right.right;
        }
        return max;
    }
    public int getMin() {
        if (this.root==null) {
            return 0;
        }
        NodeForTreap tempRoot = this.root;
        int min = tempRoot.x;
        while ( tempRoot.left!=null) {
            min = tempRoot.left.x;
            tempRoot.left= tempRoot.left.left==null ? null : tempRoot.left.left;
        }
        return min;
    }
    public boolean find(int x) {
        Treap left = Treap.split(this, x)[0];
//        if (left==null) return false;
        int maxElem = left.getMax();
        return x==maxElem;
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