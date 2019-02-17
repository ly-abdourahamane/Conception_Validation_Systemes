package ups.dl.com;

public class Money {

    private float amount;
    private String currency;

    public Money(float amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Money add(Money m) {
        if (m.getCurrency() == this.getCurrency()) {
            this.setAmount(this.getAmount() + m.getAmount());
        } else //currencies are different. EUR == USD * 2
            if (this.getCurrency() == "EUR") { //and m.getCurrency = USD
                this.setAmount(this.getAmount()
                        + (m.getAmount() * 2));
            } else {
                this.setAmount(this.getAmount() + (m.getAmount() / 2));
            }


        return m;
    }
}
