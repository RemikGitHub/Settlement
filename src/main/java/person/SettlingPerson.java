package person;

import calculation.MoneyCalc;

import java.math.BigDecimal;

public class SettlingPerson extends Person {

    private final BigDecimal amountOfSpendMoney;

    public SettlingPerson(String name, BigDecimal amountOfSpendMoney) {
        super(name);
        this.amountOfSpendMoney = MoneyCalc.round(amountOfSpendMoney);
    }

    public BigDecimal getAmountOfSpendMoney() {
        return amountOfSpendMoney;
    }


}
