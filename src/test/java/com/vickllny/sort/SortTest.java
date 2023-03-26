package com.vickllny.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SortTest {

    static int LENGTH = 100;

    static int BOUND = LENGTH * LENGTH;

    @Test
    public void bubbleSort(){
        ISort sort = new BubbleSort();
        //array
        int[] array = new int[BOUND];
        Random random = new Random();
        for (int i = 0; i < BOUND; i++) {
            array[i] = random.nextInt(BOUND);
        }
        System.out.println(Arrays.toString(array));
        int[] result = sort.sort(array);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void selectionSort(){
        ISort sort = new SelectionSort();
        //array
        int[] array = new int[BOUND];
        Random random = new Random();
        for (int i = 0; i < BOUND; i++) {
            array[i] = random.nextInt(BOUND);
        }
        System.out.println(Arrays.toString(array));
        int[] result = sort.sort(array);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void insertionSort(){
        ISort sort = new InsertionSort();
        //array
        int[] array = new int[BOUND];
        Random random = new Random();
        for (int i = 0; i < BOUND; i++) {
            array[i] = random.nextInt(BOUND);
        }
        System.out.println(Arrays.toString(array));
        int[] result = sort.sort(array);
        System.out.println(Arrays.toString(result));
    }
}
