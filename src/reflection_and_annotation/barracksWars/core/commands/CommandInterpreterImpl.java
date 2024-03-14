package reflection_and_annotation.barracksWars.core.commands;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import reflection_and_annotation.barracksWars.core.Inject;
import reflection_and_annotation.barracksWars.interfaces.CommandInterpreter;
import reflection_and_annotation.barracksWars.interfaces.Executable;
import reflection_and_annotation.barracksWars.interfaces.Repository;
import reflection_and_annotation.barracksWars.interfaces.UnitFactory;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String UNITS_PACKAGE_NAME =
    "reflection_and_annotation.barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String className = UNITS_PACKAGE_NAME +
                           Character.toUpperCase(commandName.charAt(0)) +
                           commandName.substring(1) +
                           "Command";

        Class<Command> commandClazz = (Class<Command>) Class.forName(className);

        //TODO use Inject annotation in order to inject annotated fields

        Field[] declaredFields = commandClazz.getDeclaredFields();

        Constructor<Command> con = commandClazz.getDeclaredConstructor
                                               (String[].class, Repository.class, UnitFactory.class);

        return con.newInstance(data, repository, unitFactory);
    }
}
