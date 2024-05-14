package com.studentClass;

import java.util.Scanner;
import java.util.ArrayList;
public class ArrayListTest {
    //ArrayList存储学生对象并遍历，提前定义了一个学生类
    public static void main(String[] args) {

        ArrayList<Student> array = new ArrayList<Student>();

        addStudent(array);
        addStudent(array);
        addStudent(array);

        //遍历集合
        for (int i = 0; i < array.size(); i++) {
            Student ss = array.get(i);
            System.out.println(ss.getName()+" "+ss.getAge());
        }
    }
    //添加学生
    private static void addStudent(ArrayList<Student> array){

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String age = sc.nextLine();

        System.out.println("请输入姓名、年龄：");

        //创建学生对象
        Student s = new Student();
        s.setName(name);
        s.setAge(age);

        //添加学生对象到集合中
        array.add(s);
    }
}
