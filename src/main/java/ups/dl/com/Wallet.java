package ups.dl.com;

import java.util.List;

public class Wallet {
    private List<Money> moneyList;

    public Wallet(List<Money> moneyList) {
        this.moneyList = moneyList;
    }

    public List<Money> getMoneyList() {
        return moneyList;
    }

    public void setMoneyList(List<Money> moneyList) {
        this.moneyList = moneyList;
    }

    public void addElement(Money money) {
        moneyList.add(money);
    }
}
