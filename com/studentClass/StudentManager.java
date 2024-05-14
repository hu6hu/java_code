package com.studentClass;

//学生管理系统的实现

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> student = new ArrayList<>();

        while(true){
            System.out.println("----------欢迎来到学生管理系统----------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");

            System.out.print("请输入你的选择：");
            int choose = sc.nextInt();
            switch(choose){
                case 1:
                    addStudent(student);
                    break;
                case 2:
                    delStudent(student);
                    break;
                case 3:
                    updataStudent(student);
                    break;
                case 4:
                    findAllStudent(student);
                    break;
                case 5:
                    System.exit(0);
            }
            System.out.println("------------------------------");
        }
    }

    //添加学生方法
    public static ArrayList addStudent(ArrayList<Student> student){

        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        while(true){
            System.out.print("请输入学生学号：");
            String sid = sc.nextLine();
            s.setSid(sid);

            boolean flag = isUsed(student, sid);
            if(flag){
                System.out.println("学号重复");
            }else{
                break;
            }
        }

        System.out.print("请输入学生姓名：");
        String name = sc.nextLine();

        System.out.print("请输入学生年龄：");
        String age = sc.nextLine();

        System.out.print("请输入学生居住地：");
        String address = sc.nextLine();

        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        student.add(s);

        System.out.println("添加学生成功！");
        return student;
    }

    //判断学号是否被使用方法
    public static boolean isUsed(ArrayList<Student> student, String sid) {

        boolean flag = false;
        for (int i = 0; i < student.size(); i++) {
            Student ss = student.get(i);
            if (ss.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //删除学生方法
    public static ArrayList delStudent(ArrayList<Student> student){

        Scanner sc = new Scanner(System.in);

        System.out.print("请输入删除学生的学号：");
        String sid = sc.nextLine();

        int index = -1;
        for(int i=0; i<student.size(); i++){
            Student s = student.get(i);
            if(s.getSid().equals(sid)){
                index = i;
                break;
            }
        }

        if(index == -1){
            System.out.println("该信息不存在" );
        }else {
            student.remove(index);
            System.out.println("删除学生成功");
        }

        return student;
    }

    //修改学生方法
    public static ArrayList updataStudent(ArrayList<Student> student){

        Scanner sc = new Scanner(System.in);

        System.out.print("请输入修改学生的学号：");
        String sid = sc.nextLine();

        int index = -1;
        for(int i=0; i<student.size(); i++){
            Student ss = student.get(i);
            if(ss.getSid().equals(sid)){
                index = i;
                break;
            }
        }

        if(index == -1){
            System.out.println(sid+"的学生不存在");
        }else {
            System.out.print("请输入学生的新姓名：");
            String name = sc.nextLine();
            System.out.print("请输入学生的新年龄：");
            String age = sc.nextLine();
            System.out.print("请输入学生的新居住地：");
            String address = sc.nextLine();

            Student s = new Student();
            s.setSid(sid);
            s.setName(name);
            s.setAge(age);
            s.setAddress(address);

            for(int i=0; i<student.size(); i++){
                Student ss = student.get(i);
                if(ss.getSid().equals(sid)){
                    student.set(i,s);
                }
            }
            System.out.println("修改成功");
        }

        return student;
    }

    //查看所有学生方法
    public static ArrayList findAllStudent(ArrayList<Student> student){

        Scanner sc = new Scanner(System.in);

        if(student.size() == 0){
            System.out.println("无信息");
        }else{
            System.out.println("学号\t\t姓名\t\t年龄\t\t居住地");
            for(int i=0; i<student.size(); i++){
                Student s = student.get(i);
                System.out.println(s.getSid()+"\t\t"+s.getName()+"\t\t"+s.getAge()+"\t\t"+s.getAddress());
            }
        }
        return student;
    }


}
