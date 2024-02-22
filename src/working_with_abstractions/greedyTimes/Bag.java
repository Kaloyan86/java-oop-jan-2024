package working_with_abstractions.greedyTimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bag {

    private List<Item> items;
    private long capacity;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public void add(Item itemToAdd) {
        //TODO check for null item
        // if I can
        if (canAdd(itemToAdd)) {
            Item item = getItem(itemToAdd);

            if (item == null) {
                this.items.add(item);
            } else {
                item.setAmount(item.getAmount() + itemToAdd.getAmount());
            }
        }
    }

    private Item getItem(Item itemToAdd) {
        return this.items.stream()
                         .filter(i -> i.equals(itemToAdd))
                         .findFirst()
                         .orElse(null);
    }

    private boolean canAdd(Item item) {
        // if there is no capacity can't add
        if (this.capacity < getTotalAmount() + item.getAmount()) {
            return false;
        }
        // if the item is null can't add
        if (item.getItemType() == null) {
            return false;
        }

        switch (item.getItemType()) {
            case Gem:
                // The gold amount in your bag should always be more than
                // or equal to the gem amount at any time
                if (item.getAmount() + getTotalAmountByType(ItemType.Gem) >
                    getTotalAmountByType(ItemType.Gold)) {
                    return false;
                }
                break;
            case Cash:
                // The gem amount should always be more than
                // or equal to the cash amount at any time
                if (item.getAmount() + getTotalAmountByType(ItemType.Cash) >
                    getTotalAmountByType(ItemType.Gem)) {
                    return false;
                }
                break;
        }

        return true;
    }

    private long getTotalAmountByType(ItemType itemType) {
        return this.items.stream()
                         .filter(item -> item.getItemType().equals(itemType))
                         .mapToLong(Item::getAmount)
                         .sum();
    }

    private long getTotalAmount() {
        return this.items.stream()
                         .mapToLong(Item::getAmount)
                         .sum();
    }

    public void print() {
        //TODO
    }
}
