package shiyan.shiyan_03;

//汽车出租管理程序实验

import java.util.Scanner;

public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        zu_car car = new zu_car();

        System.out.print("请输入车辆名字：");
        String name = sc.nextLine();
        System.out.print("请输入车辆品牌：");
        String brand = sc.nextLine();
        System.out.print("请输入车辆颜色：");
        String color = sc.nextLine();
        System.out.print("请输入车辆每日租金：");
        double pricePerDay = sc.nextDouble();
        System.out.print("请输入租车天数：");
        double days = sc.nextDouble();

        car.setName(name);
        car.setBrand(brand);
        car.setColor(color);
        car.setPricePerDay(pricePerDay);
        car.setDays(days);

        System.out.println("\n\n\t车辆信息");
        car.car_message();
        System.out.println("\n\n");

        implements_interface contract = new implements_interface();
        System.out.println("\t租车合同");
        contract.generateContract(car);
    }
}
