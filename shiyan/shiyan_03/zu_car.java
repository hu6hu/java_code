package shiyan.shiyan_03;

public class zu_car extends car {
    private double days;    //租用的天数

    public zu_car() {
    }

    public zu_car(double days) {
        super();
        this.days = days;
    }

    //计算租车的总价格
    public double totalPrice() {
        double total = days * getPricePerDay();
        return total;
    }


    public double getDays() {
        return days;
    }

    public void setDays(double days) {
        this.days = days;
    }


}
