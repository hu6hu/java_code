package com.ArrayList;

//存储字符串并遍历
import java.util.ArrayList;
public class test_02 {
    public static void main(String[] args) {
        ArrayList array = new ArrayList();
        array.add("a");
        array.add("b");
        array.add("c");
        System.out.println(array);
        bianli(array);
    }

    //集合的遍历
    public static void bianli(ArrayList array){
        for(int i=0; i<array.size(); i++){
            System.out.println(array.get(i));
        }
    }
}
