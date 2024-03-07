package interfaces_and_abstraction;

import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreditCardPayment creditCardPayment = new CreditCardPayment("Kaloyan", 2000);
        Payable paypalPayment = new PaypalPayment("Kaloyan");

       // System.out.println(Payable.calculateVat(1000));

        int amount = 100;

        creditCardPayment.setLimit(3000);

        List<Payable> paymentList = List.of(creditCardPayment, paypalPayment);
        // paymentList.forEach(payment -> payment.pay(amount));
        //  paymentList.forEach(payable -> payable.addMoneyToAccount(10));

        String paymentType = scanner.nextLine();

        switch (paymentType) {
            case "card":
                creditCardPayment.pay(10);
                break;
            case "paypal":
                paypalPayment.pay(20);
                break;
        }
    }
}
