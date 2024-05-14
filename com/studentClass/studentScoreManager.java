package com.studentClass;

//成绩管理系统

import java.util.*;

public class studentScoreManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] name = {"1", "2", "3", "4", "5", "6"};
        String[] course = {"one", "two", "three"};
        double[][] grade = {
                {50, 60, 70}, {50, 60, 60}, {70, 70, 70}, {80, 80, 80}, {85, 85, 85}, {90, 90, 90}
        };

        //按名字查询某个学生
        System.out.print("请输入要查询成绩的学生名字：");
        String chioce = sc.nextLine();

        for (int i = 0; i < name.length; i++) {
            if (name[i].equals(chioce)) {
                System.out.println("学生" + name[i] + "的成绩是：");
                for (int j = 0; j < course.length; j++) {
                    System.out.println('\t'+course[j] + "\t" + grade[i][j]);
                }
                break;
            } else if (i == 5)
                System.out.println("查找的学生不在");
        }

        System.out.println("--------------------------------------");
        //查询某个学科不及格人数，以及学生名单
        System.out.print("请输入查询不及格科目的名称：");
        String major = sc.nextLine();
        int count = 0;

        for (int i = 0; i < course.length; i++) {
            if (course[i].equals(major)) {
                System.out.println(major + "科目不及格的成绩及学生：");
                for (int j = 0; j < grade.length; j++) {
                    if (grade[j][i] < 60) {
                        System.out.println("\t" + name[j] + '\t' + grade[j][i]);
                        count++;
                    } else continue;
                }
            }
        }
        System.out.println("该科目不及格的人数为：" + count);
    }
}