package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Lector extends Person {

    private long id;
    private List<Course> courses;

    public Lector(String name, int age, long id) {
        super(name, age);
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public void printLector() {
        printName();
        System.out.println("Lector id: " + this.id);
    }
}
