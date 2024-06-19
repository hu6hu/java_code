package test;

// 求解图的最短路径问题
import java.util.Scanner;

public class Dijkstra {

    // 用于表示无法到达的极大值
    private static int max = Integer.MAX_VALUE;

    // dijkstra算法
    public void dijkstra(int v, int[][] a, int dist[], int prve[]) {
        int n = dist.length;
        // s数组用于存储已经找到最短路径的顶点
        boolean[] s = new boolean[n];

        // 初始化dist和prve数组
        for (int i = 0; i < n; i++) {
            dist[i] = a[v][i];
            s[i] = false;
            if (dist[i] < Integer.MAX_VALUE)
                prve[i] = v;
            else
                prve[i] = -1;
        }

        // 设置源点的距离为0，表示已经找到最短路径
        dist[v] = 0;
        s[v] = true;

        // 迭代n-1次找到其他顶点的最短路径
        for (int i = 1; i < n; i++) {
            int temp = Integer.MAX_VALUE;
            int u = v;
            // 找到当前未处理顶点中距离源点最近的顶点
            for (int j = 0; j < n; j++) {
                if (!s[j] && dist[j] < temp) {
                    u = j;
                    temp = dist[j];
                }
            }
            s[u] = true;
            // 更新u的邻接顶点的最短路径
            for (int j = 0; j < n; j++) {
                if (!s[j] && a[u][j] < Integer.MAX_VALUE) {
                    int newDist = dist[u] + a[u][j];
                    if (newDist < dist[j]) {
                        dist[j] = newDist;
                        prve[j] = u;
                    }
                }
            }
        }
    }

    // 结果输出方法
    public void outPath(int m, int[] p, int[] d) {
        for (int i = 0; i < d.length; i++) {
            if (d[i] < Integer.MAX_VALUE && i != m) {
                System.out.print("v" + i + "<--");
                int next = p[i];
                while (next != m) {
                    System.out.print("v" + next + "<--");
                    next = p[next];
                }
                System.out.println("v" + m + ":" + d[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入顶点数量：");
        int n = scanner.nextInt();

        // 初始化邻接矩阵，表示图的边和权重
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    a[i][j] = 0;
                } else {
                    a[i][j] = max;
                }
            }
        }

        System.out.print("请输入边的数量：");
        int edges = scanner.nextInt();

        System.out.println("请输入每条边的起点、终点和权重：");
        // 输入边的信息，构建邻接矩阵
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            a[u][v] = w;
        }

        Dijkstra d = new Dijkstra();

        // 对每个顶点作为源点，计算其到其他顶点的最短路径
        for (int source = 0; source < n; source++) {
            int[] dist = new int[n];
            int[] prve = new int[n];
            System.out.println("从顶点 v" + source + " 到其他顶点的最短路径：");
            d.dijkstra(source, a, dist, prve);
            d.outPath(source, prve, dist);
            System.out.println();
        }

        scanner.close();
    }
}