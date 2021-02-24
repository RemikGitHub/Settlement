package person;

public class Creditor extends Person{
    private double amountOfRefund;

    public Creditor(String name, double amountOfRefund) {
        super(name);
        this.amountOfRefund = amountOfRefund;
    }

    public double getAmountOfRefund() {
        return amountOfRefund;
    }

    public void reduceRefund(double amountOfReduce) {
        this.amountOfRefund -= amountOfReduce;
    }

    public void raiseRefund(double amountOfRefund) {
        this.amountOfRefund += amountOfRefund;
    }
}
