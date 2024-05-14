package com.string;

//统计字符串次数
import java.util.Scanner;
public class test_03 {
    public static void main(String[] args) {
        //输入一个字符串
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        //统计字符串中大写字母、小写字母、数字字符出现的次数
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for(int i=0; i<line.length(); i++){
            char s = line.charAt(i);
            if(s>='A' && s<='Z'){
                count1 ++;
            }else if(s>='a' && s<='z'){
                count2 ++;
            }else if(s>='0' && s<='9'){
                count3 ++;
            }
        }
        System.out.println(line+"中大写字母有"+count1+"个，小写字母有"+count2+"个，数组字符有"+count3+"个");
    }
}
