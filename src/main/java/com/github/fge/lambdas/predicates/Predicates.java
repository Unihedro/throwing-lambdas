package com.github.fge.lambdas.predicates;

import java.util.function.Predicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.DoublePredicate;

public final class Predicates
{
    private Predicates()
    {
        throw new Error("nice try!");
    }

    /*
     * Predicates
     */

    public static <T> Predicate<T> rethrow(final ThrowingPredicate<T> p)
    {
        return p;
    }

    /*
     * Int predicates
     */

    public static IntPredicate rethrow(final ThrowingIntPredicate p)
    {
        return p;
    }

    /*
     * Long predicates
     */

    public static LongPredicate rethrow(final ThrowingLongPredicate p)
    {
        return p;
    }

    /*
     * Double predicates
     */

    public static DoublePredicate rethrow(final ThrowingDoublePredicate p)
    {
        return p;
    }
}