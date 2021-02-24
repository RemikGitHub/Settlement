package calculation;

import person.Creditor;
import person.Debtor;
import person.SettlingPerson;

import java.util.ArrayList;
import java.util.List;

public class DebtCounter {

    private List<Creditor> creditors;
    private List<Debtor> debtors;
    private final double averageSpend;

    public DebtCounter(List<SettlingPerson> settlingPersonList) {

        this.averageSpend = getAverageSpend(settlingPersonList);
        this.debtors = new ArrayList<>();
        this.creditors = new ArrayList<>();

        for (SettlingPerson settlingPerson : settlingPersonList) {
            if (settlingPerson.getAmountOfSpendMoney() >= averageSpend) {
                this.creditors.add(new Creditor(settlingPerson.getName(), settlingPerson.getAmountOfSpendMoney() - averageSpend));
            }
            else this.debtors.add(new Debtor(settlingPerson.getName(), averageSpend - settlingPerson.getAmountOfSpendMoney()));
        }
    }

    public static double getAverageSpend(List<SettlingPerson> settlingPersonList){

        double sumOfMoneySpent = countSpentMoney(settlingPersonList);
        return  sumOfMoneySpent / settlingPersonList.size();

    }

    public static double countSpentMoney(List<SettlingPerson> settlingPersonList) {

        double sumOfMoneySpent = 0.0;

        for (SettlingPerson settlingPerson : settlingPersonList) {
            sumOfMoneySpent += settlingPerson.getAmountOfSpendMoney();
        }

        return  sumOfMoneySpent;

    }


    public List<Debtor> getDebtorList(){

        int debtorsNumber = 0;

        Creditor creditor = creditors.get(0);

        while ( debtorsNumber < debtors.size() ) {

            if( !creditors.isEmpty() ) {
                creditor = creditors.get(0);
            }


            if (debtors.get(debtorsNumber).getAmountOfDebt() > creditor.getAmountOfRefund()){

                debtors.get(debtorsNumber).reduceDebt( creditor.getAmountOfRefund() );
                debtors.get(debtorsNumber).addCreditor(creditors.get(0));

                creditors.remove(0);

            } else {

                double splitDebt = debtors.get(debtorsNumber).getAmountOfDebt();

                debtors.get(debtorsNumber).reduceDebt( splitDebt );
                debtors.get(debtorsNumber).addCreditor(new Creditor( creditor.getName(), splitDebt ));
                System.out.println("----1----");
                System.out.println(debtorsNumber);
                if (creditors.size()!=0)creditors.get(0).reduceRefund(splitDebt);

                ++debtorsNumber;
            }
        }

        return debtors;
    }






}
