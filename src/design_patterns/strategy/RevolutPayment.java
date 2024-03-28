package design_patterns.strategy;

public class RevolutPayment implements Payment{


    @Override
    public void pay(int amount) {
        System.out.println("Payed by Revolut!");
    }
}
