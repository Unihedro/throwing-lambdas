package com.github.fge.lambdas.functions;

import com.github.fge.lambdas.ThrownByLambdaException;

import java.util.function.ToDoubleFunction;

@FunctionalInterface
public interface ThrowingToDoubleFunction<T>
    extends ToDoubleFunction<T>
{
    double doApplyAsDouble(T value)
        throws Throwable;

    @Override
    default double applyAsDouble(T value)
    {
        try {
            return doApplyAsDouble(value);
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Throwable tooBad) {
            throw new ThrownByLambdaException(tooBad);
        }
    }
}
