package com.github.fge.lambdas.functions.intfunctions;

import com.github.fge.lambdas.ThrownByLambdaException;

import java.util.function.IntFunction;

@FunctionalInterface
public interface ThrowingIntFunction<R>
    extends IntFunction<R>
{
    R doApply(int value)
        throws Throwable;

    @Override
    default R apply(int value)
    {
        try {
            return doApply(value);
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Throwable tooBad) {
            throw new ThrownByLambdaException(tooBad);
        }
    };
}
