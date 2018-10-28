package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class test2 {

    @Test
    public void test1() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        firstTry_M.addVertex(v3);
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v4);
        firstTry_M.addVertex(v1);
        firstTry_M.addEdge(v1, v2);
        firstTry_M.addEdge(v2, v3);
        firstTry_M.addEdge(v3, v4);
        firstTry_M.addEdge(v4, v1);
        assertTrue(firstTry_M.edgeExists(v1, v2));
        assertTrue(firstTry_M.edgeExists(v2, v3));
        assertTrue(firstTry_M.edgeExists(v3, v4));
        assertTrue(firstTry_M.edgeExists(v4, v1));
        assertFalse(firstTry_M.edgeExists(v2, v4));
        assertFalse(firstTry_M.edgeExists(v3, v1));
        ArrayList<Vertex> n1 = new ArrayList<>();
        n1.add(v2);
        n1.add(v4);
        ArrayList<Vertex> n2 = new ArrayList<>();
        n2.add(v1);
        n2.add(v3);
        ArrayList<Vertex> n3 = new ArrayList<>();
        n3.add(v2);
        n3.add(v4);
        ArrayList<Vertex> n4 = new ArrayList<>();
        n4.add(v1);
        n4.add(v3);
        assertEquals(n1, firstTry_M.getNeighbors(v1));
        assertEquals(n2, firstTry_M.getNeighbors(v2));
        assertEquals(n3, firstTry_M.getNeighbors(v3));
        assertEquals(n4, firstTry_M.getNeighbors(v4));
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        assertEquals(vertices, firstTry_M.getVertices());
    }

    @Test
    public void test2() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        Vertex v5 = new Vertex("5", "five");
        firstTry_M.addVertex(v3);
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v5);
        firstTry_M.addVertex(v4);
        firstTry_M.addVertex(v1);
        firstTry_M.addEdge(v1, v3);
        firstTry_M.addEdge(v1, v4);
        firstTry_M.addEdge(v1, v5);
        firstTry_M.addEdge(v2, v5);
        firstTry_M.addEdge(v3, v4);
        assertFalse(firstTry_M.edgeExists(v1, v2));
        assertTrue(firstTry_M.edgeExists(v2, v5));
        assertTrue(firstTry_M.edgeExists(v3, v4));
        assertTrue(firstTry_M.edgeExists(v4, v1));
        assertFalse(firstTry_M.edgeExists(v5, v4));
        ArrayList<Vertex> n1 = new ArrayList<>();
        n1.add(v3);
        n1.add(v4);
        n1.add(v5);
        ArrayList<Vertex> n2 = new ArrayList<>();
        n2.add(v5);
        ArrayList<Vertex> n3 = new ArrayList<>();
        n3.add(v1);
        n3.add(v4);
        ArrayList<Vertex> n4 = new ArrayList<>();
        n4.add(v1);
        n4.add(v3);
        ArrayList<Vertex> n5 = new ArrayList<>();
        n5.add(v1);
        n5.add(v2);
        assertEquals(n1, firstTry_M.getNeighbors(v1));
        assertEquals(n2, firstTry_M.getNeighbors(v2));
        assertEquals(n3, firstTry_M.getNeighbors(v3));
        assertEquals(n4, firstTry_M.getNeighbors(v4));
        assertEquals(n5, firstTry_M.getNeighbors(v5));
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(v2);
        vertices.add(v1);
        vertices.add(v3);
        vertices.add(v5);
        vertices.add(v4);
        Collections.sort(vertices, Comparator.comparing(Vertex::getLabel)); //add this when you add in a werid order
        assertEquals(vertices, firstTry_M.getVertices());
    }

    @Test
    public void test3() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        firstTry_M.addVertex(v1);
        firstTry_M.addEdge(v1, v1);
        assertFalse(firstTry_M.edgeExists(v1, v1));
        assertTrue(firstTry_M.getNeighbors(v1).size() == 0);
        ArrayList<Vertex> n1 = new ArrayList<>();
        assertEquals(n1, firstTry_M.getNeighbors(v1));
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(v1);
        assertEquals(vertices, firstTry_M.getVertices());
    }

    @Test
    public void test4() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v1);
        firstTry_M.addEdge(v1, v2);
        assertTrue(firstTry_M.edgeExists(v1, v2));
        assertTrue(firstTry_M.edgeExists(v2, v1));
        ArrayList<Vertex> n1 = new ArrayList<>();
        n1.add(v2);
        ArrayList<Vertex> n2 = new ArrayList<>();
        n2.add(v1);
        assertEquals(n1, firstTry_M.getNeighbors(v1));
        assertEquals(n2, firstTry_M.getNeighbors(v2));
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(v1);
        vertices.add(v2);
        Collections.sort(vertices, Comparator.comparing(Vertex::getLabel)); //add this when you add in a werid order
        assertEquals(vertices, firstTry_M.getVertices());
    }

    @Test
    public void test5() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        firstTry_M.addVertex(v3);
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v1);
        firstTry_M.addEdge(v1, v2);
        firstTry_M.addEdge(v2, v3);
        assertFalse(firstTry_M.edgeExists(v1, v3));
        assertTrue(firstTry_M.edgeExists(v2, v3));
        ArrayList<Vertex> n1 = new ArrayList<>();
        n1.add(v2);
        ArrayList<Vertex> n2 = new ArrayList<>();
        n2.add(v3);
        n2.add(v1);
        ArrayList<Vertex> n3 = new ArrayList<>();
        n3.add(v2);
        Collections.sort(n1, Comparator.comparing(Vertex::getLabel));
        Collections.sort(n2, Comparator.comparing(Vertex::getLabel));
        Collections.sort(n3, Comparator.comparing(Vertex::getLabel));
        assertEquals(n1, firstTry_M.getNeighbors(v1));
        assertEquals(n2, firstTry_M.getNeighbors(v2));
        assertEquals(n3, firstTry_M.getNeighbors(v3));
        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(v3);
        vertices.add(v1);
        vertices.add(v2);
        Collections.sort(vertices, Comparator.comparing(Vertex::getLabel));
        assertEquals(vertices, firstTry_M.getVertices());
    }

    @Test
    public void test6() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        Vertex v5 = new Vertex("5", "five");
        Vertex v6 = new Vertex("6", "six");
        Vertex v7 = new Vertex("7", "seven");
        Vertex v8 = new Vertex("8", "eight");
        Vertex v9 = new Vertex("9", "nine");
        Vertex v10 = new Vertex("10", "ten");
        firstTry_M.addVertex(v1);
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v3);
        firstTry_M.addVertex(v4);
        firstTry_M.addVertex(v5);
        firstTry_M.addVertex(v6);
        firstTry_M.addVertex(v7);
        firstTry_M.addVertex(v8);
        firstTry_M.addVertex(v9);
        firstTry_M.addVertex(v10);

        firstTry_M.addEdge(v1, v2);
        firstTry_M.addEdge(v1, v4);

        firstTry_M.addEdge(v2, v3);
        firstTry_M.addEdge(v2, v4);
        firstTry_M.addEdge(v2, v5);
        firstTry_M.addEdge(v2, v1);
        firstTry_M.addEdge(v2, v7);

        firstTry_M.addEdge(v3, v6);
        firstTry_M.addEdge(v3, v2);
        firstTry_M.addEdge(v3, v7);

        firstTry_M.addEdge(v4, v1);
        firstTry_M.addEdge(v4, v2);
        firstTry_M.addEdge(v4, v5);
        firstTry_M.addEdge(v4, v9);

        firstTry_M.addEdge(v5, v4);
        firstTry_M.addEdge(v5, v2);
        firstTry_M.addEdge(v5, v6);
        firstTry_M.addEdge(v5, v9);

        firstTry_M.addEdge(v6, v8);
        firstTry_M.addEdge(v6, v7);
        firstTry_M.addEdge(v6, v3);
        firstTry_M.addEdge(v6, v5);
        firstTry_M.addEdge(v6, v9);

        firstTry_M.addEdge(v7, v2);
        firstTry_M.addEdge(v7, v3);
        firstTry_M.addEdge(v7, v8);
        firstTry_M.addEdge(v7, v6);

        firstTry_M.addEdge(v8, v7);
        firstTry_M.addEdge(v8, v6);

        firstTry_M.addEdge(v9, v5);
        firstTry_M.addEdge(v9, v4);
        firstTry_M.addEdge(v9, v10);
        firstTry_M.addEdge(v9, v6);

        firstTry_M.addEdge(v10, v9);

        Set<List<Vertex>> breadthFirstSearch = new HashSet<>();
        List<Vertex> one = new ArrayList<>();
        one.add(v1);
        one.add(v2);
        one.add(v4);
        one.add(v3);
        one.add(v5);
        one.add(v7);
        one.add(v9);
        one.add(v6);
        one.add(v8);
        one.add(v10);
        List<Vertex> two = new ArrayList<>();
        two.add(v2);
        two.add(v1);
        two.add(v3);
        two.add(v4);
        two.add(v5);
        two.add(v7);
        two.add(v6);
        two.add(v9);
        two.add(v8);
        two.add(v10);
        List<Vertex> three = new ArrayList<>();
        three.add(v3);
        three.add(v2);
        three.add(v6);
        three.add(v7);
        three.add(v1);
        three.add(v4);
        three.add(v5);
        three.add(v8);
        three.add(v9);
        three.add(v10);
        List<Vertex> four = new ArrayList<>();
        four.add(v4);
        four.add(v1);
        four.add(v2);
        four.add(v5);
        four.add(v9);
        four.add(v3);
        four.add(v7);
        four.add(v6);
        four.add(v10);
        four.add(v8);
        List<Vertex> five = new ArrayList<>();
        five.add(v5);
        five.add(v2);
        five.add(v4);
        five.add(v6);
        five.add(v9);
        five.add(v1);
        five.add(v3);
        five.add(v7);
        five.add(v8);
        five.add(v10);
        List<Vertex> six = new ArrayList<>();
        six.add(v6);
        six.add(v3);
        six.add(v5);
        six.add(v7);
        six.add(v8);
        six.add(v9);
        six.add(v2);
        six.add(v4);
        six.add(v10);
        six.add(v1);
        List<Vertex> seven = new ArrayList<>();
        seven.add(v7);
        seven.add(v2);
        seven.add(v3);
        seven.add(v6);
        seven.add(v8);
        seven.add(v1);
        seven.add(v4);
        seven.add(v5);
        seven.add(v9);
        seven.add(v10);
        List<Vertex> eight = new ArrayList<>();
        eight.add(v8);
        eight.add(v6);
        eight.add(v7);
        eight.add(v3);
        eight.add(v5);
        eight.add(v9);
        eight.add(v2);
        eight.add(v4);
        eight.add(v10);
        eight.add(v1);
        List<Vertex> nine = new ArrayList<>();
        nine.add(v9);
        nine.add(v10);
        nine.add(v4);
        nine.add(v5);
        nine.add(v6);
        nine.add(v1);
        nine.add(v2);
        nine.add(v3);
        nine.add(v7);
        nine.add(v8);
        List<Vertex> ten = new ArrayList<>();
        ten.add(v10);
        ten.add(v9);
        ten.add(v4);
        ten.add(v5);
        ten.add(v6);
        ten.add(v1);
        ten.add(v2);
        ten.add(v3);
        ten.add(v7);
        ten.add(v8);
        breadthFirstSearch.add(one);
        breadthFirstSearch.add(two);
        breadthFirstSearch.add(three);
        breadthFirstSearch.add(four);
        breadthFirstSearch.add(five);
        breadthFirstSearch.add(six);
        breadthFirstSearch.add(seven);
        breadthFirstSearch.add(eight);
        breadthFirstSearch.add(nine);
        breadthFirstSearch.add(ten);
        assertEquals(breadthFirstSearch, Algorithms.breadthFirstSearch(firstTry_M));
    }

    @Test
    public void test7() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        Vertex v5 = new Vertex("5", "five");
        firstTry_M.addVertex(v3);
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v1);
        firstTry_M.addVertex(v4);
        firstTry_M.addVertex(v5);
        firstTry_M.addEdge(v1, v2);
        firstTry_M.addEdge(v1, v5);
        firstTry_M.addEdge(v1, v3);
        firstTry_M.addEdge(v1, v4);
        firstTry_M.addEdge(v2, v1);
        firstTry_M.addEdge(v3, v4);
        firstTry_M.addEdge(v3, v1);
        firstTry_M.addEdge(v4, v1);
        firstTry_M.addEdge(v4, v3);
        firstTry_M.addEdge(v5, v1);
        firstTry_M.addEdge(v5, v4);
        HashSet<List<Vertex>> breadthFirstSearch = new HashSet<>();
        List<Vertex> one = new ArrayList<>();
        one.add(v1);
        one.add(v2);
        one.add(v3);
        one.add(v4);
        one.add(v5);
        List<Vertex> two = new ArrayList<>();
        two.add(v2);
        two.add(v1);
        two.add(v3);
        two.add(v4);
        two.add(v5);
        List<Vertex> three = new ArrayList<>();
        three.add(v3);
        three.add(v1);
        three.add(v4);
        three.add(v2);
        three.add(v5);
        List<Vertex> four = new ArrayList<>();
        four.add(v4);
        four.add(v1);
        four.add(v3);
        four.add(v5);
        four.add(v2);
        List<Vertex> five = new ArrayList<>();
        five.add(v5);
        five.add(v1);
        five.add(v4);
        five.add(v2);
        five.add(v3);
        breadthFirstSearch.add(one);
        breadthFirstSearch.add(two);
        breadthFirstSearch.add(three);
        breadthFirstSearch.add(four);
        breadthFirstSearch.add(five);
        assertTrue(breadthFirstSearch.containsAll(Algorithms.breadthFirstSearch(firstTry_M)));
        assertTrue(Algorithms.breadthFirstSearch(firstTry_M).containsAll(breadthFirstSearch));
    }

    @Test
    public void Test10_dfs() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        List<Vertex> one = new ArrayList<>();
        List<Vertex> two = new ArrayList<>();
        List<Vertex> three = new ArrayList<>();
        List<Vertex> four = new ArrayList<>();
        List<Vertex> five = new ArrayList<>();
        Set<List<Vertex>> set = new HashSet<>();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        Vertex v5 = new Vertex("5", "five");
        firstTry_M.addVertex(v3);
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v1);
        firstTry_M.addVertex(v4);
        firstTry_M.addVertex(v5);
        firstTry_M.addEdge(v1, v3);
        firstTry_M.addEdge(v2, v5);
        firstTry_M.addEdge(v3, v4);
        firstTry_M.addEdge(v1, v4);
        firstTry_M.addEdge(v1, v5);
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
        assertEquals(set, Algorithms.depthFirstSearch(firstTry_M));
        assertEquals(Algorithms.depthFirstSearch(firstTry_M), set);
    }

    @Test
    public void test8() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        Vertex v5 = new Vertex("5", "five");
        Vertex v6 = new Vertex("6", "six");
        firstTry_M.addVertex(v3);
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v1);
        firstTry_M.addVertex(v4);
        firstTry_M.addVertex(v5);
        firstTry_M.addVertex(v6);
        firstTry_M.addEdge(v1, v2);
        firstTry_M.addEdge(v1, v4);
        firstTry_M.addEdge(v1, v5);
        firstTry_M.addEdge(v2, v1);
        firstTry_M.addEdge(v2, v6);
        firstTry_M.addEdge(v3, v5);
        firstTry_M.addEdge(v4, v1);
        firstTry_M.addEdge(v4, v6);
        firstTry_M.addEdge(v5, v1);
        firstTry_M.addEdge(v5, v3);
        firstTry_M.addEdge(v6, v2);
        firstTry_M.addEdge(v6, v4);
        List<Vertex> one = new ArrayList<>();
        List<Vertex> two = new ArrayList<>();
        List<Vertex> three = new ArrayList<>();
        List<Vertex> four = new ArrayList<>();
        List<Vertex> five = new ArrayList<>();
        List<Vertex> six = new ArrayList<>();
        Set<List<Vertex>> set = new HashSet<>();
        one.add(v1);
        one.add(v2);
        one.add(v6);
        one.add(v4);
        one.add(v5);
        one.add(v3);
        two.add(v2);
        two.add(v1);
        two.add(v4);
        two.add(v6);
        two.add(v5);
        two.add(v3);
        three.add(v3);
        three.add(v5);
        three.add(v1);
        three.add(v2);
        three.add(v6);
        three.add(v4);
        four.add(v4);
        four.add(v1);
        four.add(v2);
        four.add(v6);
        four.add(v5);
        four.add(v3);
        five.add(v5);
        five.add(v1);
        five.add(v2);
        five.add(v6);
        five.add(v4);
        five.add(v3);
        six.add(v6);
        six.add(v2);
        six.add(v1);
        six.add(v4);
        six.add(v5);
        six.add(v3);
        set.add(one);
        set.add(two);
        set.add(three);
        set.add(four);
        set.add(five);
        set.add(six);
        assertEquals(set, Algorithms.depthFirstSearch(firstTry_M));
        assertEquals(Algorithms.depthFirstSearch(firstTry_M), set);
    }


    @Test
    public void test11() {
        Graph firstTry_M = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "one");
        Vertex v2 = new Vertex("2", "two");
        Vertex v3 = new Vertex("3", "three");
        Vertex v4 = new Vertex("4", "four");
        Vertex v5 = new Vertex("5", "five");
        Vertex v6 = new Vertex("6", "six");
        firstTry_M.addVertex(v3);
        firstTry_M.addVertex(v2);
        firstTry_M.addVertex(v1);
        firstTry_M.addVertex(v4);
        firstTry_M.addVertex(v5);
        firstTry_M.addVertex(v6);
        firstTry_M.addEdge(v1, v2);
        firstTry_M.addEdge(v2, v3);
        firstTry_M.addEdge(v2, v4);
        firstTry_M.addEdge(v3, v4);
        firstTry_M.addEdge(v4, v5);
        firstTry_M.addEdge(v1, v6);

        assertEquals(v2, Algorithms.center(firstTry_M));
    }
}

