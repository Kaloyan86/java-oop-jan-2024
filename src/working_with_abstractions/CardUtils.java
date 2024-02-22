package working_with_abstractions;

public class CardUtils {

    private CardUtils() {
    }

    public static <T extends Enum<T>> void printCards(T[] eNum, String type) {
        System.out.printf("Card %s:\n", type);
        for (T cardEnum : eNum) {
            System.out.printf("Ordinal value: %d; Name value: %s\n",
                              cardEnum.ordinal(),
                              cardEnum);
        }
    }
}
