package shiyan.shiyan_01;
// 猜数字
import java.util.Random;
import java.util.Scanner;

public class shiyan_01 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        int number = r.nextInt(100) + 1;
        int count = 0;
        System.out.println("随机产生的数字是：" + number);
        while (true) {
            System.out.print("请输入你所猜测的数字：");
            int num = sc.nextInt();
            count++;
            if (num > number) {
                System.out.println("猜大了");
            } else if (num < number) {
                System.out.println("猜小了");
            } else if (num == number) {
                System.out.println("猜中了");
                System.out.println("总共猜测了" + count + "次");
                System.exit(0);
            }
        }
    }
}
