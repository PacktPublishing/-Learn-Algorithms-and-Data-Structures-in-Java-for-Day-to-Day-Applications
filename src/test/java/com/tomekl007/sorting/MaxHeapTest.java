package com.tomekl007.sorting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxHeapTest {

    @Test
    public void shouldBuildMaxHeap() {
        //given
        int[] input = new int[]{1, 2, 49, 100, 3};

        //when
        MaxHeap maxHeap = new MaxHeap(input.length - 1);

        //then
        maxHeap.heapify(input);
        assertThat(input).containsExactly(100, 49, 3, 2, 1);
    }

}