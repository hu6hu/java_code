package com.Class;

//import com.studentClass.Student;

//导test包中的Student类
//import test.Student;

public class Demo {
    public static void main(String[] args) {
        Dog t1 = new Dog();
        t1.setAge("20");
        t1.setName("lili");
        System.out.print(t1.getName()+"\t"+t1.getAge()+"\t");
        t1.jiao();

        Cat s1 = new Cat();
        s1.setAge("20");
        s1.setName("wang");
        System.out.print(s1.getName()+"\t"+s1.getAge()+"\t");
        s1.jiao();

        Dog t2 = new Dog("linlin", "22");
        System.out.print(t2.getName()+"\t"+t2.getAge()+"\t");
        t2.jiao();

//        //Student和Demo在同一个包com下，写入时会在类前自动导入
//        Student student = new Student("001","linlin", "20", "taiyuan");
//        System.out.println(student.getSid()+"\t"+student.getName()+
//                "\t"+student.getAge()+"\t"+student.getAddress());


    //导入不同包
        //方法一：Demo在 com/jucheng 中， 调用包 test中的Student ，需要导包， 即带上包名
//        test.Student ss = new test.Student();
//        ss.study();
        //方法二：在类前用import导包
//        Student sss = new Student();
//        sss.doHomework();
    }
}
