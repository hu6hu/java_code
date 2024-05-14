package shiyan.shiyan_03;

public class car {
    private String name;    //车名
    private String brand;   //车品牌
    private String color;   //车牌号
    private Double pricePerDay;  //每日租金


    public car() {
    }

    public car(String name, String brand, String style, Double pricePerDay) {
        this.name = name;
        this.brand = brand;
        this.color = style;
        this.pricePerDay = pricePerDay;
    }

    //车辆信息
    public void car_message() {
        System.out.println("车名\t\t\t" + name);
        System.out.println("车身颜色\t\t" + color);
        System.out.println("车品牌\t\t" + brand);
        System.out.println("每日租金\t\t" + pricePerDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }


}
