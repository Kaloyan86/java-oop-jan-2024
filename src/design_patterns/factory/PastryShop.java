package design_patterns.factory;

import java.lang.reflect.InvocationTargetException;

public class PastryShop {

    private PastryShop() {
    }

    public static Cake orderCake(String type,
                                 double diameter,
                                 double price,
                                 int pieces) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Cake cake = CakeFactory.createCake(type, diameter, price, pieces);

        cake.prepare();
        cake.bake();
        cake.box();

        return cake;
    }
}
