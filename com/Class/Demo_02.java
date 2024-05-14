package com.Class;

public class Demo_02 {
    public static void main(String[] args) {

        //由父类引用指向子类对象：多态
        Animal A = new Cat();   //多态

//        //Cat中有weight，但是父类Animal中没有，报错
//        System.out.println(A.weight);

        //多态形式访问成员变量，访问的是父类中的
        //Cat中与父类中都有成员变量type，输出的是父类的成员变量
        System.out.println(A.type);

        //多态形式访问成员方法，父类有，不报错
        //多态形式访问重写的成员方法，看右边
        A.animal();

    }
}
