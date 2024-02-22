package working_with_abstractions;

public enum Size {
    EXTRA_SMALL,
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE;

    public static void printEnums() {
        for (Size size : Size.values()) {
            System.out.println(size);
        }
    }
}
