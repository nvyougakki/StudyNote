package com.heyu.leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * @ClassName BinaryTree1038
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/11/24 19:01
 */

public class BinaryTree1038 {

    public static void main(String[] args) {

    }
    public TreeNode bstToGst(TreeNode root) {
        //右侧
        if(root != null)
            computeNode(root);
        return root;
    }

    int sum = 0;

    public void computeNode(TreeNode root){
        if(root.right != null) {
            computeNode(root.right);
        }
        root.val += sum;
        sum = root.val;
        if(root.left != null) {
            computeNode(root.left);
        }

    }

    public TreeNode bstToGst(TreeNode root) {
        bstToGst(root,0);
        return root;

    }

    public void bstToGst(TreeNode root, int flag){
        if(root == null)
            return;
        if(root.right != null) {
            bstToGst(root.right, flag);
        }
        root.val += flag;
        flag = root.val;
        if(root.left != null) {
            bstToGst(root.left, flag);
        }
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
