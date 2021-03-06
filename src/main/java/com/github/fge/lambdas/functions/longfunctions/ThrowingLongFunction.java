package com.github.fge.lambdas.functions.longfunctions;

import com.github.fge.lambdas.ThrownByLambdaException;

import java.util.function.LongFunction;

@FunctionalInterface
public interface ThrowingLongFunction<R>
    extends LongFunction<R>
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



}
