package com.string;

//拼接字符串
public class test_04 {


      //常规法
//    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        System.out.println(pinjie(arr));
//    }
//
//    //定义一个方法，用于拼接字符串
//    public static String pinjie(int[] arr){
//        String s = "";
//        s+="[";
//        for(int i=0; i<arr.length; i++) {
//            if (i == arr.length - 1) {
//                s += arr[i];
//            } else {
//                s += arr[i];
//                s += ",";
//            }
//        }
//        s+="]";
//        return s;
//    }



    //String转换成StringBuilder法
//    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        System.out.println(pinjie(arr));
//    }
//    //定义一个方法，用于拼接字符串
//    public static StringBuilder pinjie(int[] arr) {
//        StringBuilder s = new StringBuilder();
//        s.append('[');
//        for (int i = 0; i < arr.length; i++) {
//            if (i == arr.length - 1) {
//                s.append(arr[i]);
//            } else {
//                s.append(arr[i]).append(',');
//            }
//        }
//        s.append(']');
//        return s;
//    }
}
