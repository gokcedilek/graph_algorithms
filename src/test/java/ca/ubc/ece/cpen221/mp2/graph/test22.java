package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test22 {
    @Test
    public void test12() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        Vertex v5= new Vertex("5", "five");
        Vertex v6= new Vertex("6", "six");
        firstTry_M.addVertex(v3);
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v1);
        firstTry_M.addVertex(v4);
        firstTry_M.addVertex(v5);
        firstTry_M.addVertex(v6);
        firstTry_M.addEdge(v1, v3);
        firstTry_M.addEdge(v3, v4);
        firstTry_M.addEdge(v4, v5);
        firstTry_M.addEdge(v4, v6);
        firstTry_M.addEdge(v2, v6);
        firstTry_M.addEdge(v2, v5);
        assertEquals(3, Algorithms.shortestDistance(firstTry_M, v1, v6));
        assertEquals(2, Algorithms.shortestDistance(firstTry_M, v1, v4));
        assertEquals(3, Algorithms.shortestDistance(firstTry_M, v2, v3));
        assertEquals(4, Algorithms.shortestDistance(firstTry_M, v1, v2));
        assertEquals(4, Algorithms.diameter(firstTry_M));
        assertEquals(v4, Algorithms.center(firstTry_M));
    }

    @Test
    public void test13() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        Vertex v5 = new Vertex("5", "five");
        Vertex v6 = new Vertex("6", "six");
        Vertex v7 = new Vertex("7", "seven");
        firstTry_M.addVertex(v3);
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v1);
        firstTry_M.addVertex(v4);
        firstTry_M.addVertex(v5);
        firstTry_M.addVertex(v6);
        firstTry_M.addVertex(v7);
        firstTry_M.addEdge(v1, v2);
        firstTry_M.addEdge(v1, v3);
        firstTry_M.addEdge(v2, v3);
        firstTry_M.addEdge(v4, v5);
        firstTry_M.addEdge(v5, v6);
        firstTry_M.addEdge(v7, v5);
        firstTry_M.addEdge(v7, v6);
        //assertEquals(2, Algorithms.diameter(firstTry_M));
        assertEquals(v5, Algorithms.center(firstTry_M));
    }

    @Test
    public void test14() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        firstTry_M.addVertex(v3);
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v1);
        firstTry_M.addVertex(v4);
        assertEquals(-1, Algorithms.diameter(firstTry_M));
    }
    @Test
    public void test15(){
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        firstTry_M.addVertex(v3);
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v1);
        firstTry_M.addVertex(v4);
        firstTry_M.addEdge(v1, v2);
        firstTry_M.addEdge(v1, v3);
        firstTry_M.addEdge(v2, v3);
        firstTry_M.addEdge(v4, v3);
        assertEquals(v3, Algorithms.center(firstTry_M));
    }
}

