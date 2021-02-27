package person;

import calculation.MoneyCalc;

import java.math.BigDecimal;

public class Creditor extends Person {
    private final BigDecimal amountOfRefund;

    public Creditor(String name, BigDecimal amountOfRefund) {
        super(name);
        this.amountOfRefund = MoneyCalc.round(amountOfRefund);
    }

    public BigDecimal getAmountOfRefund() {
        return amountOfRefund;
    }

}
