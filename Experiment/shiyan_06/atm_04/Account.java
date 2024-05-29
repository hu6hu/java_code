package Experiment.shiyan_06.atm_04;

public class Account {
    //账户类

    //成员变量，私有
    private String cardId;      //卡号
    private String userName;    //账户名
    private String paasWord;    //密码
    private double money;       //余额
    private double quotaMoney;  //取现额度

    public Account() {
    }
    public Account(String cardId, String userName, String paasWord, double money, double quotaMoney) {
        this.cardId = cardId;
        this.userName = userName;
        this.paasWord = paasWord;
        this.money = money;
        this.quotaMoney = quotaMoney;
    }

    public String getCardId() {
        return cardId;
    }
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPaasWord() {
        return paasWord;
    }
    public void setPaasWord(String paasWord) {
        this.paasWord = paasWord;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public double getQuotaMoney() {
        return quotaMoney;
    }
    public void setQuotaMoney(double quotaMoney) {
        this.quotaMoney = quotaMoney;
    }

}
