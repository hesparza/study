package mx.com.itesm.ps.lambdas.appliedexample1;

import mx.com.itesm.ps.lambdas.appliedexample1.util.Person;

import java.util.function.Function;

/**
 * module1
 *
 * @author hesparza on 5/26/18
 */
@FunctionalInterface
public interface Comparator2<T> {
    int compare(T t1, T t2);

    public static Comparator2<Person> comparing(final Function<Person, Comparable> f) {

        /**
         * Common old implementation would be:
         */
        /*
       Comparator1<Person> comparator = new Comparator1<Person>() {
            @Override
            public int compare(Person t1, Person t2) {
                return f.apply(t1).compareTo(f.apply(t2));
            }
        };
        return comparator;
        */

        /**
         * lambda implementation:
         */
        return (p1,p2) -> f.apply(p1).compareTo(f.apply(p2));
    }
}
