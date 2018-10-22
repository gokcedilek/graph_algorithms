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

public class AdjacencyMatrixGraph implements Graph {
    // arraylist --> array for each node
    ArrayList<Integer[]> upperTriMatrix= new ArrayList<Integer[]>();
    List<Vertex> vertices= new ArrayList<Vertex>();

    @Override
    public void addVertex(Vertex v) {
        //when we are given a new label, we want to create a slot of array for that label
        Integer[] newVertex= new Integer[upperTriMatrix.size()+1];
        Arrays.fill(newVertex,0);
        upperTriMatrix.add(newVertex);
        vertices.add(v);
    }

    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        int index1= vertices.indexOf(v1);
        int index2= vertices.indexOf(v2);
        if(index1>index2){
            upperTriMatrix.get(index1)[index2]=1;
        }
        else if(index1<index2){
            upperTriMatrix.get(index2)[index1]=1;
        }

    }

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        int index1= vertices.indexOf(v1);
        int index2= vertices.indexOf(v2);
        if(index1>index2) {
            if (upperTriMatrix.get(index1)[index2] == 1) return true;
        }
        else if(index1<index2){
            if(upperTriMatrix.get(index2)[index1]==1) return true;
        }
        return false;
    }

    @Override
    public List<Vertex> getNeighbors(Vertex v) {
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

    @Override
    public List<Vertex> getVertices() {
        List<Vertex> copy= new ArrayList<>(vertices);
        Collections.sort(copy, Comparator.comparing(Vertex::getLabel));
        return copy ;
    }

}
