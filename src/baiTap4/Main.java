package baiTap4;

import baiTap2.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(27);
        bt.insert(14);
        bt.insert(35);
        bt.insert(10);
        bt.insert(19);
        bt.insert(31);
        bt.insert(42);
        bt.preorder(bt.getRoot());
    }
}
