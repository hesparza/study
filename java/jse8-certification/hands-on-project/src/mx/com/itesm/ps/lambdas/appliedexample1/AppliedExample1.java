package mx.com.itesm.ps.lambdas.appliedexample1;

import mx.com.itesm.ps.lambdas.appliedexample1.util.Person;

import java.util.function.Function;

/**
 * module1
 *
 * @author hesparza on 5/26/18
 */
public class AppliedExample1 {

    public static void main(String... args) {
        final AppliedExample1 app = new AppliedExample1();
        app.exercise1();
        app.exercise2();
    }

    private void exercise1() {
        Comparator1<Person> cmpAge = (p1, p2) -> p1.getAge() - p2.getAge();
        Comparator1<Person> cmpFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Comparator1<Person> cmpLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());

        Function<Person, Integer> f1 = p-> p.getAge();
        Function<Person, String> f2 = p-> p.getFirstName();
        Function<Person, String> f3 = p-> p.getLastName();



        Comparator1<Person> cmpPerson = Comparator1.comparing(f1);
        //equivalent to:
        Comparator1<Person> cmpPerson2 = Comparator1.comparing(Person::getAge);
    }

    private void exercise2() {
        Comparator2<Person> cmpAge = (p1, p2) -> p1.getAge() - p2.getAge();
        Comparator2<Person> cmpFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Comparator2<Person> cmpLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());

        Function<Person, Comparable> f1 = p-> p.getAge();
        Function<Person, String> f2 = p-> p.getFirstName();
        Function<Person, String> f3 = p-> p.getLastName();


        //notice the usage of static methods in interfaces
        Comparator2<Person> cmpPerson = Comparator2.comparing(f1);
        //equivalent to:
        Comparator2<Person> cmpPerson2 = Comparator2.comparing(Person::getAge);
    }
}
