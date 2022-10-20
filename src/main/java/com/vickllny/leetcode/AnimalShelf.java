package com.vickllny.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 动物收容所
 * @author: vickllny
 * @date 2022-10-20 23:19
 */
public class AnimalShelf {

    final List<Integer[]> data;

    private static final int[] default_data = new int[]{-1, -1};

    public AnimalShelf() {
        data = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        data.add(new Integer[]{animal[0], animal[1]});
    }

    public int[] dequeueAny() {
        if(data.isEmpty()){
            return default_data;
        }
        Integer[] poll = data.get(0);
        data.remove(poll);
        return new int[]{poll[0], poll[1]};
    }

    public int[] dequeueDog() {
        return dequeue(1);
    }

    public int[] dequeueCat() {
        return dequeue(0);
    }

    public int[] dequeue(int type) {
        if(data.isEmpty()){
            return default_data;
        }
        for (Integer[] temp : data) {
            if(temp[1] == type){
                data.remove(temp);
                return new int[]{temp[0], temp[1]};
            }
        }
        return default_data;
    }
}
