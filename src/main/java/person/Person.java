package person;

public class Person {
    private final String name;
    private final double moneySpent;
    private double dept;

    public Person(String name, double moneySpent) {
        this.name = name;
        this.moneySpent = moneySpent;
    }

    public void setDept(double dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public double getDept() {
        return dept;
    }
}
