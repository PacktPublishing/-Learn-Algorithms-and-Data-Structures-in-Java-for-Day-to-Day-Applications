package com.tomekl007.recursion;

import com.jayway.awaitility.Awaitility;
import com.jayway.awaitility.Duration;
import com.jayway.awaitility.core.ConditionTimeoutException;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class FiboRecursiveTest {

    @Test
    public void fiboRecursiveTest() {
        //given
        long number = 12;

        //when
        Fibo fibo = new FiboRecursive();
        Long result = fibo.fib(number);

        //then
        assertThat(result).isEqualTo(144L);

    }


    @Test
    public void fiboTailRecursiveTest() {
        //given
        long number = 12;

        //when
        Fibo fibo = new FiboTailRecursive();
        Long result = fibo.fib(number);

        //then
        assertThat(result).isEqualTo(144L);

    }

    @Test(expected = ConditionTimeoutException.class)
    public void fiboRecursiveTestHuge_whenDoNotUsingTailRecursion() {
        //given
        long number = 120;

        //when
        Fibo fibo = new FiboRecursive();
        AtomicLong result = new AtomicLong();
        Awaitility.await().atMost(new Duration(1, TimeUnit.MINUTES)).until(
                () -> result.set(fibo.fib(number))
        );

        //then
        assertThat(result.get()).isEqualTo(144L);
    }


    @Test
    public void fiboTailRecursiveTestHuge_shouldSuccessWhenUsingTailRecursion() {
        //given
        long number = 120;

        //when
        Fibo fibo = new FiboTailRecursive();
        AtomicLong result = new AtomicLong();
        result.set(fibo.fib(number));

        //then
        assertThat(result.get()).isEqualTo(4376692037216111008L);
    }
}