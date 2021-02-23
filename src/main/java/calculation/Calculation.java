package calculation;

import person.Person;

import java.util.List;

public class Calculation {

    public static void countDept(List<Person> personList){

        double sumOfMoneySpent = countSpentMoney(personList);

        double moneyPerPerson = sumOfMoneySpent / personList.size();

        double dept;

        for (Person person : personList) {

            dept = person.getMoneySpent() - moneyPerPerson;
            person.setDept(dept);

        }

    }

    public static double countSpentMoney(List<Person> personList) {

        double sumOfMoneySpent = 0;

        for (Person person : personList) {
            sumOfMoneySpent += person.getMoneySpent();
        }

        return  sumOfMoneySpent;

    }

}
