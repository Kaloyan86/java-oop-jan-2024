package interfaces_and_abstraction;

public interface Payable {

    void pay(int amount);

    // add money to account
    default void addMoneyToAccount(int money) {
        System.out.printf("The service addMoneyToAccount is not yet available for %s!\n",
                          this.getClass().getSimpleName());
    }

    // calculate VAT
    static double calculateVat(int amount) {
        return amount * 0.2;
    }
}
