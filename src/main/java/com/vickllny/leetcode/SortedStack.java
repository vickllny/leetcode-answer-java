package com.vickllny.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈排序
 * 2022-10-20 22:54:19
 */
public class SortedStack {

    final Deque<Integer> stack;
    final Deque<Integer> temp;

    public SortedStack() {
        stack = new LinkedList<>();
        temp = new LinkedList<>();
    }

    public void push(int val) {
        if(isEmpty()){
            stack.push(val);
            return;
        }
        while (!isEmpty() && val > peek()){
            temp.push(stack.pop());
        }
        stack.push(val);
        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }

    public void pop() {
        if(isEmpty()){
            return;
        }
        stack.pop();
    }

    public int peek() {
        return isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
