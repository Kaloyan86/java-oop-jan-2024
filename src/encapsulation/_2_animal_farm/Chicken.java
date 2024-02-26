package encapsulation._2_animal_farm;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public String toString() {
        return String.format("encapsulation._2_animal_farm.Chicken %s (age %d) can produce %.2f eggs per day.",
                             this.name,
                             this.age,
                             this.calculateProductPerDay());
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {

        //  First 6 years it produces 2 eggs per day [0 - 5].
        if (this.age < 6) {
            return 2;
        } else if (this.age < 12) {
            //	Next 6 years it produces 1 egg per day [6 - 11].
            return 1;
        }

        //	And after that, it produces 0.75 eggs per day.
        return 0.75;
    }

    private void setName(String name) {
        if (null == name || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }
}
