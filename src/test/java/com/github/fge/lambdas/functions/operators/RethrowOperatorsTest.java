package com.github.fge.lambdas.functions.operators;

import com.github.fge.lambdas.ThrownByLambdaException;
import com.github.fge.lambdas.helpers.Type1;
import org.testng.annotations.Test;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static com.github.fge.lambdas.functions.operators.Operators.rethrow;
import static com.github.fge.lambdas.helpers.CustomAssertions.shouldHaveThrown;
import static com.github.fge.lambdas.helpers.Throwables.CHECKED;
import static com.github.fge.lambdas.helpers.Throwables.ERROR;
import static com.github.fge.lambdas.helpers.Throwables.UNCHECKED;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ErrorNotRethrown")
public final class RethrowOperatorsTest
{
    @Test
    public void wrappedUnaryOperatorThrowsAppropriateException()
    {
        ThrowingUnaryOperator<Type1> o;

        o = t -> { throw CHECKED; };

        try {
            Stream.of(Type1.mock()).map(rethrow(o)).count();
            shouldHaveThrown(ThrownByLambdaException.class);
        } catch (ThrownByLambdaException e) {
            assertThat(e.getCause()).isSameAs(CHECKED);
        }

        o = t -> { throw UNCHECKED; };

        try {
            Stream.of(Type1.mock()).map(rethrow(o)).count();
            shouldHaveThrown(RuntimeException.class);
        } catch (RuntimeException e) {
            assertThat(e).isSameAs(UNCHECKED);
        }

        o = t -> { throw ERROR; };

        try {
            Stream.of(Type1.mock()).map(rethrow(o)).count();
            shouldHaveThrown(Error.class);
        } catch (Error e) {
            assertThat(e).isSameAs(ERROR);
        }
    }

    @Test
    public void wrappedIntUnaryOperatorThrowsAppropriateException()
    {
        ThrowingIntUnaryOperator o;

        o = operand -> { throw CHECKED; };

        try {
            IntStream.iterate(0, rethrow(o)).count();
            shouldHaveThrown(ThrownByLambdaException.class);
        } catch (ThrownByLambdaException e) {
            assertThat(e.getCause()).isSameAs(CHECKED);
        }

        o = operand -> { throw UNCHECKED; };

        try {
            IntStream.iterate(0, rethrow(o)).count();
            shouldHaveThrown(RuntimeException.class);
        } catch (RuntimeException e) {
            assertThat(e).isSameAs(UNCHECKED);
        }

        o = operand -> { throw ERROR; };

        try {
            IntStream.iterate(0, rethrow(o)).count();
            shouldHaveThrown(Error.class);
        } catch (Error e) {
            assertThat(e).isSameAs(ERROR);
        }
    }

    @Test
    public void wrappedLongUnaryOperatorThrowsAppropriateException()
    {
        ThrowingLongUnaryOperator o;

        o = operand -> { throw CHECKED; };

        try {
            LongStream.iterate(0L, rethrow(o)).count();
            shouldHaveThrown(ThrownByLambdaException.class);
        } catch (ThrownByLambdaException e) {
            assertThat(e.getCause()).isSameAs(CHECKED);
        }

        o = operand -> { throw UNCHECKED; };

        try {
            LongStream.iterate(0L, rethrow(o)).count();
            shouldHaveThrown(RuntimeException.class);
        } catch (RuntimeException e) {
            assertThat(e).isSameAs(UNCHECKED);
        }

        o = operand -> { throw ERROR; };

        try {
            LongStream.iterate(0L, rethrow(o)).count();
            shouldHaveThrown(Error.class);
        } catch (Error e) {
            assertThat(e).isSameAs(ERROR);
        }
    }

    @Test
    public void wrappedDoubleUnaryOperatorThrowsAppropriateException()
    {
        ThrowingDoubleUnaryOperator o;

        o = operand -> { throw CHECKED; };

        try {
            DoubleStream.iterate(0.0, rethrow(o)).count();
            shouldHaveThrown(ThrownByLambdaException.class);
        } catch (ThrownByLambdaException e) {
            assertThat(e.getCause()).isSameAs(CHECKED);
        }

        o = operand -> { throw UNCHECKED; };

        try {
            DoubleStream.iterate(0.0, rethrow(o)).count();
            shouldHaveThrown(RuntimeException.class);
        } catch (RuntimeException e) {
            assertThat(e).isSameAs(UNCHECKED);
        }

        o = operand -> { throw ERROR; };

        try {
            DoubleStream.iterate(0.0, rethrow(o)).count();
            shouldHaveThrown(Error.class);
        } catch (Error e) {
            assertThat(e).isSameAs(ERROR);
        }
    }

    @Test
    public void wrappedBinaryOperatorThrowsAppropriateException()
    {
        ThrowingBinaryOperator<Type1> o;

        o = (t, u) -> { throw CHECKED; };

        try {
            Stream.of(Type1.mock(), Type1.mock()).reduce(rethrow(o));
            shouldHaveThrown(ThrownByLambdaException.class);
        } catch (ThrownByLambdaException e) {
            assertThat(e.getCause()).isSameAs(CHECKED);
        }

        o = (t, u) -> { throw UNCHECKED; };

        try {
            Stream.of(Type1.mock(), Type1.mock()).reduce(rethrow(o));
            shouldHaveThrown(RuntimeException.class);
        } catch (RuntimeException e) {
            assertThat(e).isSameAs(UNCHECKED);
        }

        o = (t, u) -> { throw ERROR; };

        try {
            Stream.of(Type1.mock(), Type1.mock()).reduce(rethrow(o));
            shouldHaveThrown(Error.class);
        } catch (Error e) {
            assertThat(e).isSameAs(ERROR);
        }
    }

    @Test
    public void wrappedIntBinaryOperatorThrowsAppropriateException()
    {
        ThrowingIntBinaryOperator o;

        o = (left, right) -> { throw CHECKED; };

        try {
            IntStream.of(0, 0).reduce(rethrow(o));
            shouldHaveThrown(ThrownByLambdaException.class);
        } catch (ThrownByLambdaException e) {
            assertThat(e.getCause()).isSameAs(CHECKED);
        }

        o = (left, right) -> { throw UNCHECKED; };

        try {
            IntStream.of(0, 0).reduce(rethrow(o));
            shouldHaveThrown(RuntimeException.class);
        } catch (RuntimeException e) {
            assertThat(e).isSameAs(UNCHECKED);
        }

        o = (left, right) -> { throw ERROR; };

        try {
            IntStream.of(0, 0).reduce(rethrow(o));
            shouldHaveThrown(Error.class);
        } catch (Error e) {
            assertThat(e).isSameAs(ERROR);
        }
    }

    @Test
    public void wrappedLongBinaryOperatorThrowsAppropriateException()
    {
        ThrowingLongBinaryOperator o;

        o = (left, right) -> { throw CHECKED; };

        try {
            LongStream.of(0L, 0L).reduce(rethrow(o));
            shouldHaveThrown(ThrownByLambdaException.class);
        } catch (ThrownByLambdaException e) {
            assertThat(e.getCause()).isSameAs(CHECKED);
        }

        o = (left, right) -> { throw UNCHECKED; };

        try {
            LongStream.of(0L, 0L).reduce(rethrow(o));
            shouldHaveThrown(RuntimeException.class);
        } catch (RuntimeException e) {
            assertThat(e).isSameAs(UNCHECKED);
        }

        o = (left, right) -> { throw ERROR; };

        try {
            LongStream.of(0L, 0L).reduce(rethrow(o));
            shouldHaveThrown(Error.class);
        } catch (Error e) {
            assertThat(e).isSameAs(ERROR);
        }
    }

    @Test
    public void wrappedDoubleBinaryOperatorThrowsAppropriateException()
    {
        ThrowingDoubleBinaryOperator o;

        o = (left, right) -> { throw CHECKED; };

        try {
            DoubleStream.of(0.0, 0.0).reduce(rethrow(o));
            shouldHaveThrown(ThrownByLambdaException.class);
        } catch (ThrownByLambdaException e) {
            assertThat(e.getCause()).isSameAs(CHECKED);
        }

        o = (left, right) -> { throw UNCHECKED; };

        try {
            DoubleStream.of(0.0, 0.0).reduce(rethrow(o));
            shouldHaveThrown(RuntimeException.class);
        } catch (RuntimeException e) {
            assertThat(e).isSameAs(UNCHECKED);
        }

        o = (left, right) -> { throw ERROR; };

        try {
            DoubleStream.of(0.0, 0.0).reduce(rethrow(o));
            shouldHaveThrown(Error.class);
        } catch (Error e) {
            assertThat(e).isSameAs(ERROR);
        }
    }
}
