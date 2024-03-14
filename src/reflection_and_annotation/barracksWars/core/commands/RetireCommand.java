package reflection_and_annotation.barracksWars.core.commands;

import jdk.jshell.spi.ExecutionControl;
import reflection_and_annotation.barracksWars.core.Inject;
import reflection_and_annotation.barracksWars.interfaces.Repository;
import reflection_and_annotation.barracksWars.interfaces.UnitFactory;

public class RetireCommand extends Command {

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = getData()[1];

        repository.removeUnit(unitType);

        return unitType + " retired!";
    }
}
