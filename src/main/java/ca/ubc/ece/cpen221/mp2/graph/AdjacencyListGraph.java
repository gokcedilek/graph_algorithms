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


public class AdjacencyListGraph implements Graph {
    ArrayList<LinkedList<Vertex>> adj_list=new ArrayList<LinkedList<Vertex>>();
    List<Vertex> vertices=new ArrayList<Vertex>();

    @Override
    public void addVertex(Vertex v) {
        LinkedList<Vertex> newList= new LinkedList<>();
        adj_list.add(newList);
        vertices.add(v);
    }

    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        int index1=vertices.indexOf(v1);
        int index2=vertices.indexOf(v2);
        if(!adj_list.get(index1).contains(v2)){
            adj_list.get(index1).add(v2);
            adj_list.get(index2).add(v1);
        }
    }

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        int index1=vertices.indexOf(v1);
        int index2=vertices.indexOf(v2);
        LinkedList<Vertex> listToIterate= adj_list.get(index1);

        for (Vertex v: listToIterate ) {
            if(v.getLabel().equals(v2.getLabel()) ){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Vertex> getNeighbors(Vertex v) {
        List<Vertex> neighbors= new ArrayList<Vertex>();
        int index=vertices.indexOf(v);
        LinkedList<Vertex> listToIterate= adj_list.get(index);
        if(listToIterate.size()==0){
            return neighbors;
        }
        for(int i=0; i<listToIterate.size();i++){
            neighbors.add(listToIterate.get(i));
        }
        Collections.sort(neighbors,Comparator.comparing(Vertex::getLabel));
        return neighbors;
    }

    @Override
    public List<Vertex> getVertices() {
        List<Vertex> list=new ArrayList<>(vertices);
        Collections.sort(list,Comparator.comparing(Vertex::getLabel));
        return list;
    }

}
