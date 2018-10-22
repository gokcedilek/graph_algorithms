package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphTests {

    // possible location for tests
    @Test
    public void Test1_edgeExists() {
        Graph firstTry_L = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        firstTry_L.addVertex(v1);
        firstTry_L.addVertex(v2);
        firstTry_L.addVertex(v3);
        firstTry_L.addVertex(v4);
        firstTry_L.addEdge(v1, v2);
        firstTry_L.addEdge(v2, v3);
        firstTry_L.addEdge(v3, v4);
        firstTry_L.addEdge(v4, v1);
        assertTrue(firstTry_L.edgeExists(v1, v2));
        assertTrue(!firstTry_L.edgeExists(v1, v3));
        assertTrue(!firstTry_L.edgeExists(v2, v4));
        assertTrue(firstTry_L.edgeExists(v3, v4));
    }


    @Test
    public void Test2_getNeighbors() {
        Graph firstTry_L = new AdjacencyListGraph();
        List<Vertex> test1 = new ArrayList<>();
        List<Vertex> test2 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        test1.add(v1);
        test2.add(v2);
        test1.add(v3);
        test2.add(v4);
        firstTry_L.addVertex(v1);
        firstTry_L.addVertex(v2);
        firstTry_L.addVertex(v3);
        firstTry_L.addVertex(v4);
        firstTry_L.addEdge(v1, v2);
        firstTry_L.addEdge(v2, v3);
        firstTry_L.addEdge(v3, v4);
        firstTry_L.addEdge(v4, v1);
        assertEquals(test1, firstTry_L.getNeighbors(v2));
        assertEquals(test2, firstTry_L.getNeighbors(v3));
    }


    @Test
    public void Test3_getVertices() {
        Graph firstTry_L = new AdjacencyListGraph();
        List<Vertex> test1 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        firstTry_L.addVertex(v3);
        firstTry_L.addVertex(v2);
        firstTry_L.addVertex(v1);
        firstTry_L.addVertex(v4);
        firstTry_L.addEdge(v1, v2);
        firstTry_L.addEdge(v2, v3);
        firstTry_L.addEdge(v3, v4);
        firstTry_L.addEdge(v4, v1);
        test1.add(v1);
        test1.add(v2);
        test1.add(v3);
        test1.add(v4);
        assertEquals(test1, firstTry_L.getVertices());
    }

    @Test
    public void Test4_edgeExists() {
        Graph firstTry_L = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        Vertex v5 = new Vertex("5", "five");
        firstTry_L.addVertex(v1);
        firstTry_L.addVertex(v2);
        firstTry_L.addVertex(v3);
        firstTry_L.addVertex(v4);
        firstTry_L.addVertex(v5);
        firstTry_L.addEdge(v1, v3);
        firstTry_L.addEdge(v2, v5);
        firstTry_L.addEdge(v3, v4);
        firstTry_L.addEdge(v1, v4);
        firstTry_L.addEdge(v1, v5);
        assertTrue(!firstTry_L.edgeExists(v1, v2));
        assertTrue(firstTry_L.edgeExists(v1, v3));
        assertTrue(!firstTry_L.edgeExists(v2, v4));
        assertTrue(firstTry_L.edgeExists(v3, v4));
    }


    @Test
    public void Test5_getNeighbors() {
        Graph firstTry_L = new AdjacencyListGraph();
        List<Vertex> test1 = new ArrayList<>();
        List<Vertex> test2 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        Vertex v5 = new Vertex("5", "five");
        test1.add(v3);
        test1.add(v4);
        test1.add(v5);
        test2.add(v5);
        firstTry_L.addVertex(v1);
        firstTry_L.addVertex(v2);
        firstTry_L.addVertex(v3);
        firstTry_L.addVertex(v4);
        firstTry_L.addVertex(v5);
        firstTry_L.addEdge(v1, v3);
        firstTry_L.addEdge(v2, v5);
        firstTry_L.addEdge(v3, v4);
        firstTry_L.addEdge(v1, v4);
        firstTry_L.addEdge(v1, v5);
        assertEquals(test1, firstTry_L.getNeighbors(v1));
        assertEquals(test2, firstTry_L.getNeighbors(v2));
    }


    @Test
    public void Test6_getVertices() {
        Graph firstTry_L = new AdjacencyListGraph();
        List<Vertex> test1 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        Vertex v5 = new Vertex("5", "five");
        firstTry_L.addVertex(v3);
        firstTry_L.addVertex(v2);
        firstTry_L.addVertex(v1);
        firstTry_L.addVertex(v4);
        firstTry_L.addVertex(v5);
        firstTry_L.addEdge(v1, v3);
        firstTry_L.addEdge(v2, v5);
        firstTry_L.addEdge(v3, v4);
        firstTry_L.addEdge(v1, v4);
        firstTry_L.addEdge(v1, v5);
        test1.add(v1);
        test1.add(v2);
        test1.add(v3);
        test1.add(v4);
        test1.add(v5);
        assertEquals(test1, firstTry_L.getVertices());
    }

    @Test
    public void Test7_edgeCase1() {
        Graph firstTry_L = new AdjacencyListGraph();
        List<Vertex> test1 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "one");
        firstTry_L.addVertex(v1);
        List<Vertex> test2 = new ArrayList<>();
        assertEquals(test2, firstTry_L.getNeighbors(v1));
        test1.add(v1);
        assertEquals(test1, firstTry_L.getVertices());
        assertTrue(!firstTry_L.edgeExists(v1, v1));
    }

    @Test
    public void Test8_edgeCase2() {
        Graph firstTry_L = new AdjacencyListGraph();
        List<Vertex> test1 = new ArrayList<>();
        List<Vertex> test2 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        firstTry_L.addVertex(v2);
        firstTry_L.addVertex(v1);
        firstTry_L.addEdge(v1, v2);
        test1.add(v1);
        test1.add(v2);
        test2.add(v2);
        assertTrue(firstTry_L.edgeExists(v1, v2));
        assertEquals(test1, firstTry_L.getVertices());
        assertEquals(test2, firstTry_L.getNeighbors(v1));
    }

    @Test
    public void Test9_edgeCase3() {
        Graph firstTry_L = new AdjacencyListGraph();
        List<Vertex> test1 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        firstTry_L.addVertex(v1);
        firstTry_L.addVertex(v2);
        firstTry_L.addVertex(v3);
        firstTry_L.addEdge(v1, v2);
        firstTry_L.addEdge(v2, v3);
        test1.add(v1);
        test1.add(v2);
        test1.add(v3);
        List<Vertex> test2 = new ArrayList<>();
        test2.add(v1);
        test2.add(v3);
        List<Vertex> test3 = new ArrayList<>();
        test3.add(v2);
        assertTrue(firstTry_L.edgeExists(v1, v2));
        assertTrue(!firstTry_L.edgeExists(v1, v3));
        assertEquals(test1, firstTry_L.getVertices());
        assertEquals(test2, firstTry_L.getNeighbors(v2));
        assertEquals(test3, firstTry_L.getNeighbors(v1));
    }

    @Test
    public void Test10_dfs(){
        Graph firstTry_L = new AdjacencyListGraph();
        List<Vertex> one = new ArrayList<>();
        List<Vertex> two = new ArrayList<>();
        List<Vertex> three = new ArrayList<>();
        List<Vertex> four = new ArrayList<>();
        List<Vertex> five = new ArrayList<>();
        Set<List<Vertex>> set=new HashSet<>();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        Vertex v5 = new Vertex("5", "five");
        firstTry_L.addVertex(v3);
        firstTry_L.addVertex(v2);
        firstTry_L.addVertex(v1);
        firstTry_L.addVertex(v4);
        firstTry_L.addVertex(v5);
        firstTry_L.addEdge(v1, v3);
        firstTry_L.addEdge(v2, v5);
        firstTry_L.addEdge(v3, v4);
        firstTry_L.addEdge(v1, v4);
        firstTry_L.addEdge(v1, v5);
        one.add(v1);
        one.add(v3);
        one.add(v4);
        one.add(v5);
        one.add(v2);
        two.add(v2);
        two.add(v5);
        two.add(v1);
        two.add(v3);
        two.add(v4);
        three.add(v3);
        three.add(v1);
        three.add(v4);
        three.add(v5);
        three.add(v2);
        four.add(v4);
        four.add(v1);
        four.add(v3);
        four.add(v5);
        four.add(v2);
        five.add(v5);
        five.add(v1);
        five.add(v3);
        five.add(v4);
        five.add(v2);
        set.add(one);
        set.add(two);
        set.add(three);
        set.add(four);
        set.add(five);
        assertEquals(set,Algorithms.depthFirstSearch(firstTry_L));
    }
    @Test
    public void Test11_dfs(){
        Graph firstTry_L = new AdjacencyListGraph();
        List<Vertex> A = new ArrayList<>();
        List<Vertex> B = new ArrayList<>();
        List<Vertex> C = new ArrayList<>();
        List<Vertex> D = new ArrayList<>();
        List<Vertex> E = new ArrayList<>();
        List<Vertex> F = new ArrayList<>();
        Set<List<Vertex>> set=new HashSet<>();
        Vertex vA = new Vertex("A", "a");
        Vertex vB = new Vertex("B", "b");
        Vertex vC = new Vertex("C", "c");
        Vertex vD = new Vertex("D", "d");
        Vertex vE = new Vertex("E", "e");
        Vertex vF = new Vertex("F", "f");
        firstTry_L.addVertex(vA);
        firstTry_L.addVertex(vB);
        firstTry_L.addVertex(vC);
        firstTry_L.addVertex(vD);
        firstTry_L.addVertex(vE);
        firstTry_L.addVertex(vF);
        firstTry_L.addEdge(vA, vB);
        firstTry_L.addEdge(vA, vC);
        firstTry_L.addEdge(vB, vD);
        firstTry_L.addEdge(vB, vE);
        firstTry_L.addEdge(vC, vE);
        firstTry_L.addEdge(vD, vE);
        firstTry_L.addEdge(vD, vF);
        firstTry_L.addEdge(vE,vF);
        A.add(vA);
        A.add(vB);
        A.add(vD);
        A.add(vE);
        A.add(vC);
        A.add(vF);
        B.add(vB);
        B.add(vA);
        B.add(vC);
        B.add(vE);
        B.add(vD);
        B.add(vF);
        C.add(vC);
        C.add(vA);
        C.add(vB);
        C.add(vD);
        C.add(vE);
        C.add(vF);
        D.add(vD);
        D.add(vB);
        D.add(vA);
        D.add(vC);
        D.add(vE);
        D.add(vF);
        E.add(vE);
        E.add(vB);
        E.add(vA);
        E.add(vC);
        E.add(vD);
        E.add(vF);
        F.add(vF);
        F.add(vD);
        F.add(vB);
        F.add(vA);
        F.add(vC);
        F.add(vE);
        set.add(A);
        set.add(B);
        set.add(C);
        set.add(D);
        set.add(E);
        set.add(F);
        assertEquals(set,Algorithms.depthFirstSearch(firstTry_L));
    }
}





//assertEquals(test1,firstTry_L.getNeighbors(v2));
//        List<Vertex> test3=firstTry_L.getNeighbors(v4);
//        test3.sort(new Comparator<Vertex>() {
//                       @Override
//                       public int compare(Vertex o1, Vertex o2) {
//                           String one = o1.toString();
//                           String two = o2.toString();
//                           return one.compareTo(two);
//                       }
//                   }
//                assertEquals(test1);