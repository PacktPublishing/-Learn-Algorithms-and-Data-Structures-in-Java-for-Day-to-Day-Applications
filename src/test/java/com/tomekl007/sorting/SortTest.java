package com.tomekl007.sorting;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SortTest {

    @Test
    public void shouldSortElements() {
        //given
        Sort sort = new BubbleSort();
        int[] input = new int[]{4, 5, 1, 2, 10, 12, 1};

        //when
        sort.sort(input);

        //then
        assertThat(input).containsExactly(1, 1, 2, 4, 5, 10, 12);
    }

    @Test
    public void shouldSortElementsUsingHeapSort() {
        //given
        Sort sort = new HeapSort();
        int[] input = new int[]{4, 5, 1, 2, 10, 12, 1};

        //when
        sort.sort(input);

        //then
        assertThat(input).containsExactly(1, 1, 2, 4, 5, 10, 12);
    }
}