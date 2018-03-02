package org.chen.arch;

import lombok.Getter;
import lombok.Setter;

public class BinaryTree {

    private TreeNode treeNode;

    public BinaryTree(TreeNode node) {
        treeNode = node == null ? new TreeNode() : node;
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }
    public int minDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.min(left, right) + 1;
    }



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.setLeft(new TreeNode());
        TreeNode right1 = new TreeNode();
        treeNode.setRight(right1);
        TreeNode right2 = new TreeNode();
        right1.setRight(right2);
        right2.setLeft(new TreeNode());
        BinaryTree tree = new BinaryTree(treeNode);
        int depth = tree.maxDepth(tree.treeNode);
        System.out.println(depth);
        System.out.println(tree.minDepth(tree.treeNode));
    }


    @Getter
    @Setter
    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int depth;
    }
}
