package design_patterns.singleton;

public class HashCode {

    private String point;
    private static HashCode instance;

    private HashCode(String point) {
        this.point = point;
    }

    public static HashCode getInstance(String point) {
        if (null == instance) {
            instance = new HashCode(point);
        }

        return instance;
    }

    public String getPoint() {
        return point;
    }
}
