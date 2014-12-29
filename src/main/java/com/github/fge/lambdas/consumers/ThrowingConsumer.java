package com.github.fge.lambdas.consumers;

import com.github.fge.lambdas.ThrowablesFactory;
import com.github.fge.lambdas.ThrowingFunctionalInterface;
import com.github.fge.lambdas.ThrownByLambdaException;

import java.util.function.Consumer;

/**
 * A throwing {@link Consumer}
 *
 * @param <T> parameter type of the argument of the consumer
 */
@FunctionalInterface
public interface ThrowingConsumer<T>
    extends Consumer<T>,
    ThrowingFunctionalInterface<ThrowingConsumer<T>, Consumer<T>>
{
    void doAccept(T t)
        throws Throwable;

    @Override
    default void accept(T t)
    {
        try {
            doAccept(t);
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Throwable tooBad) {
            throw new ThrownByLambdaException(tooBad);
        }
    }

    @Override
    default ThrowingConsumer<T> orTryWith(ThrowingConsumer<T> other)
    {
        return t -> {
            try {
                doAccept(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable ignored) {
                other.accept(t);
            }
        };
    }

    @Override
    default Consumer<T> fallbackTo(Consumer<T> fallback)
    {
        return t -> {
            try {
                doAccept(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable ignored) {
                fallback.accept(t);
            }
        };
    }

    @Override
    default <E extends RuntimeException> Consumer<T> orThrow(
        Class<E> exceptionClass)
    {
        return t -> {
            try {
                doAccept(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable tooBad) {
                throw ThrowablesFactory.INSTANCE.get(exceptionClass, tooBad);
            }
        };
    }

    default Consumer<T> orDoNothing()
    {
        return t -> {
            try {
                doAccept(t);
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable ignored) {
                // Does nothing.
            }
        };
    }
}
