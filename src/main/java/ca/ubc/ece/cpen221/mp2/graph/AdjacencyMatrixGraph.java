package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;

import java.util.*;

/******************************************************************************
 *  Dependencies: Graph.java Vertex.java
 *
 *  A data type that represents a Graph using Adjacency Matrices.
 *
 ******************************************************************************/

/* Abstraction Function:
 * Adjacency Matrix Graph represents a graph as an upper triangular matrix.
 * Each row and each column correspond to a vertex of the graph.
 * Each (row,column) element of the matrix holds either 0 or 1, representing whether there is an edge between the two vertices in the corresponding row and column or not.
 * In order to prevent duplication, we only represent the matrix as an upper triangular one. */

/*Representation Invariant:
 * Each (row, column) element in the matrix can either be 0 or 1.
 * The column held at index N must have a size of N+1 to keep the upper triangular structure.
 */

public class AdjacencyMatrixGraph implements Graph {
    ArrayList<Integer[]> upperTriMatrix= new ArrayList<Integer[]>();
    List<Vertex> vertices= new ArrayList<Vertex>();

    /**
     * Adds a vertex to the graph
     *
     * @param v represents a vertex to be added to the graph
     * @return Adds a vertex to the graph if the vertex is not already in the graph and it is not null
     *
     */
    @Override
    public void addVertex(Vertex v) {
        if (!vertices.contains(v)) {
            Integer[] newVertex= new Integer[upperTriMatrix.size()+1];
            Arrays.fill(newVertex,0);
            upperTriMatrix.add(newVertex);
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
        if(vertices.contains(v1) && vertices.contains(v2)) {
            int index1= vertices.indexOf(v1);
            int index2= vertices.indexOf(v2);
            if(index1>index2){
                upperTriMatrix.get(index1)[index2]=1;
            }
            else if(index1<index2){
                upperTriMatrix.get(index2)[index1]=1;
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
        if(vertices.contains(v1) && vertices.contains(v2)) {
            int index1= vertices.indexOf(v1);
            int index2= vertices.indexOf(v2);
            if(index1>index2) {
                if (upperTriMatrix.get(index1)[index2] == 1) return true;
            }
            else if(index1<index2){
                if(upperTriMatrix.get(index2)[index1]==1) return true;
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
        if(!vertices.contains(v)){
            throw new IllegalArgumentException();
        }
        List<Vertex> connections= new ArrayList<>();
        int index= vertices.indexOf(v);
        Integer[] vColumn= upperTriMatrix.get(index);
        for(int i=0; i<vColumn.length; i++){
            if(vColumn[i]==1) connections.add(vertices.get(i));
        }
        for(int j=index+1; j<upperTriMatrix.size(); j++){
            if(upperTriMatrix.get(j)[index]==1){
                Vertex addV= vertices.get(j);
                if(!(connections.contains(addV))){
                    connections.add(addV);
                }
            }
        }
        Collections.sort(connections, Comparator.comparing(Vertex::getLabel));
        return connections;
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
        List<Vertex> copy= new ArrayList<>(vertices);
        Collections.sort(copy, Comparator.comparing(Vertex::getLabel));
        return copy ;
    }
}