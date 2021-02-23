package main;

import person.Person;
import settlement.Settlement;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n----This is Settlement program----\n");

        Settlement settlement = new Settlement();
        List<Person> personList = settlement.askForSpentMoney();

        settlement.writeDept(personList);


    }

}
