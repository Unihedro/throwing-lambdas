package com.github.fge.lambdas.functions;

import com.github.fge.lambdas.ThrowablesFactory;
import com.github.fge.lambdas.ThrownByLambdaException;

import java.util.function.ToLongFunction;

@FunctionalInterface
public interface ThrowingToLongFunction<T>
    extends ToLongFunction<T>
{
    long doApplyAsLong(T value)
        throws Throwable;

    @Override
    default long applyAsLong(T value)
    {
        try {
            return doApplyAsLong(value);
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Throwable tooBad) {
            throw new ThrownByLambdaException(tooBad);
        }
    }

    default ToLongFunction<T> orReturn(long defaultValue)
    {
        return value -> {
            try {
                return doApplyAsLong(value);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable ignored) {
                return defaultValue;
            }
        };
    }

    default <E extends RuntimeException> ToLongFunction<T> orThrow(
        Class<E> exceptionClass)
    {
        return value -> {
            try {
                return doApplyAsLong(value);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw ThrowablesFactory.INSTANCE.get(exceptionClass, tooBad);
            }
        };
    }
}
