package com.tomekl007;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArrayTest {
    @Test
    public void addingToArrayOnASpecificIndex() {
        //given
        int[] input = new int[10];

        //when
        input[0] = 1;
        input[9] = 199;

        //then lookup is O(1) - don't need to iterate over
        assertThat(input[9]).isEqualTo(199);
    }

    @Test
    public void shouldAddElementToArrayList() {
        //given
        List<String> list = new ArrayList<>();

        //when
        list.add("a");

        //then
        assertThat(list.size()).isEqualTo(1);

        //and when
        list.remove("a");
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void shouldGetElementByTheIndex() {
        //given
        ArrayList<String> list = new ArrayList<>();

        //when
        list.add("a");
        list.add("b");

        //then
        assertThat(list.get(0)).isEqualTo("a");
        assertThat(list.get(1)).isEqualTo("b");
    }


}
