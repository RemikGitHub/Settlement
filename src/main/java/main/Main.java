package main;

import calculation.DebtCounter;
import person.Debtor;
import person.SettlingPerson;
import settlement.Settlement;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n----This is Settlement program----\n");

        Settlement settlement = new Settlement();
        List<SettlingPerson> settlingPersonList = settlement.askForSpentMoney();

        DebtCounter debtCounter = new DebtCounter(settlingPersonList);
        List<Debtor> debtorList = debtCounter.getDebtorList();

        settlement.writeDept(debtorList);


    }

}
