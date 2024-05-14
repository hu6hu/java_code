package com.string;

//模拟用户登录
import java.util.Scanner;
public class Test_01 {
    public static void main(String[] args) {
        String username = "itheima";
        String password = "czbk";
        for(int i=0;i<3;i++) {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入用户名：");
            String name = sc.nextLine();

            System.out.print("请输入密码：");
            String word = sc.nextLine();

            if(name.equals(username) && word.equals(password)){
                System.out.println("成功" );
                break;
            }else{
                System.out.println("失败");
            }
        }
    }
}
