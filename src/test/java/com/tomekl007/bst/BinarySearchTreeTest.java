package com.tomekl007.bst;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class BinarySearchTreeTest {

    @Test
    public void testBST() {
        //given
        BinarySearchTree b = new BinarySearchTree();

        //when
        b.insert(3);
        b.insert(8);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(9);
        b.insert(20);
        b.insert(25);
        b.insert(15);
        b.insert(16);
        //then
        List<Integer> results = b.getInOrder();
        assertThat(results).containsExactly(
                1, 2, 3, 4, 6, 8, 9, 10, 15, 16, 20, 25
        );

        assertThat(b.find(4)).isTrue();
        assertThat(b.find(100)).isFalse();
    }

    @Test
    public void testBSTDeletionSimple() {
        //given
        BinarySearchTree b = new BinarySearchTree();

        //when
        b.insert(3);
        b.insert(8);
        b.insert(1);

        //then
        b.delete(8);
        List<Integer> results = b.getInOrder();
        assertThat(results).containsExactly(
                1, 3
        );
    }

}