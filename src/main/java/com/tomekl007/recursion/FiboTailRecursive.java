package com.tomekl007.recursion;

public class FiboTailRecursive implements Fibo {

    @Override
    public long fib(long index) {
        return fib(index, 1, 0);
    }

    private long fib(long n, long a, long b) {
        return n == 0 ? b : fib(n - 1, a + b, a);
    }

}
