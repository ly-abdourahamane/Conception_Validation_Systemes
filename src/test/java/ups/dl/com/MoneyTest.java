package ups.dl.com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyTest {

    private Money m;
    float vl = 10;
    String cur = "EUR";

    @Before //fixture
    public void setUp() throws Exception {
        m = new Money(vl, cur);
    }

    @Test
    public void testGetAmountPosive() {
        Assert.assertTrue("le montant doit être positif", m.getAmount() > 0);
    }

    @Test
    public void testCurrencyStringSize() {
        Assert.assertTrue("la taille de la devise egale 3", m.getCurrency().length() == 3);
    }

    @Test
    public void testAddSameCurrencyAndCurrencyIsSumCurrencies() {
        Money money1 = new Money(12, "EUR");
        float amountSum = money1.getAmount() + m.getAmount();

        m.add(money1);
        float amount = m.getAmount();

        Assert.assertEquals("Même devise", money1.getCurrency(), m.getCurrency());
        Assert.assertTrue("le résultat de l'additon est la somme des deux montants", amount == amountSum);
    }

    @Test
    public void testGetAmount() {
        //Given: a variable m defined in the fixture
        //When: we recover the amount of m
        float v = m.getAmount();
        //Then: then this amount should be equal to vl
        Assert.assertTrue("Value should be " + vl + ", and it is " + v + " instead", v == vl);
    }

    @Test
    public void setAmount() {
        m.setAmount(1);
        float v = m.getAmount();
        Assert.assertTrue("Value should be 1, and it is " + v + " instead", v == 1);
    }

    @Test
    public void getCurrency() {
        String v = m.getCurrency();
        Assert.assertTrue("Value should be " + cur + ", and it is " + v + " instead", v == cur);
    }

    @Test
    public void setCurrency() {
        m.setCurrency("USD");
        String v = m.getCurrency();
        Assert.assertTrue("Value should be USD, and it is " + v + " instead", v == "USD");
    }

    @Test
    public void testAddSameCurrency() {
        /*Given: a variable m defined in the fixture
            whose value is 0*/
        //When: we add 10 to this variable
        int newValue = 10;
        float currentAmount = m.getAmount();
        Money m2 = new Money(newValue, cur);
        m.add(m2);

        //Then: the new value should be 10
        float newAmount = m.getAmount();
        float oracle = currentAmount + newValue;
        Assert.assertTrue("New value should be " + oracle + ", and instead it is " + newAmount, newAmount == oracle);
    }

    @Test
    public void testAddDiffCurrencyEURUSD() {
        int v1 = 0, v2 = 5;
        Money m1 = new Money(v1, "EUR");
        Money m2 = new Money(v2, "USD");

        float currentAmount = m1.getAmount();
        m1.add(m2);
        float newAmount = m1.getAmount();

        float oracle = currentAmount + (v2 * 2); //conversion between EUR and USD
        Assert.assertTrue("New value should be " + oracle + ", and instead it is " + newAmount, newAmount == oracle);
    }

    @Test
    public void testAddDiffCurrencyUSDEUR() {
        int v1 = 0, v2 = 10;
        Money m1 = new Money(v1, "USD");
        Money m2 = new Money(v2, "EUR");

        float currentAmount = m1.getAmount();
        m1.add(m2);
        float newAmount = m1.getAmount();

        float oracle = currentAmount + (v2 / 2); //conversion between USD and EUR
        Assert.assertTrue("New value should be " + oracle + ", and instead it is " + newAmount, newAmount == oracle);
    }
}
