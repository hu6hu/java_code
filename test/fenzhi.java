package test;

//分治法思想实现赛程问题

import java.util.Scanner;

public class fenzhi {

    public static int[][] table(int n) {
        int[][] a = new int[n][n];     //a[][] 代表循环赛日程表
        //构造赛程表第一行数据
        for (int i = 0; i < n; i++)
            a[0][i] = i + 1;

        //采用分治算法，构造整个赛程表
        for (int r = 1; r < n; r <<= 1) {        //r=r*2
            for (int i = 0; i < n; i += 2 * r) {
                copy(a, r, r + i, 0, i, r);     //左上角的值赋值给右下角
                copy(a, r, i, 0, r + i, r);     //右上角的值赋值给左下角
            }
        }
        return a;
    }

    // 复制赛程表的一部分
    //  fromx：初始值的行号;fromy：初始值的列号;tox：目的格子的行号;toy：目的格子的列号。
    private static void copy(int[][] a, int tox, int toy, int fromx, int fromy, int r) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                a[tox + i][toy + j] = a[fromx + i][fromy + j];
            }
        }
    }

    //将指定范围的元素从一个位置复制到另一个位置
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入参赛人数（n=2^k）：");
            int n = sc.nextInt();
            if (n <= 0 || n % 2 != 0 || (n & (n - 1)) != 0) {  //检查是否为2的整次幂，并且输入的是否符合要求
                System.out.println("输入n不满足要求");
            } else {
                int[][] a = table(n);   //生成赛程表
                for (int i = 0; i < a.length; i++) {    //打印赛程表
                    for (int j = 0; j < a[0].length; j++) {
                        System.out.print(a[i][j] + " ");
                    }
                    System.out.println();
                }
                System.exit(0);
            }
        }
    }
}
