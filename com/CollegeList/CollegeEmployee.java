package com.CollegeList;

import javax.swing.*;

public class CollegeEmployee extends Person {
    private String ssn; // 社会保险号
    private double annualSalary; // 年薪
    private String dept; //

    public void setData(){
        String temp;
        super.setData();

        ssn = JOptionPane.showInputDialog(null, "请输入员工的社会保险号：");

        while (true){
            try {
                temp = JOptionPane.showInputDialog(null, "请输入员工的年薪:");
                annualSalary = Double.parseDouble(temp);
                break;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "请输入合法的薪水");
            }
        }
    }

    public void display(){
        super.dispaly();
        System.out.println("SSN:"+ ssn + "\t年薪："+ annualSalary);
    }

    public double getAnnualSalary() {
        return annualSalary;
    }
}
