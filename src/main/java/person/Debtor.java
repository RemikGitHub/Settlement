package person;

import java.util.ArrayList;
import java.util.List;

public class Debtor extends Person {

    private double amountOfDebt;
    private List<Creditor> creditorList;


    public Debtor(String name, double amountOfDebt) {
        super(name);
        this.amountOfDebt = amountOfDebt;
        this.creditorList = new ArrayList<Creditor>();
    }

    public Debtor(Debtor debtor) {
        super(debtor.getName());
        this.amountOfDebt = debtor.amountOfDebt;
        this.creditorList = new ArrayList<Creditor>();
    }

    public Debtor(String name, double amountOfDebt, List<Creditor> creditorList) {
        super(name);
        this.amountOfDebt = amountOfDebt;
        this.creditorList = creditorList;
    }

    public void reduceDebt(double amountOfReduce) {
        this.amountOfDebt -= amountOfReduce;
    }

    public double getAmountOfDebt() {
        return amountOfDebt;
    }

    public void addCreditor(Creditor creditor){

        boolean isDuplicate = false;

        for (Creditor nextCreditor : creditorList){
            if (nextCreditor.getName().equals(creditor.getName())) {
                nextCreditor.raiseRefund(creditor.getAmountOfRefund());
                return;
            }
        }

        creditorList.add(creditor);
    }

    public List<Creditor> getCreditorList() {
        return creditorList;
    }
}