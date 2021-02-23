package settlement;

import calculation.Calculation;
import person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Settlement {

    private static final Scanner scanner = new Scanner(System.in);

    public List<Person> askForSpentMoney() {


        List<Person> personList = new ArrayList<>();

        String continueAddingPeople;

        do {

            personList.add(askForPerson());
            System.out.print("Do you want to continue? Y/N: ");
            continueAddingPeople = scanner.nextLine();

        } while (!continueAddingPeople.equalsIgnoreCase("n"));

        return personList;
    }

    private Person askForPerson() {

        String name;
        double spentMoney;

        System.out.print("\nWrite name: ");
        name = scanner.nextLine();

        System.out.print("Write down the money spent: ");
        spentMoney = scanner.nextDouble();
        scanner.nextLine();

        return new Person(name, spentMoney);
    }

    public void writeDept(List<Person> personList) {

        Calculation.countDept(personList);

        for (Person person : personList) {

            System.out.println("\nName: " + person.getName());

            if (isDebtor(person)) System.out.println("Must give back: " + person.getDept());
            else System.out.println("Must get: " + abs(person.getDept()));

        }
    }

    private boolean isDebtor(Person person){
        return person.getDept() < 0;
    }

}
