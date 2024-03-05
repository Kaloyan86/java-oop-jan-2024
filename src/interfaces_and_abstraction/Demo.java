package interfaces_and_abstraction;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        CreditCardPayment creditCardPayment = new CreditCardPayment("Kaloyan", 2000);
        Payable paypalPayment = new PaypalPayment("Kaloyan");

        int amount = 100;

        creditCardPayment.setLimit(3000);

        List<Payable> paymentList = List.of(creditCardPayment, paypalPayment);
        paymentList.forEach(payment -> payment.pay(amount));
    }
}
