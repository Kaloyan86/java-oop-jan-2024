package reflection_and_annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import inheritance.person.Person;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

//        Person no_name = new Person("No name", 0);

        // access class
        Class<Person> personClass = Person.class;
//        Class<Person> person = (Class<Person>) Class.forName("Person");
//        Class<? extends Person> aClass = no_name.getClass();

        // access fields
        Field[] allFields = personClass.getDeclaredFields(); // return all fields (pulbic , private, protected)
        Field[] publicFields = personClass.getFields(); // return only public fields

        for (Field field : allFields) {
//            System.out.println(field.getName());
//            System.out.println(Modifier.toString(field.getModifiers()));
//            System.out.println(Modifier.isPublic(field.getModifiers())); // check whether modifier is public
        }

        Constructor<Person> publicConstructor = personClass.getDeclaredConstructor(String.class, int.class);
        Constructor<Person> privateConstructor = personClass.getDeclaredConstructor();

        Person kaloyan = publicConstructor.newInstance("Kaloyan", 35);

          System.out.println(kaloyan.getName());
//        System.out.println(kaloyan.getAge());

        privateConstructor.setAccessible(true);

        Person emptyPerson = privateConstructor.newInstance();

//        System.out.println(emptyPerson.getName());
//        System.out.println(emptyPerson.getAge());

        // access methods
        Method[] declaredMethods = personClass.getDeclaredMethods();
        Method[] publicMethodsOnly = personClass.getMethods();

        Method method = declaredMethods[1];

       // method.setAccessible(true); // access private method

        method.invoke(kaloyan, "Svetlin"); // invoke setName(String name);

        System.out.println(kaloyan.getName());

        Field field = allFields[0];
        field.setAccessible(true);

        System.out.println(field.get(kaloyan));


        List<Person> people = List.of(kaloyan, emptyPerson);
    }
}
