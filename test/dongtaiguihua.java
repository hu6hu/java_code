package test;

import java.util.Scanner;

//动态规划法求解矩阵相乘以及最小计算量
class dontaiguihua {
    static int N = 100;
    static int[] p = new int[N];
    static int[][] m = new int[N][N];
    static int[][] s = new int[N][N];
    static int[][] D = new int[N][N]; // 添加D矩阵
    static int n;

    static void MatrixChain() {
        int i, j, r, k;

        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (i == j) {
                    m[i][j] = 0;
                    s[i][j] = 0;
                    D[i][j] = 0; // 初始化D矩阵对角线为0
                } else if (i > j) {
                    D[i][j] = 0; // 初始化D矩阵下三角为0
                }
            }
        }

        for (r = 2; r <= n; r++) {
            for (i = 1; i <= n - r + 1; i++) {
                j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
                s[i][j] = i;
                D[j][i] = i; // 初始化D矩阵对角线下方元素为i
                D[i][j] = D[i + 1][j] + p[i - 1] * p[i] * p[j];

                for (k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                        D[j][i] = k; // 更新D矩阵对角线下方元素为k
                        D[i][j] = t;
                    }
                }
            }
        }
    }

    static void Print(int i, int j) {
        if (i == j) {
            System.out.print("A[" + i + "]");
            return;
        }
        System.out.print("(");
        Print(i, s[i][j]);
        Print(s[i][j] + 1, j);
        System.out.print(")");
    }

    static void PrintDMatrix() {
        System.out.println("D矩阵:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(D[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入矩阵的个数n个数：");
        n = sc.nextInt();

        System.out.print("请一次输入每个矩阵的行数和最后一个矩阵的列数：");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        MatrixChain();
        Print(1, n);
        System.out.println();
        System.out.println("最小计算量的值为：" + m[1][n]);

        // 输出D矩阵
        PrintDMatrix();
    }
}
