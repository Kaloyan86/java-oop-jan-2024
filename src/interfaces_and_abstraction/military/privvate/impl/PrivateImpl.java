package interfaces_and_abstraction.military.privvate.impl;

import interfaces_and_abstraction.military.privvate.Private;
import interfaces_and_abstraction.military.soldier.impl.SoldierImpl;

public class PrivateImpl extends SoldierImpl implements Private {

    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
