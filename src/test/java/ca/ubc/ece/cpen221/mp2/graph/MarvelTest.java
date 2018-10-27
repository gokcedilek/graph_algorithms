package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MarvelTest {
    @Test
    public void test1(){
        File file = new File("./datasets/marvel.txt");
        List<List<Vertex>> booklists= new ArrayList<>();
        Graph g= new AdjacencyListGraph();
        List<Vertex> samebook= new ArrayList<>();
        String remember= "AA2 35";

        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String newLine = sc.nextLine();
                String[] parts = newLine.split(" ");
                Vertex v = new Vertex(parts[0]);
                g.addVertex(v);
                if(!remember.equals(parts[1])){
                    booklists.add(samebook);
                   samebook= new ArrayList<>();
                   samebook.add(v);
                }
                else{
                    samebook.add(v);
                }
                remember=parts[1];
            }
        } catch(FileNotFoundException exc)

        {
            System.out.println("Dictionary could not be found!");
            {
            }
        }
        for(List<Vertex> vertexList: booklists){
            for(int i=0; i<vertexList.size();  i++){
                //add 
            }
        }

    }
}

