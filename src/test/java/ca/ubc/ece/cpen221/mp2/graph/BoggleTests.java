package ca.ubc.ece.cpen221.mp2.graph;

        import ca.ubc.ece.cpen221.mp2.boggle.BoggleBoard;
import ca.ubc.ece.cpen221.mp2.boggle.BogglePlayer;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoggleTests {

    @Test
    public void test1(){

        File file = new File("./datasets/qu.txt");
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
            for(String s: results){
                System.out.println(s);
            }
//            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaa");
            for (String s: results) {
                if (!dict2.contains(s)) {
                    System.out.println(s);
                }
            }

            System.out.println(results.size());
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
            for(String s: results){
                System.out.println(s);
            }
            System.out.println(results.size());
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
            System.out.println(scores);
        } catch(FileNotFoundException exc){
            System.out.println("Dictionary could not be found!");
        }
    }
}
