package calculation;

import person.SettlingPerson;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class MoneyCalc {

    public static BigDecimal round(BigDecimal money) {
        return money.setScale(2, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal getAverageSpend(List<SettlingPerson> settlingPersonList) {

        BigDecimal sumOfMoneySpent = countSpentMoney(settlingPersonList);
        BigDecimal amountOfPeople = BigDecimal.valueOf(settlingPersonList.size());

        return round(sumOfMoneySpent.divide(amountOfPeople, 3, RoundingMode.HALF_UP));
    }

    public static BigDecimal countSpentMoney(List<SettlingPerson> settlingPersonList) {

        BigDecimal sumOfMoneySpent = BigDecimal.valueOf(0.0);

        for (SettlingPerson settlingPerson : settlingPersonList) {
            sumOfMoneySpent = sumOfMoneySpent.add(settlingPerson.getAmountOfSpendMoney());
        }

        return sumOfMoneySpent;
    }

}
