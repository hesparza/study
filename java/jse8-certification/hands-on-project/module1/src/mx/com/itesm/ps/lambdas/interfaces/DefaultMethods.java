package mx.com.itesm.ps.lambdas.interfaces;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;

public class DefaultMethods {

    //Common type of interface
    public interface Iterable<T> extends Collection<T> {

        void something();

        default void forEach(Consumer<? super T> action) {
            Objects.requireNonNull(action);
            for (T t: this) {
                action.accept(t);
            }
        }
    }

}
