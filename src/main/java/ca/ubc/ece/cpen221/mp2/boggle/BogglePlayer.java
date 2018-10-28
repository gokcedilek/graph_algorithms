package ca.ubc.ece.cpen221.mp2.boggle;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;
import ca.ubc.ece.cpen221.mp2.graph.AdjacencyListGraph;

import java.util.*;

/* Abstraction Function:
 * BogglePlayer is a functionality to use the Boggle board.
 * It can be used to get all the valid words in the board,
 * calculate the score of a given word,
 * and calculate the maximum possible score of a given board.
/*Representation Invariant:
 * Boggle board is not null, and contains at least one word.
 * Dictionary is not null, and contains at least one word.
 */

public class BogglePlayer {

    HashSet<String> dictionary;
    int count=0;

    public BogglePlayer(String[] dictionary) {
        this.dictionary= new HashSet<String>(Arrays.asList(dictionary));

    }
    public BogglePlayer(Set<String> dictionary){
        this.dictionary= new HashSet<String>(dictionary);
    }

    /**
     * Gets the maximum score that can be obtained from the given board
     *
     * @param board represents a boggle board and board is not null
     * @return returns the maximum score that can be obtained from the given board
     *
     */

    public int getMaximumScore(BoggleBoard board){
        int score=0;
        Set<String> words= getAllValidWords(board);
        for (String word: words){
            score+=scoreOf(word);
        }
        return score;
    }

    /**
     * Gets all valid words that can be obtained from a given board
     *
     * @param board represents a boggle board and board is not null
     * @return returns a set of all valid words that can be obtained from the given board
     *
     */

    public Set<String> getAllValidWords(BoggleBoard board){
        List<Vertex> verticeslist = new ArrayList<>();
        Graph graph = new AdjacencyListGraph();
        Set<String> validWords= new HashSet<>();
        List<Vertex> listofNeighbors = new ArrayList<>();

        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.cols(); j++) {
                Vertex v = new Vertex(board.getLetter(i, j) + "", i+","+j);
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
                String temp= word;
                visited=new ArrayList<>();

                if (v.getLabel().equals("S")) {
                }
                if(search(graph,v,word, visited)) {
                    validWords.add(temp);

                }
            }
        }
        return validWords;
    }

    private boolean search(Graph graph, Vertex vertex, String word, List<Vertex> visited) {
        if(vertex.getLabel().length()==1){
        vertex.setLabel(vertex.getLabel().replace("Q", "QU"));}
        List<Vertex> newVisited = new ArrayList<>(visited);
        newVisited.add(vertex);
        String firstLetter = Character.toString(word.charAt(0));
        if(word.length()>2){
            {
                if (firstLetter.equals("Q")&&Character.toString(word.charAt(1)).equals("U")){
                    firstLetter = "QU";
                }
            }
        }
        String substring = word;
        if (!vertex.getLabel().equals(firstLetter)) {
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

    /**
     * Calculate the score of the input word if it exists in the dictionary.
     * @param word: a string word
     * @return 0 if word is not included in the dictionary
     *         score of the word in the dictionary
     */

    public int scoreOf (String word){
     HashSet<String> dict =dictionary;
     List<String> myList= new ArrayList<>(dict);
        if (!myList.contains(word)) {
            return 0;
        }
        int score = 0;
        switch (word.length()) {
            case 0:
                score += 0;
                break;
            case 1:
                score += 0;
                break;
            case 2:
                score += 0;
                break;
            case 3:
                score += 1;
                break;
            case 4:
                score += 1;
                break;
            case 5:
                score += 2;
                break;
            case 6:
                score += 3;
                break;
            case 7:
                score += 5;
                break;
            default:
                score += 11;
                break;
        }
        return score;
    }
}