package test;

import java.util.Scanner;

public class KnightTour {

    // 定义马可以移动的8个方向
    private static final int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

    private static int N; // 棋盘大小

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入棋盘的大小 n: ");
        N = scanner.nextInt();
        solveKnightTour();
        scanner.close();
    }

    // 检查坐标(x, y)是否在棋盘内且未被访问过
    private static boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    // 打印解决方案
    private static void printSolution(int[][] sol) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(sol[x][y] + "\t");
            }
            System.out.println();
        }
    }

    // 解决马步问题
    private static void solveKnightTour() {
        int[][] sol = new int[N][N];

        // 初始化棋盘
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }

        // 马的初始位置
        sol[0][0] = 0;

        // 试图从位置(0, 0)开始解决问题
        if (!solveKnightTourUtil(0, 0, 1, sol)) {
            System.out.println("解决方案不存在");
        } else {
            printSolution(sol);
        }
    }

    // 回溯法解决马步问题的递归工具函数
    private static boolean solveKnightTourUtil(int x, int y, int movei, int[][] sol) {
        int k, next_x, next_y;
        if (movei == N * N) {
            return true;
        }

        // 试探所有可能的马步移动
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKnightTourUtil(next_x, next_y, movei + 1, sol)) {
                    return true;
                } else {
                    sol[next_x][next_y] = -1; // 回溯
                }
            }
        }
        return false;
    }
}
