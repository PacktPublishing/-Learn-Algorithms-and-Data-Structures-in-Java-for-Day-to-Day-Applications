package com.tomekl007;

import java.util.Arrays;

public class Complexity {

    //O(1)
    //This function runs in O(1) time (or "constant time") relative to its input.
    //The input array could be 1 item or 1,000 items,
    //but this function would still just require one "step."
    public static void printFirstItem(int[] arrayOfItems) {
        System.out.println(arrayOfItems[0]);
    }

    //O(N)
    //This function runs in O(n) time (or "linear time"),
    // where n is the number of items in the array.
    // If the array has 10 items, we have to print 10 times.
    // If it has 1,000 items, we have to print 1,000 times
    public static void printAllItems(int[] arrayOfItems) {
        for (int item : arrayOfItems) {
            System.out.println(item);
        }
    }

    //O(N^2)
    /*
    Here we're nesting two loops.
    If our array has n items, our outer loop runs n times and our inner loop runs n times for each iteration
    of the outer loop, giving us n^2​​  total prints.
    Thus this function runs in O(n^2) time (or "quadratic time").
    If the array has 10 items, we have to print 100 times.
    If it has 1,000 items, we have to print 1,000,000 times
     */
    public static void printAllPossibleOrderedPairs(int[] arrayOfItems) {
        for (int firstItem : arrayOfItems) {
            for (int secondItem : arrayOfItems) {
                int[] orderedPair = new int[]{firstItem, secondItem};
                System.out.println(Arrays.toString(orderedPair));
            }
        }
    }

    //O(N) + O(N) = O(N)
    /*
    When you're calculating the big O complexity of something,
    you just throw out the constants.
    So like:
     */
    public static void printAllItemsTwice(int[] theArray) {
        for (int item : theArray) {
            System.out.println(item);
        }

        for (int item : theArray) {
            System.out.println(item);
        }
    }
}
