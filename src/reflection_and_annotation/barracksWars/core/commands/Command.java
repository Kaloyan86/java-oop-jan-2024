package reflection_and_annotation.barracksWars.core.commands;

import reflection_and_annotation.barracksWars.interfaces.Executable;
import reflection_and_annotation.barracksWars.interfaces.Repository;
import reflection_and_annotation.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;

    public Command(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }
}
