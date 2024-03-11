package solid_principles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    /*
        S -> Single responsibility - class should only have one responsibility
        O -> Open-closed - open for extension, but close for modifications
        L -> Liskov substitution - object should be replaceable with instances of
             their subtypes without altering the correctness of the program
        I -> Interface segregation - many specific interfaces are better than one
             general interface
        D -> Dependency inversion - depends on abstraction not concretions
     */

    public static void main(String[] args) {
        LinkedList<Integer> numbers1 = new LinkedList<>();
        List<String> numbers2 = new ArrayList<>();

        printList(numbers1);
    }

    public static void printList(List<?> stringLinkedList) {
        stringLinkedList.forEach(System.out::println);
    }
}







