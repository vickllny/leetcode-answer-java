package com.vickllny.sort;

public class SelectionSort implements ISort {
    @Override
    public int[] sort(int[] source) {
        int length;
        if(source == null || (length = source.length) < 2){
            return source;
        }
        for (int i = 0; i < length - 1; i++) {
            int min = source[i];
            int minIndex = i;
            for (int j = i + 1; j < source.length; j++) {
                if(source[j] < min){
                    min = source[j];
                    minIndex = j;
                }
            }
            source[minIndex] = source[i];
            source[i] = min;
        }
        return source;
    }
}
