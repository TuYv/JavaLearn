package com.rick.springcloud.stream;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Seq<T> {
    void consume(Consumer<T> consumer);
    static <T> T stop() {
        throw StopException.INSTANCE;
    }
    static <T> Seq<T> unit(T t) {
        return c -> c.accept(t);
    }
    default <E> Seq<E> map(Function<T, E> f) {
        return c -> this.consume(t -> c.accept(f.apply(t)));
    }
    default <E> Seq<E> flatMap(Function<T, Seq<E>> f) {
        return c -> this.consume(t -> f.apply(t).consume(c));
    }
    default Seq<T> filter(Predicate<T> predicate) {
        return  c -> this.consume(t -> {
            if (predicate.test(t)) {
                c.accept(t);
            }
        });
    }
    default void consumeTillStop(Consumer<T> consumer) {
        try{
            consume(consumer);
        } catch (StopException ignore) {}
    }
    default Seq<T> take(int n) {
        return c -> {
            int[] i = {n};
            consumeTillStop(t -> {
                if (i[0]-- > 0) {
                    c.accept(t);
                } else {
                    stop();
                }
            });
        };
    }
    default Seq<T> drop(int n) {
        return c -> {
            int[] i = {1 - n};
            consume(t -> {
                if (i[0]++ > 0) {
                    c.accept(t);
                }
            });
        };
    }
    default Seq<T> onEach(Consumer<T> consumer) {
        return c -> consume(consumer.andThen(c));
    }
    default <E,R> Seq<R> zip(Iterable<E> iterable, BiFunction<T,E,R> function) {
        return c -> {
            Iterator<E> iterator = iterable.iterator();
            consumeTillStop(t -> {
                if (iterator.hasNext()) {
                    c.accept(function.apply(t, iterator.next()));
                } else {
                    stop();
                }
            });
        };
    }
}
