package com.vickllny.leetcode;

/**
 * @description: 最小二叉搜索树
 * @author: vickllny
 * @date 2022-10-27 10:46
 * @leetcode: https://leetcode.cn/problems/minimum-height-tree-lcci/
 */
public class LowestBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums);
    }

    private TreeNode helper(int[] nums){
        int length = nums.length;
        if(length == 0){
            return null;
        }else if(length == 1){
            return new TreeNode(nums[0]);
        }else if(length == 2){
            TreeNode node = new TreeNode(nums[1]);
            node.left = new TreeNode(nums[0]);
            return node;
        }else if(length == 3){
            TreeNode node = new TreeNode(nums[1]);
            node.left = new TreeNode(nums[0]);
            node.right = new TreeNode(nums[2]);
            return node;
        }
        int m = length / 2;
        TreeNode root = new TreeNode(nums[m]);

        int[] lefts = new int[m];
        int[] rights = new int[length - m - 1];
        System.arraycopy(nums, 0, lefts, 0, lefts.length);
        System.arraycopy(nums, m + 1, rights, 0, rights.length);

        root.left = helper(lefts);
        root.right = helper(rights);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
