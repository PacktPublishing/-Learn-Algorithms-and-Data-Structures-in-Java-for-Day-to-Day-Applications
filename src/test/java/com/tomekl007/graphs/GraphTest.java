package com.tomekl007.graphs;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GraphTest {

    @Test
    public void shouldSearchGraphIsDFS() {
        //given
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        //when
        List<Integer> dfs = g.DFS(2);

        //then
        assertThat(dfs).containsExactly(2, 0, 1, 3);

    }

    @Test
    public void shouldSearchGraphIsBFS() {
        //given
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        //when
        List<Integer> result = g.BFS(2);

        //then
        assertThat(result).containsExactly(2, 0, 3, 1);
    }

}