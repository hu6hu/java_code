package gui;

import javax.swing.*;
import java.awt.*;

public class test_01 {
    public static void main(String[] args) {
        //创建窗体
        JFrame frm = new JFrame();
        //设置窗体标题
        frm.setTitle("理解GUI编程");
        //设置布局
        frm.setLayout(new BorderLayout());


        //创建分割面板
        JSplitPane splitPane = new JSplitPane();
        //设置分割方式：垂直
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        //将分割面板添加窗体中
        frm.add(splitPane);
        //设置面板的分割比例，上侧为50个像素
        splitPane.setDividerLocation(50);


        //创建窗体的滚动面板
        JScrollPane ScrollPane = new JScrollPane();
        //将分割面板添加到滚动面板中
        ScrollPane.setViewportView(splitPane);
        //滚动面板支持鼠标的滚动轮
        ScrollPane.setWheelScrollingEnabled(true);
        //设置滚动面板水平条永远显示
        ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //设置滚动面板垂直永远显示
        ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //将滚动面板添加到窗体中
        frm.add(ScrollPane);


        //上半部分面板
        //创建面板并放在窗体上半部分
        JPanel topPanel = new JPanel();
        frm.add(topPanel, BorderLayout.NORTH);
        //创建提示标签并设置显示信息
        JLabel show = new JLabel();
        show.setText("请输入姓名：");
        topPanel.add(show);
        //创建输入框，设置为可编辑，左侧输入，20列
        JTextField input = new JTextField();
        input.setEditable(true);
        input.setHorizontalAlignment(SwingConstants.LEFT);
        input.setColumns(20);
        topPanel.add(input);
        //创建提交按钮组件
        JButton myButton = new JButton("提交");
        //将按钮组件对象添加到容器中
        topPanel.add(myButton);



        //下半部分面板
        //创建面板并放在窗体上半部分
        JPanel bottomPanel = new JPanel();
//        frm.add(bottomPanel,BorderLayout.CENTER);
        //创建提示信息
        JLabel label2 = new JLabel();
        label2.setText("显示所有姓名");
        bottomPanel.add(label2);
        //创建文本框，5行32列，不可编辑
        JTextArea output = new JTextArea();
        output.setColumns(32);
        output.setRows(5);
        output.setEditable(true);
        bottomPanel.add(output);




        //设置窗口初始位置与大小并显示
        frm.setBounds(500, 300, 500, 500);
        //设置窗体关闭方式
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //让窗体显示
        frm.setVisible(true);
    }
}
