package working_with_abstractions.greedyTimes;

import java.util.Scanner;

import static working_with_abstractions.greedyTimes.ItemType.getItem;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");
        Bag bag = new Bag(bagCapacity);
        // Bag -> capacity, List<Item>
        // Item -> name, amount, ItemType
        // ItemType -> Cash, Gem, Gold

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            // Get Item type
            ItemType itemType = getItem(name);
            // Create Item
            Item item = new Item(itemType, name, amount);
            // Put the item to the bag
            bag.add(item);
        }
        // print bag
        bag.print();
    }
}