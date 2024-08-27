package com.vickllny.leetcode;

import com.vickllny.common.TreeNode;

/**
 * @description:
 * @author: vickllny
 * @date 2024-08-26 23:32
 * @leetcode: https://leetcode.cn/problems/check-balance-lcci/
 */
public class CheckBalanceLcci {

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

}
