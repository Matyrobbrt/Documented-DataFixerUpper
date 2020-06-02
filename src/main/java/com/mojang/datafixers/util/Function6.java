package com.mojang.datafixers.util;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A function with six parameters.
 *
 * @param <T1> The first parameter type.
 * @param <T2> The second parameter type.
 * @param <T3> The third parameter type.
 * @param <T4> The fourth parameter type.
 * @param <T5> The fifth parameter type.
 * @param <T6> The sixth parameter type.
 * @param <R>  The return value.
 */
public interface Function6<T1, T2, T3, T4, T5, T6, R> {
    /**
     * Applies this function to the parameters.
     *
     * @param t1 The first input value.
     * @param t2 The second input value.
     * @param t3 The third input value.
     * @param t4 The fourth input value.
     * @param t5 The fifth input value.
     * @param t6 The sixth input value.
     * @return The result of this function.
     */
    R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6);

    /**
     * Curries this function into a {@link Function} returning a {@link Function5}.
     *
     * @return The curried function.
     */
    default Function<T1, Function5<T2, T3, T4, T5, T6, R>> curry() {
        return t1 -> (t2, t3, t4, t5, t6) -> apply(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Curries this function into a {@link BiFunction} returning a {@link Function4}.
     *
     * @return The curried function.
     */
    default BiFunction<T1, T2, Function4<T3, T4, T5, T6, R>> curry2() {
        return (t1, t2) -> (t3, t4, t5, t6) -> apply(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Curries this function into a {@link Function3} returning a {@link Function3}.
     *
     * @return The curried function.
     */
    default Function3<T1, T2, T3, Function3<T4, T5, T6, R>> curry3() {
        return (t1, t2, t3) -> (t4, t5, t6) -> apply(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Curries this function into a {@link Function4} returning a {@link BiFunction}.
     *
     * @return The curried function.
     */
    default Function4<T1, T2, T3, T4, BiFunction<T5, T6, R>> curry4() {
        return (t1, t2, t3, t4) -> (t5, t6) -> apply(t1, t2, t3, t4, t5, t6);
    }

    /**
     * Curries this function into a {@link Function5} returning a {@link Function}.
     *
     * @return The curried function.
     */
    default Function5<T1, T2, T3, T4, T5, Function<T6, R>> curry5() {
        return (t1, t2, t3, t4, t5) -> t6 -> apply(t1, t2, t3, t4, t5, t6);
    }
}
