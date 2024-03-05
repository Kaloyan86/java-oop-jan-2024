package interfaces_and_abstraction;

public class PaypalPayment extends Payment implements Payable{

    public PaypalPayment(String user) {
        super(user);
    }

    @Override
    public void pay(int amount) {
        System.out.println("Sum " + amount + " is payed by Pay Pall!");
    }

    @Override
    public void report() {

    }
}
