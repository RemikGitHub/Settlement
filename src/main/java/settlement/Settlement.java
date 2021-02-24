package settlement;

import person.Creditor;
import person.Debtor;
import person.SettlingPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Settlement {

    private static final Scanner scanner = new Scanner(System.in);

    public List<SettlingPerson> askForSpentMoney() {


        List<SettlingPerson> settlingPersonList = new ArrayList<>();

        int amountOfPeople;

        System.out.print("How many people: ");
        amountOfPeople = scanner.nextInt();
        scanner.nextLine();

        do {
            settlingPersonList.add(askForPerson());
            --amountOfPeople;

        } while (amountOfPeople > 0);

        return settlingPersonList;
    }

    private SettlingPerson askForPerson() {

        String name;
        double spentMoney;

        System.out.print("\nWrite name: ");
        name = scanner.nextLine();

        System.out.print("Write down the money spent: ");
        spentMoney = scanner.nextDouble();
        scanner.nextLine();

        return new SettlingPerson(name, spentMoney);
    }

    public void writeDept(List<Debtor> debtorsList) {

        for (Debtor debtor : debtorsList) {

            System.out.println("\nName: " + debtor.getName());

            System.out.println("Must give back: ");

            for (Creditor creditor : debtor.getCreditorList()){
                System.out.println("\t Creditor name: " + creditor.getName());
                System.out.println("\t How much: " + creditor.getAmountOfRefund());
            }
        }
    }

}
