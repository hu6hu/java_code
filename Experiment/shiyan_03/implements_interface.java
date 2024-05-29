package Experiment.shiyan_03;

//租车合同接口的实现
public class implements_interface implements RentalContract {

    @Override
    public void generateContract(zu_car car) {
        System.out.println("名字\t\t\t" + car.getName());
        System.out.println("品牌\t\t\t" + car.getBrand());
        System.out.println("车身颜色\t\t" + car.getColor());
        System.out.println("每日租金\t\t" + car.getPricePerDay());
        System.out.println("租的天数\t\t" + car.getDays());

        System.out.println("总租金\t\t" + car.totalPrice());
    }


}
