package com.vickllny.leetcode;

import com.vickllny.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: vickllny
 * @date 2024-08-27 23:32
 * @leetcode: https://leetcode.cn/problems/legal-binary-search-tree-lcci/description/
 */
public class LegalBinarySearchTreeLcci {

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        final List<Integer> list = new ArrayList<>();

        return validBST(root, list);
    }

    boolean validBST(final TreeNode root, final List<Integer> list){
        if(root == null){
            return true;
        }
        if(!validBST(root.left, list)){
            return false;
        }
        if(list.isEmpty()){
            list.add(root.val);
        }else {
            if (list.get(list.size() - 1) >= root.val) {
                return false;
            }
            list.add(root.val);
        }
        return validBST(root.right, list);
    }


    public static void main(String[] args) {

        final LegalBinarySearchTreeLcci lcci = new LegalBinarySearchTreeLcci();

        final TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(1);
        System.out.println(lcci.isValidBST(root));
    }
}
