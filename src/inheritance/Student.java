package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private long id;
    private List<Grade> grades;

    public Student(String name, int age, long id) {
        super(name, age);
        this.id = id;
        this.grades = new ArrayList<>();
    }


    public void printStudent() {
        printName();
        System.out.println("Student id: " + this.id);
    }
}
