package ca.ubc.ece.cpen221.mp2.boggle;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;
import ca.ubc.ece.cpen221.mp2.graph.AdjacencyListGraph;

import java.util.*;

public class BogglePlayer {

    HashSet<String> dictionary;
    int count=0;

    public BogglePlayer(String[] dictionary) {
        this.dictionary= new HashSet<String>(Arrays.asList(dictionary));
        //System.out.print(dictionary);
    }
    public BogglePlayer(Set<String> dictionary){
        this.dictionary= new HashSet<String>(dictionary);
        // System.out.println(dictionary);
    }

    public int getMaximumScore(BoggleBoard board){
        int score=0;
        for (String word: getAllValidWords(board)){
            score+=scoreOf(word);
        }
        return score;
    }

    public Set<String> getAllValidWords(BoggleBoard board){
        List<Vertex> verticeslist = new ArrayList<>();
        Graph graph = new AdjacencyListGraph();
        Set<String> validWords= new HashSet<>();
        List<Vertex> listofNeighbors = new ArrayList<>();

        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.cols(); j++) {
                Vertex v = new Vertex(board.getLetter(i, j) + "", Integer.toString(i*10+j));
                verticeslist.add(v);
                graph.addVertex(v);
            }
        }
        int numcol = board.rows();
        int numrow = board.cols();
        for (int i = 0; i < numrow; i++) {
            for (int j = 0; j < numcol; j++) {
                Vertex cur = verticeslist.get(numcol * i + j);
                listofNeighbors = neighbor(i, j, verticeslist, numcol, numrow);
                for (int a = 0; a < listofNeighbors.size(); a++) {
                    graph.addEdge(cur, listofNeighbors.get(a));
                }
            }
        }
        List<Vertex> visited= new ArrayList<>();
        for(String word: dictionary){

            if (word.length()<3){
                continue;
            }
            
            for(Vertex v: verticeslist){
                if(v.getLabel().length()==1){
                    v.setLabel(v.getLabel().replace("Q", "QU"));}
                System.out.println(v);
                String temp= word;
                visited=new ArrayList<>();

                if (v.getLabel().equals("S")) {
                    System.out.println("");
                }
                if(search(graph,v,word, visited)) {
                    validWords.add(temp);

                }
            }


        }
        System.out.println(validWords);

        return validWords;
    }

    public boolean search(Graph graph, Vertex vertex, String word, List<Vertex> visited) {
        if(vertex.getLabel().length()==1){
        vertex.setLabel(vertex.getLabel().replace("Q", "QU"));}
        List<Vertex> newVisited = new ArrayList<>(visited);
        newVisited.add(vertex);

        String substring = word;
        if (!vertex.getLabel().equals(Character.toString(word.charAt(0)))) {
//            visited.remove(visited.size()-1);
            return false;
        }

        if(word.length() <= 1){
            return true;
        }


        if (vertex.getLabel().contains("QU")) {
            substring = word.substring(1);

            if(substring.startsWith("U")) {
                substring = substring.substring(1);

            }
        }
        else{
           substring = word.substring(1);
        }
        boolean retVal = false;
        for(Vertex v:graph.getNeighbors(vertex)){

            if (!newVisited.contains(v)) {

                retVal |= search(graph, v, substring, newVisited);

            }

        }

//
        return retVal;
    }



    private List<Vertex> neighbor(int i, int j, List<Vertex> vertices,int numcol, int numrow){
        List<Vertex> returnlist = new ArrayList<Vertex>();

        for (int k = -1; k <= 1; k++) {
            for (int t = -1; t <= 1; t++) {
                if (!(k == 0 && t == 0)) {

                    int currenti = i + k;
                    int currentj = j + t;

                    if (currenti < 0 && currentj < 0) {
                        currenti = currenti + numrow;
                        currentj = currentj + numcol;
                    } else if (currenti == numrow && currentj == numcol) {
                        currenti = currenti - numrow;
                        currentj = currentj - numcol;
                    } else if (currenti == numrow && currentj < 0) {
                        currenti = currenti - numrow;
                        currentj = currentj + numcol;
                    } else if (currentj == numcol && currenti < 0) {
                        currenti = currenti + numrow;
                        currentj = currentj - numcol;
                    } else if (currenti < 0) {
                        currenti = currenti + numrow;
                    } else if (currenti == numrow) {
                        currenti = currenti - numrow;
                    } else if (currentj < 0) {
                        currentj = currentj + numcol;
                    } else if (currentj == numcol) {
                        currentj = currentj - numcol;
                    }

                    returnlist.add(vertices.get(currenti * numcol + currentj));
                }
            }
        }

        return returnlist;
    }

    public int scoreOf (String word){
        if (!Arrays.asList(dictionary).contains(word)) {
            return 0;
        }
        int score = 0;
        switch (word.length()) {
            case 0:
                score += 0;
            case 1:
                score += 0;
            case 2:
                score += 0;
            case 3:
                score += 1;
            case 4:
                score += 1;
            case 5:
                score += 2;
            case 6:
                score += 3;
            case 7:
                score += 5;
            default:
                score += 11;
        }
        return score;
    }
}