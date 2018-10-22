package ca.ubc.ece.cpen221.mp2.boggle;

import java.util.TreeSet;
import java.util.Set;

public class BogglePlayer {

    // Some empty methods provided to ensure that the
    // build succeeds. You should implement these methods
    // and the others that are required.

    public BogglePlayer(String[] dictionary) {

    }

    public Set<String> getAllValidWords(BoggleBoard board) {
        return new TreeSet<String>();
    }

//    public int scoreOf(String word){
//        if(!dictionary.contains(word)){
//            return 0;
//        }
//        int score=0;
//        switch (word.length()){
//            case 0 :
//                score+=0;
//            case 1:
//                score+=0;
//            case 2:
//                score+=0;
//            case 3:
//                score+=1;
//            case 4:
//                score+=1;
//            case 5:
//                score+=2;
//            case 6:
//                score+=3;
//            case 7:
//                score+=5;
//            default:
//                score+=11;
//        }
//        return score;
//    }
}
