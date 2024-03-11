package solid_principles.solid;

import java.util.List;

import solid_principles.solid.products.Chips;

public class Main {

    public static void main(String[] args) {

        QuantityCalculator quantityCalculator = new QuantityCalculator();

        List<Chips> chipsList = List.of(new Chips(150));

//        quantityCalculator.sum(chipsList);
//        quantityCalculator.average(chipsList);
    }
}
