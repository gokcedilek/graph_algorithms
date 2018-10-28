package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;

import java.util.*;

/******************************************************************************
 *  Dependencies: Graph.java Vertex.java
 *
 *  A data type that represents a Graph using Adjacency Lists.
 *
 ******************************************************************************/
/* Abstraction Function:
 * Adjacency List Graph represents a graph as a list for each vertex.
 * Each list holds a list of vertices that represent the vertices that the given vertex has an edge to.
 */

/*Representation Invariant:
 * The number of elements in the adjacency list must be equal to the number of vertices in the graph.
 * When a new edge is added between vertices A and B, vertex A should be added to vertex B's list of neighbours, and vertex B should be added to vertex A's list of neighbours.
 */

public class AdjacencyListGraph implements Graph {
    ArrayList<LinkedList<Vertex>> adj_list=new ArrayList<LinkedList<Vertex>>();
    List<Vertex> vertices=new ArrayList<Vertex>();


    /**
     * Adds a vertex to the graph
     *
     * @param v represents a vertex to be added to the graph
     * @return Adds a vertex to the graph if the vertex is not already in the graph and it is not null
     *
     */
    @Override
    public void addVertex(Vertex v) {
        LinkedList<Vertex> newList= new LinkedList<>();

        if(!vertices.contains(v) && v!=null) {
            adj_list.add(newList);
            vertices.add(v);
        }
    }


    /**
     * Adds an edge between two vertices
     *
     * @param v1 and v2 represent two vertices
     * @return Adds an edge between v1 and v2 if they are vertices in the graph
     *
     */

    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        if (vertices.contains(v1) && vertices.contains(v2)) {
            int index1 = vertices.indexOf(v1);
            int index2 = vertices.indexOf(v2);
            if (!adj_list.get(index1).contains(v2)) {
                adj_list.get(index1).add(v2);
                adj_list.get(index2).add(v1);
            }
        }
    }

    /**
     * Checks if there is an edge between two vertices
     *
     * @param v1 and v2 represent two vertices
     * @return return true if v1 and v2 are two vertices in the graph and an edge from v1 connects to v2
     *
     */

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        if (vertices.contains(v1) && vertices.contains(v2)) {
            int index1 = vertices.indexOf(v1);
            int index2 = vertices.indexOf(v2);
            LinkedList<Vertex> listToIterate = adj_list.get(index1);

            for (Vertex v : listToIterate) {
                if (v.equals(v2)) {
                    return true;
                }
            }
        }
            return false;
    }

    /**
     * Get an array containing all vertices adjacent to v.
     *
     * @param v represents a vertex in the graph
     * @return returns a list containing each vertex w such that there is
     * an edge from v to w. The size of the list must be as small as possible
     * (No trailing null elements). This method should return a list of size 0
     * iff v has no downstream neighbors.
     * @return throws an IllegalArgumentException if the vertex is not in the graph
     *
     */

    @Override
    public List<Vertex> getNeighbors(Vertex v) {
        List<Vertex> neighbors= new ArrayList<Vertex>();
        if(vertices.contains(v)) {
            int index = vertices.indexOf(v);
            LinkedList<Vertex> listToIterate = adj_list.get(index);
            if (listToIterate.size() == 0) {
                return neighbors;
            }
            for (int i = 0; i < listToIterate.size(); i++) {
                neighbors.add(listToIterate.get(i));
            }
            Collections.sort(neighbors, Comparator.comparing(Vertex::getLabel));
            return neighbors;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Get all vertices in the graph.
     *
     * @return  returns a list containing all vertices in the graph,
     * sorted by label in non-descending order.
     * This method should return a list of size 0 iff the graph has no vertices.
     *
     */

    @Override
    public List<Vertex> getVertices() {
        List<Vertex> list=new ArrayList<>(vertices);
        Collections.sort(list,Comparator.comparing(Vertex::getLabel));
        return list;
    }

}
