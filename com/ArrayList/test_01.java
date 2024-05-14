package com.ArrayList;

import java.util.ArrayList;
public class test_01 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();

        //add()输出返回bool型
        System.out.println(array.add("hello"));

        //
        array.add("world");
        System.out.println(array);

        //add(int index,E element)在集合中指定位置插入元素
        array.add(1,"你好世界");
        System.out.println(array);

        //int size()返回集合个数
        System.out.println(array.size());

        //Boolean remove(Object o)删除指定元素，返回bool型
        array.remove("hello");
        System.out.println(array);

        //E remove(int index)删除指定索引的元素，返回删除的元素
        System.out.println(array.remove(0));
        System.out.println(array);

        //E set(int index, E element)修改指定索引处的元素，返回被修改的元素
        System.out.println(array.set(0,"helloworld"));
        System.out.println(array);

        //E get(int index)返回指定索引处的元素
        System.out.println(array.get(0));

    }
}
