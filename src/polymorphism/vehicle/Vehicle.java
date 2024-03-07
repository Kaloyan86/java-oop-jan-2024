package polymorphism.vehicle;

public interface Vehicle {

    String drive(double distance);

    void refuel(double liters);

    default void setEmpty(boolean empty) {

    }
}
