package shiyan.shiyan_02;

//35 选 7 彩票销售程序实验

import java.util.Random;
import java.util.Scanner;

public class shiyan_02 {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.print("系统产生的彩票号码为：");
        int[] b = new int[7];
        for (int i = 0; i < 7; ) {
            int random = r.nextInt(35) + 1;
            if (contains(b, random) == 0) {
                b[i] = random;
                i++;
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

        System.out.println();
        System.out.print("请输入要买彩票的注数：");
        int n = sc.nextInt();

        //随机产生的号码
        int[] arr = new int[7];
        for (int i = 1; i <= n; i++) {
            int index = 0;
            while (index < 7) {
                int random = r.nextInt(35) + 1;
                if (contains(arr, random) == 0) {
                    arr[index++] = random;
                }
            }
            System.out.print("彩票号码为：");
            for (int j = 0; j <= 6; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();

            //判断中奖没
            zhong(arr,b);

            //重置数组；
            for (int j = 0; j <= 6; j++) {
                arr[j] = 0;
            }
        }
    }

    //判断是否中奖
    static void zhong(int[] a, int[] b){
        int count = 0;
        for (int k = 0; k<b.length; k++){
            if(contains(a,b[k])==1){
                count ++;
            }else {
                continue;
            }
        }

        if(count == 7){
            System.out.print("中奖了！################################################################");
            System.out.println();
        }
        else{
            System.out.print("没中奖，猜中"+count+"个数");
            System.out.println();
        }
    }

    //a是否属于数组arr，属于返回1，不属于返回0
    static int contains(int[] arr, int a) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                return 1;
            }
        }
        return 0;
    }

}
