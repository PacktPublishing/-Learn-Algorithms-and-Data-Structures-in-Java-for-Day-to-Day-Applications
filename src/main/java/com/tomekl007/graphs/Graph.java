package com.tomekl007.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// This class represents a directed graph using adjacency list
// representation
// Java program to print DFS traversal from a given given graph
public class Graph {


    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);  // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[], List<Integer> results) {
        // Mark the current node as visited and print it
        visited[v] = true;
        results.add(v);

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited, results);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    List<Integer> DFS(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        List<Integer> results = new LinkedList<>();

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited, results);
        return results;
    }

    List<Integer> BFS(int s) {
        List<Integer> result = new LinkedList<>();
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            result.add(s);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return result;
    }
}
