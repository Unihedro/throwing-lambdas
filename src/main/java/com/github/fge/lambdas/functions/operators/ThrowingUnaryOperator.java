package com.github.fge.lambdas.functions.operators;

import com.github.fge.lambdas.ThrowablesFactory;
import com.github.fge.lambdas.ThrownByLambdaException;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface ThrowingUnaryOperator<T>
    extends UnaryOperator<T>
{
    T doApply(T t)
        throws Throwable;

    @Override
    default T apply(T t)
    {
        try {
            return doApply(t);
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Throwable tooBad) {
            throw new ThrownByLambdaException(tooBad);
        }
    }

    default UnaryOperator<T> orReturn(T defaultValue)
    {
        return t -> {
            try {
                return doApply(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                return defaultValue;
            }
        };
    }

    default UnaryOperator<T> orReturnSelf()
    {
        return t -> t;
    }

    default <E extends RuntimeException> UnaryOperator<T> orThrow(
        Class<E> exceptionClass)
    {
        return t -> {
            try {
                return doApply(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw ThrowablesFactory.INSTANCE.get(exceptionClass, tooBad);
            }
        };
    }
}
