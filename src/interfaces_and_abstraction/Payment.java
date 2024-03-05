package interfaces_and_abstraction;

public abstract class Payment {

    private String user;

    protected Payment(String user) {
        this.user = user;
    }

    public abstract void report();

}
