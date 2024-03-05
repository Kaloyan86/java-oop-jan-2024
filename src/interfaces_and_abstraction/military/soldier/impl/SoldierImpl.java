package interfaces_and_abstraction.military.soldier.impl;

import interfaces_and_abstraction.military.soldier.Soldier;

public abstract class SoldierImpl implements Soldier {

    // id (int), first name, and last name
    private int id;
    private String firstName;
    private String lastName;

    public SoldierImpl(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
}
