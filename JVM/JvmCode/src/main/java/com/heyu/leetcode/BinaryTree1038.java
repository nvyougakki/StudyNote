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

    /**
     * 给出二叉搜索树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     *
     * 提醒一下，二叉搜索树满足下列约束条件：
     *
     * 节点的左子树仅包含键小于节点键的节点。
     * 节点的右子树仅包含键大于节点键的节点。
     * 左右子树也必须是二叉搜索树。
     * @param root
     * @return
     */
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


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
