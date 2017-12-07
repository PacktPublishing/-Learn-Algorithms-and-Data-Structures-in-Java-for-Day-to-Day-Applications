package com.tomekl007.queue;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueTest {

    @Test
    public void shouldAddElementToTheQueueAndRetrieveIt() {
        //given
        Queue<String> strings = new LinkedBlockingQueue<>();

        //when
        strings.offer("a");
        String element = strings.poll();

        //then
        assertThat(element).isEqualTo("a");
        assertThat(strings.isEmpty()).isTrue();

    }

    @Test
    public void shouldAddElementToTheQueueAndRetrieveItButNotDelete() {
        //given
        Queue<String> strings = new LinkedBlockingQueue<>();

        //when
        strings.offer("a");
        String element = strings.peek();

        //then
        assertThat(element).isEqualTo("a");
        assertThat(strings.isEmpty()).isFalse();

    }
}
