package test;

import java.util.Scanner;

public class mabu {
    // 是否走过，棋盘
    static int[][] board;
    // 棋盘大小
    static int n;
    // 保存路径条数
    static int solutions;

    // 检查当前位置是否有效
    public static boolean isValidMove(int x, int y) {
        // 在棋盘内且未被访问过
        return x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 0;
    }

    // 解决马踏棋盘问题
    public static void solve(int x, int y, int step) {
        if (step == n * n) {
            solutions++;
            printSolution();
            return;
        }

        // 方向引导数组
        int[] fx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] fy = {2, 1, -1, -2, -2, -1, 1, 2};

        for (int i = 0; i < 8; i++) {
            int dx = x + fx[i];
            int dy = y + fy[i];
            if (isValidMove(dx, dy)) {
                board[x][y] = step;
                solve(dx, dy, step + 1);
                board[x][y] = 0;
            }
        }
    }

    // 打印当前解
    public static void printSolution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the board (n): ");
        n = sc.nextInt();
        board = new int[n][n];

        System.out.print("Enter the starting position (x y): ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }

        solutions = 0;
        solve(x, y, 1);

        if (solutions == 0) {
            System.out.println("No solution!");
        } else {
            System.out.println("Total solutions: " + solutions);
        }
    }
}
