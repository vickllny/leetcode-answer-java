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
        return list(tree);
    }

    ListNode[] list(TreeNode tree){
        if(tree == null){
            return new ListNode[0];
        }
        final List<ListNode> list = new ArrayList<>();
        final List<TreeNode> cList = new ArrayList<>();
        cList.add(tree);
        addNode(list, cList);
        final ListNode[] node = new ListNode[list.size()];
        return list.toArray(node);
    }

    void addNode(List<ListNode> list, List<TreeNode> cList){
        if(cList.isEmpty()){
            return;
        }
        ListNode listNode = null;
        List<TreeNode> cList1 = new ArrayList<>();
        for (final TreeNode node : cList) {
            if(node.left != null){
                cList1.add(node.left);
            }
            if(node.right != null){
                cList1.add(node.right);
            }
            if(listNode == null){
                listNode = new ListNode(node.val);
                list.add(listNode);
                continue;
            }
            listNode.next = new ListNode(node.val);
            listNode = listNode.next;
        }
        addNode(list, cList1);
    }

}
