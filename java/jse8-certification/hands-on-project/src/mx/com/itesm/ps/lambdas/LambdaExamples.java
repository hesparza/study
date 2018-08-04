package mx.com.itesm.ps.lambdas;

import com.sun.istack.internal.NotNull;

import javax.xml.bind.annotation.XmlValue;
import java.util.Comparator;

public class LambdaExamples {

    /**
     *  Example with the Runnable interface
     */
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while(i++ < 10) {
                System.out.println("It works!");
            }
        }
    };
    //               ||
    //               ||
    //              \\//
    //               \/
    //Becomes into the following
    Runnable runnableLambda = () -> {
        int i = 0;
        while(i++ < 10) {
            System.out.println("It works!");
        }
    };


    /**
     * Example with the Comparator1 interface
     */
    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return Integer.compare(s1.length(), s2.length());
        }
    };
    //               ||
    //               ||
    //              \\//
    //               \/
    //Becomes into the following
    Comparator<String> comparatorLambda = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
    //We can use the "final" keyword to prevent the parameters to be modified
    Comparator<String> comparatorLambda2 = (final String s1, final String s2) -> Integer.compare(s1.length(), s2.length());
    //We can use annotations in the lambda parameters
    Comparator<String> comparatorLambda3 = (@NotNull final String s1, @NotNull final String s2) -> Integer.compare(s1.length(), s2.length());
    //We can avoid setting the object type
    Comparator<String> comparatorLambda4 = (s1, s2) -> Integer.compare(s1.length(), s2.length());
    //When the lambda expression has more than one line of code, it must have a return expression
    Comparator<String> comparatorLambda5 = (s1, s2) -> {
        System.out.println("It Works!");
        return Integer.compare(s1.length(), s2.length());
    };

    //Notes:
    /**
     * ==========================================================================
     * NOTES:
     * We can use the "final" keyword to prevent the parameters to be modified
     * We can use annotations in the lambda parameters
     * It is not possible to specify the return type of a lambda expression
     * We can avoid setting the object type as it is inferred from the method being overriden
     * When the lambda expression has more than one line of code, it must have a return expression
     */
    //


}
