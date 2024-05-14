package com.string;

public class test_06 {
    public static void main(String[] args) {

        StringBuilder sbbb = new StringBuilder();

        //StringBuilder的append方法使用
        sbbb.append("huhu");
        System.out.println(sbbb);

        //StringBuilder的reverse方法使用
        System.out.println(sbbb.reverse());

        //StringBuilder转换成string，用 toString方法
        StringBuilder sb = new StringBuilder();
        sb.append("helo");
        String s = sb.toString();
        System.out.println(s);

        //String转换成StringBuilder，用 StringBuilder()构造方法
        String ss = "heoo";
        StringBuilder sbb = new StringBuilder(ss);
        System.out.println(sbb);
    }
}
