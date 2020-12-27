package com.company;


public class Main {

    public static void main(String[] args) {
        String[][] Array = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "3", "3", "3"}, {"3", "3", "3", "3"}};

        try {
            try {
                int result = method(Array);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("объем массива превышен");
            }
        } catch (MyArrayDataException e) {
            System.out.println("значение не подходит!");
            System.out.println("Ошибка в символе под номером : " + e.i + "x" + e.j);
        }

    }


    public static int method(String[][] Array) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (Array.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < Array.length; i++) {
            if (Array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < Array[i].length; j++) {
                try {
                    count = count + Integer.parseInt(Array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }

}