package com.company;

public  class Main {

    public static void main(String[] args) {
        cat cat1 = new cat("борис", "кот");
        cat cat2 = new cat("коба", "кот");

        dog dog1 = new dog("Бобик","пес");
        dog dog2 = new dog("Бендер","пес");

cat1.info();
cat2.info();
        System.out.println();

        dog1.info();
        dog2.info();
        System.out.println();

        cat1.run(4000);
        cat1.swim(2);
        cat2.jump(0.5);
        System.out.println();

        dog2.run(1);
        dog2.swim(2);
        dog1.jump(1.0);
    }
}
