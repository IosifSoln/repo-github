package com.company;

import java.util.Random;

public class animal {
    public int Run;
    public int Swim;
    public double Jump;
    public String name;
    public String type;
    public Random random = new Random();

    public animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void run(int length) {
        this.Run = Run;
        if (this.Run >= length) {
            System.out.println(this.type + " " + this.name + " пробежал " + length + " m");
        } else {
            System.out.println(this.type + " " + this.name + " " + " не может бежать на такое растояние");
        }
    }

    public void jump(double high) {
        this.Jump = Jump;
        if (this.Jump >= high) {System.out.println(this.type + " " + " " + this.name + " прыгнул на  " + high + " m");}
      else {System.out.println(this.type + " " + " " + this.name + " " + " не может так высоко прыгать ");}
    }

    public void swim(int length) {
        this.Swim = Swim;
        if (this.Swim >= length){ System.out.println(this.type + " " + this.name + " " + " проплыл " + length + " m");}
        else {System.out.println(this.type + " " + "" + this.name + " " + "не может плыть на такие растояния");}

    }
    public void info() {
        System.out.println(this.type + " " + this.name + " бег: " + this.Run + " m., плавание: " + this.Swim + " m., прыжки: " + this.Jump + " m.");
    }
}

