package app;

public class Account {
    private String carid;
    private String username;
    private String userPW;
    private double money;
    private double qutomoney;

    public String getUserPW() {
        return userPW;
    }

    public void setUserPW(String userPW) {
        this.userPW = userPW;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getQutomoney() {
        return qutomoney;
    }

    public void setQutomoney(double qutomoney) {
        this.qutomoney = qutomoney;
    }
}
