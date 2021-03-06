package com.github.fge.lambdas.predicates;

import com.github.fge.lambdas.ThrownByLambdaException;

import java.util.function.IntPredicate;

@FunctionalInterface
public interface ThrowingIntPredicate
    extends IntPredicate
{
    boolean doTest(int value)
        throws Throwable;
        
    @Override
    default boolean test(int value)
    {
        try {
            return doTest(value);
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Throwable tooBad) {
            throw new ThrownByLambdaException(tooBad);
        }
    }
}
