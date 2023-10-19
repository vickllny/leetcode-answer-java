package com.vickllny.leetcode;

import com.vickllny.common.TreeNode;

/**
 * @description: 最小二叉搜索树
 * @author: vickllny
 * @date 2022-10-27 10:46
 * @leetcode: https://leetcode.cn/problems/minimum-height-tree-lcci/
 */
public class LowestBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return treeNode(nums, 0, nums.length - 1);
    }

    TreeNode treeNode(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2; //left
        final TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = treeNode(nums, left, mid - 1);
        treeNode.right = treeNode(nums, mid + 1, right);
        return treeNode;
    }

    public static void main(String[] args) {

    }

}
