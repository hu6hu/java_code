package com.CollegeList;

import javax.swing.*;//包含了用于图形用户界面(GUI)的类和方法。

public class Person {
    private String name;
    private String address;
    private String phone;
    private String gender;

    public void setData() {
        name = JOptionPane.showInputDialog(null, "请输入姓名：");
        address = JOptionPane.showInputDialog(null, "请输入地址：");
        phone = JOptionPane.showInputDialog(null, "请输入电话：");
        gender = JOptionPane.showInputDialog(null, "请输入性别：");
        //JOptionPane.showInputDialog方法弹出输入对话框，让用户输入相应的信息。
    }

    public void dispaly() {
        System.out.println("姓名：" + name + "\t性别:" + gender + "\t地址:" + address + "\t联系电话:" + phone);
    }
}
