package mx.com.itesm.ps.lambdas;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferences {

    // -- Example 1 ------------------------------------------------------->
    //origin:
    Function<Person, Integer> f = new Function<Person, Integer>() {
        @Override
        public Integer apply(Person person) {
            return person.getAge();
        }
    };
    //lambda expression:
    Function<Person, Integer> f1 = person -> person.getAge();
    //               ||
    //               ||
    //              \\//
    //               \/
    //method reference equivalent
    Function<Person, Integer> f2 = Person::getAge;

    //anonymous class Person
    class Person {
        private Integer age;
        public Integer getAge(){return this.age;}
    }

    // -- Example 2 ------------------------------------------------------->
    //origin:
    BinaryOperator<Integer> sum = new BinaryOperator<Integer>() {
        @Override
        public Integer apply(Integer i1, Integer i2) {
            //return i1 + i2;
            // or
            return Integer.sum(i1, i2);
        }
    };
    //lambda expression:
    BinaryOperator<Integer> sum1 = (i1, i2) -> i1 + i2;
    //equivalent to:
    BinaryOperator<Integer> sum2 = (i1, i2) -> Integer.sum(i1, i2);
    //               ||
    //               ||
    //              \\//
    //               \/
    //method reference equivalent
    BinaryOperator<Integer> sum3 = Integer::sum;
    //could also be
    BinaryOperator<Integer> sum4 = Integer::max;

    // -- Example 3 ------------------------------------------------------->
    //lambda expression:
    Consumer<String> printer = s -> System.out.println(s);
    //               ||
    //               ||
    //              \\//
    //               \/
    //method reference equivalent
    Consumer<String> printer2 = System.out::println;
}


//Notes:
/**
 * ==========================================================================
 * NOTES:
 * Method references are alternative syntax for writing lambda expressions
 * They work with methods
 * They have nothing to do with static code, example one is calling a method that is not static for example.
 *
 *
 * Java Doc: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 Kinds of Method References
 There are four kinds of method references:
 Kind 	                                                                        Example
 Reference to a static method 	                                                ContainingClass::staticMethodName
 Reference to an instance method of a particular object 	                    containingObject::instanceMethodName
 Reference to an instance method of an arbitrary object of a particular type 	ContainingType::methodName
 Reference to a constructor 	                                                ClassName::new
 *
 */
//


