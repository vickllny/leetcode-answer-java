package com.vickllny.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.vickllny.common.ListNode;
import com.vickllny.common.TreeNode;

/**
 * @description: 特定深度节点链表
 * @author: vickllny
 * @date 2023-10-19 22:48
 * @leetcode: https://leetcode.cn/problems/list-of-depth-lcci/
 */
public class ListOfDepthLcci {

    public ListNode[] listOfDepth(TreeNode tree) {

    }

    ListNode[] list(TreeNode tree){
        if(tree == null){
            return new ListNode[0];
        }
        final List<ListNode> list = new ArrayList<>();

        final ListNode root = new ListNode(tree.val);
        list.add(root);
        addNode(list, root, tree.left, tree.right);

        final ListNode[] node = new ListNode[list.size()];
        return list.toArray(node);
    }

    void addNode(List<ListNode> list, ListNode root, TreeNode left, TreeNode right){
        list.add(root);
    }

}
