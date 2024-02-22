package working_with_abstractions.greedyTimes;

public enum ItemType {
    Gold,
    Gem,
    Cash;

    public static ItemType getItem(String name) {
        ItemType itemType = null;

        if (name.length() == 3) {
            itemType = ItemType.valueOf("Cash");
        } else if (name.toLowerCase().endsWith("gem")) {
            itemType = ItemType.valueOf("Gem");
        } else if (name.toLowerCase().equals("gold")) {
            itemType = ItemType.valueOf("Gold");
        }

        return itemType;
    }
}
