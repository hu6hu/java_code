package com.string;

//遍历字符串
import java.util.Scanner;
public class test_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //从键盘上得到一个字符串
        String string = sc.nextLine();

        //遍历字符串
        for(int i=0; i<string.length(); i++){
            System.out.println(string.charAt(i));
        }
    }
}
