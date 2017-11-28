package com.tomekl007;

import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StackTest {
    @Test
    public void whenPushToStackThenShouldRetrieveIt() {
        //given
        Stack<String> stack = new Stack<>();

        //when
        stack.push("a");

        //then
        assertThat(stack.size()).isEqualTo(1);

        //and when
        String element = stack.pop();
        assertThat(element).isEqualTo("a");
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void whenPushToStackThenShouldRetrieveElementsInTheProperOrder() {
        //given
        Stack<String> stack = new Stack<>();

        //when
        stack.push("a");
        stack.push("b");
        stack.push("c");

        //then
        assertThat(stack.pop()).isEqualTo("c");
        assertThat(stack.pop()).isEqualTo("b");
        assertThat(stack.pop()).isEqualTo("a");
    }

    @Test
    public void whenPushAndPeekElementShouldNotRemoveIT() {
        //given
        Stack<String> stack = new Stack<>();

        //when
        stack.push("a");

        //then
        assertThat(stack.size()).isEqualTo(1);
        assertThat(stack.peek()).isEqualTo("a");
        assertThat(stack.size()).isEqualTo(1);
    }
}
