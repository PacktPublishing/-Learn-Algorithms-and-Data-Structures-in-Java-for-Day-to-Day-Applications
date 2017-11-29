package com.tomekl007.recursion;

public class FiboRecursive implements Fibo {
    public long fib(long index) {

        if (index == 0)
            return 0;

        else if (index == 1)
            return 1;

        else
            return fib(index - 1) + fib(index - 2);
    }
}
