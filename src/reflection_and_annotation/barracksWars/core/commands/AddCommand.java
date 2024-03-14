package reflection_and_annotation.barracksWars.core.commands;

import java.lang.reflect.InvocationTargetException;

import jdk.jshell.spi.ExecutionControl;
import reflection_and_annotation.barracksWars.core.Inject;
import reflection_and_annotation.barracksWars.interfaces.Repository;
import reflection_and_annotation.barracksWars.interfaces.Unit;
import reflection_and_annotation.barracksWars.interfaces.UnitFactory;

public class AddCommand extends Command {

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;


    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = getData()[1];
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
