package person;

import calculation.MoneyCalc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Debtor extends Person {

    private final BigDecimal amountOfDebt;
    private final List<Creditor> creditorList;


    public Debtor(String name, BigDecimal amountOfDebt) {
        super(name);
        this.amountOfDebt = MoneyCalc.round(amountOfDebt);
        this.creditorList = new ArrayList<>();
    }

    public Debtor(String name, BigDecimal amountOfDebt, List<Creditor> creditorList) {
        super(name);
        this.amountOfDebt = MoneyCalc.round(amountOfDebt);
        this.creditorList = creditorList;
    }


    public BigDecimal getAmountOfDebt() {
        return amountOfDebt;
    }

    public void addCreditor(Creditor creditor) {

        for (int i = 0; i < creditorList.size(); ++i) {

            if (creditorList.get(i).getName().equals(creditor.getName())) {
                BigDecimal summaryRefund = creditorList.get(i).getAmountOfRefund().add(creditor.getAmountOfRefund());
                creditorList.set(i, new Creditor(creditor.getName(), summaryRefund));
                return;
            }
        }

        creditorList.add(creditor);
    }

    public List<Creditor> getCreditorList() {
        return creditorList;
    }

}