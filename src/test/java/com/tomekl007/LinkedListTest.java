package com.tomekl007;

import com.tomekl007.list.CustomList;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LinkedListTest {
    @Test
    public void shouldAddElementToCustomList() {
        //given
        CustomList<String> list = new CustomList<>();

        //when
        list.add("a");

        //then
        assertThat(list.size()).isEqualTo(1);

        //and when
        list.add("b");
        list.add("c");
        list.add("d");
        assertThat(list.get(2)).isEqualTo("c");

    }

    @Test
    public void shouldRetrieveHeadAndTailOfTheCustomList() {
        //given
        CustomList<String> list = new CustomList<>();

        //when
        list.add("a");
        list.add("b");

        //then
        assertThat(list.peekFirst()).isEqualTo("a");
    }


    @Test
    public void shouldAddElementToList() {
        //given
        List<String> list = new LinkedList<>();

        //when
        list.add("a");

        //then
        assertThat(list.size()).isEqualTo(1);

        //and when
        list.remove("a");
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void shouldRetrieveHeadAndTailOfTheList() {
        //given
        LinkedList<String> list = new LinkedList<>();

        //when
        list.add("a");
        list.add("b");

        //then
        assertThat(list.peekLast()).isEqualTo("b");
        assertThat(list.peekFirst()).isEqualTo("a");
    }


}
