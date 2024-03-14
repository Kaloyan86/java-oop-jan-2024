package reflection_and_annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AnnotationDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Employee employee = new Employee("Kaloyan");

        Company company = employee.getClass().getAnnotation(Company.class);
        //  Annotation[] declaredAnnotations = employee.getClass().getDeclaredAnnotations();
        // Annotation[] declaredAnnotations = employee.getClass().getAnnotations();

//        System.out.println(company.name());
//        System.out.println(company.town());

        System.out.println(company.annotationType());

//        System.out.println(employee.getClass().getName());
    }
}


















