package com.github.fge.lambdas.functions.operators;

import com.github.fge.lambdas.ThrownByLambdaException;

import java.util.function.IntUnaryOperator;

@FunctionalInterface
public interface ThrowingIntUnaryOperator
    extends IntUnaryOperator
{
    int doApplyAsInt(int operand)
        throws Throwable;

    @Override
    default int applyAsInt(int operand)
    {
        try {
            return doApplyAsInt(operand);
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Throwable tooBad) {
            throw new ThrownByLambdaException(tooBad);
        }
    }
}
