package com.company;

import java.util.Arrays;

public class Main {

    static final int size = 10000;
    static final int h = size / 2;

    public static void main(String[] args) {
        firstMethod(creteArray());
        secondMethod(creteArray());

    }

    private static float[] creteArray() {
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = 1;
        }
        return array;
    }

    private static void firstMethod(float[] array) {
        System.out.println(Arrays.toString(array));
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void secondMethod(float[] array) {
        System.out.println(Arrays.toString(array));
        float[] array1 = new float[h];
        float[] array2 = new float[h];
        long b = System.currentTimeMillis();
        System.arraycopy(array, 0, array1, 0, h);
        System.arraycopy(array, 0, array2, 0, h);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        Thread calcOne = new Thread(() -> {
            for (int i = 0; i < array1.length; i++) {
                array1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        calcOne.start();
        Thread calcTwo = new Thread(() -> {
            for (int i = 0; i < array2.length; i++) {
                array2[i] = (float) (array2[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));


            }
        });
        calcTwo.start();
        try {
            calcOne.join();
            calcTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(array1, 0, array, 0, h);
        System.arraycopy(array2, 0, array, h, h);
        System.out.println(Arrays.toString(array));
        System.out.println("конечное время для   выполнения двух массивов");
        System.out.println(System.currentTimeMillis() - b);
    }
}
