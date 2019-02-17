package ups.dl.com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WalletTest {

    private Wallet wallet;
    List<Money> moneyList = new ArrayList<>();
    Money money;

    @Before
    public void setUp() throws Exception {
        money = new Money(10, "USD");
        moneyList.add(money);

        wallet = new Wallet(moneyList);
    }

    @Test
    public void testGetMoneyList() {
        int size = wallet.getMoneyList().size();
        Assert.assertTrue("Value should be " + size, size == 1);
    }

    @Test
    public void testSetMoneyList() {
        money.setAmount(555);
        moneyList.set(0, money);
        wallet.setMoneyList(moneyList);

        Assert.assertTrue("Value should be 555", wallet.getMoneyList().get(0).getAmount() == 555);
    }
}
