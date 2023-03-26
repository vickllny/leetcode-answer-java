package com.vickllny.sort;

public class BubbleSort implements ISort {

    @Override
    public int[] sort(int[] source) {
        if(source == null || source.length < 2){
            return source;
        }
        for (int i = 0; i < source.length - 1; i++) {
            for (int j = i + 1; j < source.length; j++) {
                if(source[i] > source[j]){
                    int a = source[i];
                    int b = source[j];
                    source[j] = a;
                    source[i] = b;
                }
            }
        }
        return source;
    }
}
