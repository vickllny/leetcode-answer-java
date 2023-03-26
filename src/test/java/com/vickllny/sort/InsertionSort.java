package com.vickllny.sort;

public class InsertionSort implements ISort {
    @Override
    public int[] sort(int[] source) {
        int length;
        if(source == null || (length = source.length) < 2){
            return source;
        }
        for (int i = 1; i < length; i++) {
            int value = source[i];
            for (int j = i - 1; j > -1; j--) {
                if(value < source[j]){
                    source[j + 1] = source[j];
                    source[j] = value;
                }
            }
        }
        return source;
    }
}
