package com.github.fge.lambdas;


import com.github.fge.lambdas.consumers.ThrowingConsumer;
import com.github.fge.lambdas.functions.ThrowingDoubleFunction;
import com.github.fge.lambdas.functions.ThrowingDoubleToIntFunction;
import com.github.fge.lambdas.functions.ThrowingDoubleToLongFunction;
import com.github.fge.lambdas.functions.ThrowingFunction;
import com.github.fge.lambdas.functions.ThrowingIntFunction;
import com.github.fge.lambdas.functions.ThrowingIntToDoubleFunction;
import com.github.fge.lambdas.functions.ThrowingIntToLongFunction;
import com.github.fge.lambdas.functions.ThrowingLongFunction;
import com.github.fge.lambdas.functions.ThrowingLongToDoubleFunction;
import com.github.fge.lambdas.functions.ThrowingLongToIntFunction;
import com.github.fge.lambdas.predicates.ThrowingDoublePredicate;
import com.github.fge.lambdas.predicates.ThrowingIntPredicate;
import com.github.fge.lambdas.predicates.ThrowingLongPredicate;
import com.github.fge.lambdas.predicates.ThrowingPredicate;

import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.Predicate;

@SuppressWarnings("NonFinalUtilityClass")
public class Rethrow
{
    /*
     * FUNCTIONS
     */

    public static <T, R> Function<T, R> rethrow(final ThrowingFunction<T, R> f)
    {
        return t -> {
            try {
                return f.apply(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static <R> IntFunction<R> rethrow(final ThrowingIntFunction<R> f)
    {
        return t -> {
            try {
                return f.apply(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static <R> LongFunction<R> rethrow(final ThrowingLongFunction<R> f)
    {
        return t -> {
            try {
                return f.apply(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static <R> DoubleFunction<R> rethrow(
        final ThrowingDoubleFunction<R> f)
    {
        return t -> {
            try {
                return f.apply(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static IntToLongFunction rethrow(final ThrowingIntToLongFunction f)
    {
        return t -> {
            try {
                return f.apply(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static IntToDoubleFunction rethrow(
        final ThrowingIntToDoubleFunction f)
    {
        return t -> {
            try {
                return f.apply(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static LongToIntFunction rethrow(final ThrowingLongToIntFunction f)
    {
        return t -> {
            try {
                return f.apply(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static LongToDoubleFunction rethrow(
        final ThrowingLongToDoubleFunction f)
    {
        return t -> {
            try {
                return f.apply(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static DoubleToIntFunction rethrow(
        final ThrowingDoubleToIntFunction f)
    {
        return t -> {
            try {
                return f.apply(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static DoubleToLongFunction rethrow(
        final ThrowingDoubleToLongFunction f)
    {
        return t -> {
            try {
                return f.apply(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static <T> Predicate<T> rethrow(final ThrowingPredicate<T> p)
    {
        return t -> {
            try {
                return p.test(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static IntPredicate rethrow(final ThrowingIntPredicate p)
    {
        return t -> {
            try {
                return p.test(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static LongPredicate rethrow(final ThrowingLongPredicate p)
    {
        return t -> {
            try {
                return p.test(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    public static DoublePredicate rethrow(final ThrowingDoublePredicate p)
    {
        return t -> {
            try {
                return p.test(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }

    /*
     * CONSUMERS
     */

    public static <T> Consumer<T> rethrow(final ThrowingConsumer<T> c)
    {
        return t -> {
            try {
                c.accept(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw new ThrownFromLambdaException(tooBad);
            }
        };
    }
}
