package reflection_and_annotation.barracksWars.core.factories;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import reflection_and_annotation.barracksWars.interfaces.Unit;
import reflection_and_annotation.barracksWars.interfaces.UnitFactory;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
    "reflection_and_annotation.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String className = UNITS_PACKAGE_NAME + unitType;

        Class unitClass = Class.forName(className);

        Constructor<Unit> con = unitClass.getDeclaredConstructor();

        return con.newInstance();
    }
}
