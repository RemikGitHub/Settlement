package person;

public class SettlingPerson extends Person {

    private final double amountOfSpendMoney;

    public SettlingPerson(String name, double amountOfSpendMoney) {
        super(name);
        this.amountOfSpendMoney = amountOfSpendMoney;
    }

    public double getAmountOfSpendMoney() {
        return amountOfSpendMoney;
    }


}
