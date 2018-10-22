package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;

import java.util.*;

public class Algorithms {

	/**
	 * *********************** Algorithms ****************************
	 *
	 * Please see the README for this machine problem for a more detailed
	 * specification of the behavior of each method that one should
	 * implement.
	 */

	/**
	 * This is provided as an example to indicate that this method and
	 * other methods should be implemented here.
	 *
	 * You should write the specs for this and all other methods.
	 *
	 * @param graph
	 * @param a
	 * @param b
	 * @return
	 */
	public static int shortestDistance(Graph graph, Vertex a, Vertex b) {
		if(a.getLabel().equals(b.getLabel())) return 0;
		int count=1;
		Queue<Vertex> linkedQueue= new LinkedList<>();
		Vertex startVertex=a;
		List<Vertex> checked= new ArrayList<>();
		if(graph.edgeExists(startVertex,b)) return count;
		linkedQueue.add(startVertex);
		checked.add(startVertex);
		while (linkedQueue.size() > 0) {
			for (Vertex v : graph.getNeighbors(startVertex)) {
				if(!checked.contains(v)){
					if(graph.edgeExists(v,b)){
						return ++count;
					}
					linkedQueue.add(v);
				}
			}
			linkedQueue.poll();
			count++;
			startVertex = linkedQueue.peek();
			if(count==graph.getVertices().size()-2) {
				break;
			}
		}
		if(count==graph.getVertices().size()-2){ return -1;}
		else{ return count;}

	}

	/**
	 * Perform a complete depth first search of the given
	 * graph. Start with the search at each vertex of the
	 * graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list
	 * of elements seen by starting a DFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 *
	 * @param
	 * @return
	 */
	public static Set<List<Vertex>> depthFirstSearch(Graph graph) {
		Set<List<Vertex>> verticesOfVertices = new HashSet<>();
		for (int i = 0; i < graph.getVertices().size(); i++) {
			Vertex startVertex = graph.getVertices().get(i);
			Stack<Vertex> linkedStack = new Stack<>();
			List<Vertex> vNeighbours = new LinkedList<>();
			List<Vertex> visited = new LinkedList<>();
			if (!visited.contains(startVertex)) {
				linkedStack.add(startVertex);
				vNeighbours.add(startVertex);
				visited.add(startVertex);
			}
			Iterator<Vertex> neighborsofV = graph.getNeighbors(startVertex).listIterator();
			while (!linkedStack.empty()) {
				while (neighborsofV.hasNext()) {
					startVertex = neighborsofV.next();
					if (!visited.contains(startVertex)) {
						linkedStack.add(startVertex);
						vNeighbours.add(startVertex);
						visited.add(startVertex);
						neighborsofV=graph.getNeighbors(startVertex).listIterator();
					}
				}
				linkedStack.pop();
				if(linkedStack.empty()){
					break;
				}
				startVertex = linkedStack.peek();
				neighborsofV=graph.getNeighbors(startVertex).listIterator();
			}
			verticesOfVertices.add(vNeighbours); //add to a list for the current startIndex
			vNeighbours = new LinkedList<>();
			visited= new LinkedList<>();
		}
		return verticesOfVertices;
	}

	/**
	 * Perform a complete breadth first search of the given
	 * graph. Start with the search at each vertex of the
	 * graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list
	 * of elements seen by starting a BFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 *
	 * @param
	 * @return
	 */
	public static Set<List<Vertex>> breadthFirstSearch(Graph graph) {
		Set<List<Vertex>> verticesOfVertices = new HashSet<>();
		for (int i = 0; i < graph.getVertices().size(); i++) {
			Vertex startVertex = graph.getVertices().get(i);
			Queue<Vertex> linkedQueue = new LinkedList<>();
			List<Vertex> vNeighbours= new LinkedList<>();
			if(!vNeighbours.contains(startVertex)){
				linkedQueue.add(startVertex);
				vNeighbours.add(startVertex);
			}
			while (linkedQueue.size() > 0) {
				for (Vertex neighbour : graph.getNeighbors(startVertex)) {
					if(!vNeighbours.contains(neighbour)){
						linkedQueue.add(neighbour);
						vNeighbours.add(neighbour);
					}
				}
				linkedQueue.poll();
				startVertex = linkedQueue.peek();
			}
			verticesOfVertices.add(vNeighbours); //add to a list for the current startIndex
			vNeighbours=new LinkedList<>();
		}
		return verticesOfVertices;

	}
	/**
	 * You should write the spec for this method
	 */
	public static Vertex center(Graph graph) {
		List<Vertex> vertices = new ArrayList<>();
		Map<Vertex,Integer> eccentricity=new HashMap<Vertex, Integer>();
		Set<List<Vertex>> dfs=new HashSet<>();
		dfs=depthFirstSearch(graph);
		List<List<Vertex>> maxVertices=new ArrayList<>();
		int maximum=0;

		for (List<Vertex> list:dfs){
			if(list.size()>maximum){
				maximum=list.size();
			}
		}
		for(List<Vertex> list2:dfs){
			if(list2.size()==maximum){
				maxVertices.add(list2);
			}
		}

		vertices=maxVertices.get(0);
		for (int i = 0; i < vertices.size(); i++) {
			int max=0;
			int distance=0;
			Iterator<Vertex> iterator = vertices.listIterator();
			while (iterator.hasNext()) {
				Vertex v = iterator.next();
				distance = shortestDistance(graph, vertices.get(i), v);
				if (distance > max) {
					max = distance;
				}
			}
			eccentricity.put(vertices.get(i),max);
		}
		Map<Vertex,Integer> copy= new HashMap<>(eccentricity);

		int min= (int) copy.values().toArray()[0];
		List<Vertex> minlist=new ArrayList<>();
		for(Vertex v:eccentricity.keySet()){
			if(eccentricity.get(v)<min){
				min=eccentricity.get(v);
			}
		}
		for(Vertex V:eccentricity.keySet()){
			if(eccentricity.get(V)==min){
				minlist.add(V);
			}
		}
		Collections.sort(minlist,Comparator.comparing(Vertex::getLabel));
		return minlist.get(0);
	}
	 /**
	  * You should write the spec for this method
		*/
		public static int diameter(Graph graph) {
			List<Vertex> vertices=new ArrayList<>();
			vertices=graph.getVertices();
			int max=0;
			int distance=0;
			int flag=0;
			for (int i=0;i<vertices.size();i++){

				Iterator<Vertex> iterator = vertices.listIterator();
				while(iterator.hasNext()){
					Vertex v=iterator.next();
					if(graph.edgeExists(vertices.get(i),v)){
						flag=1;
					}
					distance=shortestDistance(graph,vertices.get(i),v);
					if(distance>max){
						max=distance;
					}
				}
			}
			if(flag==0){
				return -1;
			}

			return max;
		}

}

