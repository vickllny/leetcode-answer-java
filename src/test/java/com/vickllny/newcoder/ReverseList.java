package com.vickllny.newcoder;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {

    public static ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode current = head,
                p1 = head;

        while ((current = current.next) != null){
            head.next = current.next;
            current.next = p1;

            p1 = current;
            current = head;

        }
        return p1;
    }

    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if(head == null || head.next == null || n <= m){
            return head;
        }
        ListNode current = head,
                p1 = head, p2 = head, last = head;
        int index = 1;
        boolean flag = m != index;
        while ((current = current.next) != null){
            if(m == ++index){
                p1 = last;
                p2 = current;
            }
            if(index > m && index <= n){
                p2.next = current.next;
                current.next = flag ? p1.next : p1;
                if(flag){
                    p1.next = current;
                }else {
                    p1 = current;
                }
                current = p2;
            }
            if(index == n){
                break;
            }
            last = current;
        }
        return flag ? head : p1;
    }

    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(head == null){
            return null;
        }
        if(k == 1){
            return head;
        }
        //获取链表总长度
        int length = 1;
        ListNode current = head;
        while ((current = current.next) != null){
            length++;
        }
        if(length < k){
            return head;
        }
        //总翻转组数量
        int loopGroupCount = length / k;
        current = head;
        ListNode p1 = head, p2, end = head, prev = null;
        int fistLoopGroupCount = loopGroupCount - 1;
        while (loopGroupCount-- > 0){
            if(prev != null){
                p1 = end = current = current.next;
            }
            //翻转k个节点
            int i = k - 1;
            while (i-- > 0){
                p2 = current.next;
                end.next = p2.next;
                p2.next = p1;
                p1 = p2;
                if(prev != null){
                    prev.next = p1;
                }
                p2 = end;
                current = p2;
            }
            prev = current;
            if(fistLoopGroupCount == loopGroupCount){
                head = p1;
            }
        }
        return head;
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode p1 = list1, p2 = list2, head = null, tail = null, big, small;
        while(true){
            if(p1 == null && p2 == null){
                break;
            }
            if(p1 == null){
                tail.next = p2;
                break;
            }
            if(p2 == null){
                tail.next = p1;
                break;
            }
            if(p1.val >= p2.val){
                //ge
                big = p1;
                small = p2;
                p2 = p2.next;
            }else{
                //lt
                big = p2;
                small = p1;
                p1 = p1.next;
            }
            
            if(head == null){
                head = tail = small;
            }else {
                tail.next = small;
                tail = small;
            }
        }
        return head;
    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size() == 0){
            return null;
        }
        ListNode head = null, tail = null, pointer = null, tempNode = null;
        int lastIndex = 0;
        int size = lists.size();
        boolean empty = true;
        while(true){
            for(int i = 0; i < size; i++){
                final ListNode listNode = lists.get(i);
                if(listNode == null){
                    continue;
                }
                empty = false;
                if(head == null){
                    head = tail = tempNode = listNode;
                    continue;
                }
                if(i == 0){
                    tempNode = listNode;
                    if(head == tail){
                        tail = listNode;
                        head.next = tail;
                    }else {
                        tail.next = listNode;
                    }
                    continue;
                }
                if(tempNode.val >= listNode.val){
                    if(head == tail){
                        tail = listNode;
                        head.next = tail;
                    }else {
                        pointer = head;
                        while(pointer.next != tail){
                            pointer = pointer.next;
                        }
                        pointer.next = listNode;
                        tail = listNode;
                    }
                    tempNode = listNode;
                    lastIndex = i;
                }
            }
            if(empty){
                break;
            }
            ListNode listNode = lists.get(lastIndex);
            listNode = listNode.next;
            lists.set(lastIndex, listNode);
            lastIndex = 0;
            empty = true;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode2;
        ListNode listNode4 = new ListNode(5);
        listNode2.next = listNode4;
        ListNode listNode6 = new ListNode(7);
        listNode4.next = listNode6;


        ListNode listNode1 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode3;
        ListNode listNode5 = new ListNode(3);
        listNode3.next = listNode5;
        
//        ListNode node = reverseBetween(listNode, 1, 4);
//        ListNode node = ReverseList(listNode);
        // ListNode node = reverseKGroup(listNode, 3);

        // ListNode node = Merge(listNode, listNode1);
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(listNode);
        list.add(listNode1);
        ListNode node = mergeKLists(list);
        System.out.println(listNode3);

    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

