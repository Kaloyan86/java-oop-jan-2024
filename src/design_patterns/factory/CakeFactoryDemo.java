package design_patterns.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class CakeFactoryDemo {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        double diameter = Double.parseDouble(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        int pieces = Integer.parseInt(scanner.nextLine());

        Cake cake = PastryShop.orderCake(type, diameter, price, pieces);
    }
}
