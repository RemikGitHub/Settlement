package calculation;

import person.Creditor;
import person.Debtor;
import person.SettlingPerson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static calculation.MoneyCalc.getAverageSpend;

public class DebtCounter {

    private final List<Creditor> creditors;
    private final List<Debtor> debtors;


    public DebtCounter() {

        this.debtors = new ArrayList<>();
        this.creditors = new ArrayList<>();

    }


    public List<Debtor> getDebtorList(List<SettlingPerson> settlingPersonList) {

        splitIntoCreditorsAndDebtors(settlingPersonList);

        int debtorsNumber = 0;
        int creditorsNumber = 0;

        Creditor creditor;
        Debtor debtor;

        BigDecimal currentDebt;
        BigDecimal valueOfReduceDebt = BigDecimal.valueOf(0.0);

        BigDecimal currentRefund;
        BigDecimal valueOfReduceRefund = BigDecimal.valueOf(0.0);

        while (debtorsNumber < debtors.size() && creditorsNumber < creditors.size()) {

            debtor = debtors.get(debtorsNumber);
            creditor = creditors.get(creditorsNumber);

            currentDebt = debtor.getAmountOfDebt().subtract(valueOfReduceDebt);
            currentRefund = creditor.getAmountOfRefund().subtract(valueOfReduceRefund);

            if (currentDebt.compareTo(currentRefund) >= 0) {

                debtor.addCreditor(new Creditor(creditor.getName(), currentRefund));
                valueOfReduceDebt = valueOfReduceDebt.add(currentRefund);

                ++creditorsNumber;
                valueOfReduceRefund = BigDecimal.valueOf(0.0);

            } else {

                debtor.addCreditor(new Creditor(creditor.getName(), currentDebt));
                valueOfReduceRefund = valueOfReduceRefund.add(currentDebt);

                ++debtorsNumber;
                valueOfReduceDebt = BigDecimal.valueOf(0.0);
            }
        }

        return debtors;
    }

    private void splitIntoCreditorsAndDebtors(List<SettlingPerson> settlingPersonList) {

        BigDecimal averageSpend = getAverageSpend(settlingPersonList);

        for (SettlingPerson settlingPerson : settlingPersonList) {

            if (settlingPerson.getAmountOfSpendMoney().compareTo(averageSpend) >= 0) {

                BigDecimal refund = settlingPerson.getAmountOfSpendMoney().subtract(averageSpend);

                this.creditors.add(new Creditor(settlingPerson.getName(), refund));

            } else {

                BigDecimal debt = averageSpend.subtract(settlingPerson.getAmountOfSpendMoney());

                this.debtors.add(new Debtor(settlingPerson.getName(), debt));

            }
        }
    }

}
