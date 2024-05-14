package com.CollegeList;

import javax.swing.*;

public class Student extends Person {
    private String id;
    private double gpa;
    private String major;

    public void setData(){
        String temp;
        super.setData();

        id = JOptionPane.showInputDialog(null, "请输入学号：");
        major = JOptionPane.showInputDialog(null, "请输入专业：");

        while (true){
            try {
                temp = JOptionPane.showInputDialog(null, "请输入学分：");
                //将字符串temp转换成double类型
                gpa = Double.parseDouble(temp);
                break;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null , "请输入合法的学分：");
            }
        }
    }

    private void display(){
        super.dispaly();
        System.out.println("\t专业："+ major+ "\t学分："+ gpa);
    }

    public String getMajor(){
        return major;
    }

    public double getGpa(){
        return gpa;
    }
}
