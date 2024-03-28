package design_patterns.singleton;

public class HashCodeDemo {

    public static void main(String[] args) {

        HashCode instance1 = HashCode.getInstance("Hello Softuni!");
        HashCode instance2 = HashCode.getInstance("Kaloyan");

        System.out.println(instance1.getPoint().hashCode());
        System.out.println(instance2.getPoint().hashCode());

        System.out.println("Hello Softuni!".hashCode());

    }
}
