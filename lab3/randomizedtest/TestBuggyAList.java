package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> right = new AListNoResizing<>();
        BuggyAList<Integer> bug = new BuggyAList<>();
        right.addLast(4);
        right.addLast(5);
        right.addLast(6);
        bug.addLast(4);
        bug.addLast(5);
        bug.addLast(6);
        assertEquals(right.size(), bug.size());
        for(int i = 0;i<3;i++){
            int x = right.removeLast();
            int y = bug.removeLast();
            assertEquals(x,y);
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> bug = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                bug.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int Lsize = L.size();
                int bugSize = bug.size();
                assertEquals(Lsize, bugSize);
            }
            else if(operationNumber == 2){
                // getLast
                if(L.size() == 0 || bug.size() == 0){
                    continue;
                }
                int Llast = L.getLast();
                int bugLast = bug.getLast();
                assertEquals(Llast, bugLast);
            }
            else if(operationNumber == 3){
                // removeLast
                if(L.size() == 0 || bug.size() == 0){
                    continue;
                }
                int Llast = L.removeLast();
                int bugLast = bug.removeLast();
                assertEquals(Llast, bugLast);
            }
        }
    }
}
