package ca.ubc.ece.cpen221.mp2.graph;
import ca.ubc.ece.cpen221.mp2.boggle.BoggleBoard;
import ca.ubc.ece.cpen221.mp2.boggle.BogglePlayer;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class BoggleTests {

    @Test
    public void test1(){

        File file = new File("./datasets/dictionary-common.txt");
        String file2= new String("./datasets/board4x4.txt");

        BoggleBoard board1= new BoggleBoard(file2);
        try{
            Scanner sc= new Scanner(file);
            Set<String> dict2= new HashSet<>();
            while(sc.hasNextLine()){
                String newLine = sc.nextLine();
                dict2.add(newLine);
            }
            BogglePlayer player1= new BogglePlayer(dict2) ;
            Set<String> results= player1.getAllValidWords(board1);
            assertEquals(155, results.size());
        } catch(FileNotFoundException exc){
            System.out.println("Dictionary could not be found!");
        }

    }
    @Test
    public void test2(){

        File file = new File("./datasets/dictionary-common.txt");
        String file2= new String("./datasets/25x25");

        BoggleBoard board1= new BoggleBoard(file2);
        try{
            Scanner sc= new Scanner(file);
            Set<String> dict2= new HashSet<>();
            while(sc.hasNextLine()){
                String newLine = sc.nextLine();
                dict2.add(newLine);
            }
            BogglePlayer player1= new BogglePlayer(dict2) ;
            Set<String> results= player1.getAllValidWords(board1);

            assertEquals(1282,results.size());
        } catch(FileNotFoundException exc){
            System.out.println("Dictionary could not be found!");
        }

    }
    @Test
    public void testscore(){
        File file = new File("./datasets/dictionary-common.txt");
        String file2= new String("./datasets/25x25");
        BoggleBoard board1= new BoggleBoard(file2);
        try{
            Scanner sc= new Scanner(file);
            Set<String> dict2= new HashSet<>();
            while(sc.hasNextLine()){
                String newLine = sc.nextLine();
                dict2.add(newLine);
            }
            BogglePlayer player1= new BogglePlayer(dict2) ;
            int scores= player1.getMaximumScore(board1);
            assertEquals(1768,scores);
        } catch(FileNotFoundException exc){
            System.out.println("Dictionary could not be found!");
        }
    }
}
