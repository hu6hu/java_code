package com.Class;

public class Cat extends Animal {

    public int weight = 20;

    public String type = "类";

    public void jiao(){
        System.out.println("miao");
    }

    //父类的方法重写
    @Override
    public void animal() {
        System.out.println("cat");
    }
}

