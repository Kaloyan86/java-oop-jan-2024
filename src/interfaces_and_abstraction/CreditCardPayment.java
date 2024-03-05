package interfaces_and_abstraction;

public class CreditCardPayment extends Payment implements Payable {

    private double limit;

    public CreditCardPayment(String user, double limit) {
        super(user);
        this.limit = limit;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Sum " + amount + " is payed by Credit Card!");
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public void report() {

    }
}
