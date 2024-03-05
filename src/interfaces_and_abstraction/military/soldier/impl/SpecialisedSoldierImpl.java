package interfaces_and_abstraction.military.soldier.impl;

import interfaces_and_abstraction.military.enumm.Corp;
import interfaces_and_abstraction.military.privvate.impl.PrivateImpl;
import interfaces_and_abstraction.military.soldier.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corp corps;

    public SpecialisedSoldierImpl(int id,
                                  String firstName,
                                  String lastName,
                                  double salary,
                                  String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public Corp getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = Corp.valueOf(corps);
    }
}
