package com.github.fge.lambdas.functions.longfunctions;

import com.github.fge.lambdas.ThrowablesFactory;
import com.github.fge.lambdas.ThrowingFunctionalInterface;
import com.github.fge.lambdas.ThrownByLambdaException;

import java.util.function.LongFunction;

/**
 * A throwing {@link LongFunction}
 *
 * @param <R> parameter type of the return value of this function
 */
@FunctionalInterface
public interface ThrowingLongFunction<R>
    extends LongFunction<R>,
    ThrowingFunctionalInterface<ThrowingLongFunction<R>, LongFunction<R>>
{
    R doApply(long value)
        throws Throwable;

    @Override
    default R apply(long value)
    {
        try {
            return doApply(value);
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Throwable tooBad) {
            throw new ThrownByLambdaException(tooBad);
        }
    }

    @Override
    default ThrowingLongFunction<R> orTryWith(
        ThrowingLongFunction<R> other)
    {
        return value -> {
            try {
                return doApply(value);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable ignored) {
                return other.apply(value);
            }
        };
    }

    @Override
    default LongFunction<R> fallbackTo(LongFunction<R> fallback)
    {
        return value -> {
            try {
                return doApply(value);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable ignored) {
                return fallback.apply(value);
            }
        };
    }

    @Override
    default <E extends RuntimeException> LongFunction<R> orThrow(
        Class<E> exceptionClass)
    {
        return value -> {
            try {
                return doApply(value);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw ThrowablesFactory.INSTANCE.get(exceptionClass, tooBad);
            }
        };
    }

    default LongFunction<R> orReturn(R defaultValue)
    {
        return value -> {
            try {
                return doApply(value);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable ignored) {
                return defaultValue;
            }
        };
    }
}
