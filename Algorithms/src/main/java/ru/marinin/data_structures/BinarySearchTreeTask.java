package ru.marinin.data_structures;

public class BinarySearchTreeTask {
    public static void main(String[] args) {

//        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < n; i++) {
//            String string = scanner.nextLine();
//            if (string.startsWith("pop")) {
//                String[] strings = string.split(" ");
//                binarySearchTree.remove(Integer.parseInt(strings[1]));
//            } else if (string.startsWith("push")) {
//                String[] strings = string.split(" ");
//                binarySearchTree.push(Integer.parseInt(strings[1]));
//            } else if (string.startsWith("find")) {
//                String[] strings = string.split(" ");
//                System.out.println((binarySearchTree.search(Integer.parseInt(strings[1])) + "").toUpperCase());
//            } else if (string.equals("get_max")) {
//                System.out.println(binarySearchTree.findMax());
//            } else if (string.equals("get_min")) {
//                System.out.println(binarySearchTree.findMin());
//            }
//        }


        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.push(7);
        binarySearchTree.push(7);
        binarySearchTree.push(7);
        binarySearchTree.push(7);
        binarySearchTree.push(7);


        System.out.println(binarySearchTree);

        binarySearchTree.remove(7);
        System.out.println(binarySearchTree);
        binarySearchTree.remove(7);
        System.out.println(binarySearchTree);
        binarySearchTree.remove(7);
        System.out.println(binarySearchTree);
        binarySearchTree.remove(7);
        System.out.println(binarySearchTree);
        binarySearchTree.remove(7);
        System.out.println(binarySearchTree);



    }
}

class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
    }

    public void push(Integer elem) {
        Node runner = root;
        if (runner == null) {
            root = new Node(elem);
            return;
        }
        Node parent = null;
        while (runner != null) {
            if (runner.value > elem) {
                parent = runner;
                runner = runner.left;
            } else {
                parent = runner;
                runner = runner.right;
            }
        }

        if (parent.value > elem) {
            parent.left = new Node(elem);
        } else {
            parent.right = new Node(elem);
        }
    }

    public int findMax() {
        if (root == null) {
            return 0;
        }
        Node runner = root;
        while (runner.right != null) {
            runner = runner.right;
        }
        return runner.value;
    }

    public int findMin() {
        if (root == null) {
            return 0;
        }
        Node runner = root;
        while (runner.left != null) {
            runner = runner.left;
        }
        return runner.value;
    }

    public void removeMax() {
        if (root == null) {
            return;
        }
        if (root.right == null) {
            root = root.left;
            return;
        }
        Node runner = root;
        Node parent = null;
        while (runner.right != null) {
            parent = runner;
            runner = runner.right;
        }
        if (runner.left == null) {
            parent.right = null;
        } else {
            parent.right = runner.left;
        }
    }

    public void removeMin() {
        if (root == null) {
            return;
        }
        if (root.left == null) {
            root = root.right;
            return;
        }
        Node runner = root;
        Node parent = null;
        while (runner.left != null) {
            parent = runner;
            runner = runner.left;
        }
        if (runner.right == null) {
            parent.left = null;
        } else {
            parent.left = runner.right;
        }
    }

    public boolean search(int elem) {
        Node runner = root;
        while (runner != null) {
            if (runner.value < elem) {
                runner = runner.right;
            } else if (runner.value > elem) {
                runner = runner.left;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean remove(int elem) {
        if (!search(elem)) return false;
        if (root.value == elem) {
            if (root.left != null) {
                BinarySearchTree tempBST = new BinarySearchTree();
                tempBST.root = root.left;
                int max = tempBST.findMax();
                root.value = max;
                tempBST.removeMax();
                root.left = tempBST.root;
                return true;
            } else if (root.right != null) {
                BinarySearchTree tempBST = new BinarySearchTree();
                tempBST.root = root.right;
                int min = tempBST.findMin();
                root.value = min;
                tempBST.removeMin();
                root.right = tempBST.root;
                return true;
            } else {
                root = null;
                return true;
            }
        } else {
            Node runner = root;
            Node parent = null;
            while (runner != null) {
                if (runner.value < elem) {
                    parent = runner;
                    runner = runner.right;
                } else if (runner.value > elem) {
                    parent = runner;
                    runner = runner.left;
                } else {
                    if (runner.left != null) {
                        BinarySearchTree tempBST = new BinarySearchTree();
                        tempBST.root = runner.left;
                        int max = tempBST.findMax();
                        runner.value = max;
                        tempBST.removeMax();
                        runner.left = tempBST.root;
                        return true;
                    } else if (runner.right != null) {
                        BinarySearchTree tempBST = new BinarySearchTree();
                        tempBST.root = runner.right;
                        int min = tempBST.findMin();
                        runner.value = min;
                        tempBST.removeMin();
                        runner.right = tempBST.root;
                        return true;
                    } else {
                        if (runner.value < parent.value) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                        return true;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (root != null) {
            stringBuilder.append("        " + root.value + "\n");
        } else {
            stringBuilder.append("        " + "N" + "\n");
        }
        stringBuilder.append("     " + " /   \\ " + "\n");
        stringBuilder.append("     ");
        if (root != null) {
            stringBuilder.append(root.left == null ? "N" : root.left.value);
            stringBuilder.append("     ");
            stringBuilder.append(root.right == null ? "N" : root.right.value);
        } else {
            stringBuilder.append("N" + "     " + "N");
        }

        stringBuilder.append("\n");
        stringBuilder.append("  " + " /  \\ " + " " + " /  \\ " + "\n");
        if (root!=null && root.left != null) {
            stringBuilder.append("  ");
            stringBuilder.append(root.left.left == null ? "N" : root.left.left.value);
            stringBuilder.append("   ");
            stringBuilder.append(root.left.right == null ? "N" : root.left.right.value);
        } else {
            stringBuilder.append("       ");
        }
        if (root!=null && root.right != null) {
            stringBuilder.append("   ");
            stringBuilder.append(root.right.left == null ? "N" : root.right.left.value);
            stringBuilder.append("   ");
            stringBuilder.append(root.right.right == null ? "N" : root.right.right.value);
        } else {
            stringBuilder.append("       ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }


}

class Node {
    Integer value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "|" + "\n" + " l: " + left + "   r:" + right;
    }

}

//        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        binarySearchTree.push(7);
//        binarySearchTree.push(6);
//        binarySearchTree.push(6);
//        binarySearchTree.push(7);
//        binarySearchTree.push(7);
//        binarySearchTree.push(10);
//        binarySearchTree.push(10);
//
//
//        System.out.println(binarySearchTree);
//
//        binarySearchTree.remove(7);
//        System.out.println(binarySearchTree);
//        binarySearchTree.remove(7);
//        System.out.println(binarySearchTree);
//        binarySearchTree.remove(7);
//        System.out.println(binarySearchTree);
//        binarySearchTree.remove(10);
//        System.out.println(binarySearchTree);


//        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        binarySearchTree.push(5);
//        binarySearchTree.push(4);
//        binarySearchTree.push(7);
//        binarySearchTree.push(2);
//        binarySearchTree.push(4);
//        binarySearchTree.push(9);
//        binarySearchTree.push(6);
//        binarySearchTree.push(3);
//        binarySearchTree.push(6);
//
//        System.out.println(binarySearchTree);
//
//        System.out.println(binarySearchTree.remove(1));
//        System.out.println(binarySearchTree.remove(5));
//        System.out.println(binarySearchTree);


//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("        " + root.value + "\n");
//        stringBuilder.append("     " + " /   \\ " + "\n");
//        stringBuilder.append("     " + root.left.value + "     " + root.right.value + "\n");
//        stringBuilder.append("  " + " /  \\ " + " " + " /  \\ " + "\n");
//        stringBuilder.append("  ");
//        stringBuilder.append(root.left.left == null ? "N" : root.left.left.value);
//        stringBuilder.append("   ");
//        stringBuilder.append(root.left.right == null ? "N" : root.left.right.value);
//        stringBuilder.append("   ");
//        stringBuilder.append(root.right.left == null ? "N" : root.right.left.value);
//        stringBuilder.append("   ");
//        stringBuilder.append(root.right.right == null ? "N" : root.right.right.value);
//        stringBuilder.append("\n");
//        return stringBuilder.toString();
//    }
//
//
//
//    @Override
//    public String toString() {
//        return value + "|" + "\n" + " l: " + left + "   r:" + right;
//    }