<<<<<<< HEAD
package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 * This class is the KalahBoard class.  
 * It contains two methods, one is an override of 
 * toString() method, the other is printKalahBoard 
 * method, which is to io.println the kalah board we want.
 */

public class KalahBoard {
    public void printKalahBoard(IO io, int[] p1NumberArray, int[] p2NumberArray) {
        String[][] kalahBoard = new String[5][60];
        String[] kalahBoardZeroOrLastLine = {"+----+-------+-------+-------+-------+-------+-------+----+"};
        String[] kalahBoardOneLine = {"| P2 | 6[" + toString(p2NumberArray[5]) + "] | 5[" + toString(p2NumberArray[4]) + "] | 4[" + toString(p2NumberArray[3]) + "] | 3[" + toString(p2NumberArray[2]) + "] | 2[" + toString(p2NumberArray[1]) + "] | 1[" + toString(p2NumberArray[0]) + "] | " + toString(p1NumberArray[6]) + " |"};
        String[] kalahBoardTwoLine = {"|    |-------+-------+-------+-------+-------+-------|    |"};
        String[] kalahBoardThreeLine = {"| " + toString(p2NumberArray[6]) + " | 1[" + toString(p1NumberArray[0]) + "] | 2[" + toString(p1NumberArray[1]) + "] | 3[" + toString(p1NumberArray[2]) + "] | 4[" + toString(p1NumberArray[3]) + "] | 5[" + toString(p1NumberArray[4]) + "] | 6[" + toString(p1NumberArray[5]) + "] | P1 |"};
        kalahBoard[0] = kalahBoardZeroOrLastLine;
        kalahBoard[1] = kalahBoardOneLine;
        kalahBoard[2] = kalahBoardTwoLine;
        kalahBoard[3] = kalahBoardThreeLine;
        kalahBoard[4] = kalahBoardZeroOrLastLine;
        for (int i = 0; i < kalahBoard.length; i++) {
            for (int j = 0; j < kalahBoard[i].length; j++) {
                io.print(kalahBoard[i][j] + "");
            }
            io.println("");
        }
    }

    public static String toString(int num) {
        if (num >= 0 && num < 10) {
            return " " + num;
        }
        else {
            return Integer.toString(num);
        }
    }
}


=======
package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 * This class is the KalahBoard class.  
 * It contains two methods, one is an override of 
 * toString() method, the other is printKalahBoard 
 * method, which is to io.println the kalah board we want.
 */

public class KalahBoard {
    public void printKalahBoard(IO io, int[] p1NumberArray, int[] p2NumberArray) {
        String[][] kalahBoard = new String[5][60];
        String[] kalahBoardZeroOrLastLine = {"+----+-------+-------+-------+-------+-------+-------+----+"};
        String[] kalahBoardOneLine = {"| P2 | 6[" + toString(p2NumberArray[5]) + "] | 5[" + toString(p2NumberArray[4]) + "] | 4[" + toString(p2NumberArray[3]) + "] | 3[" + toString(p2NumberArray[2]) + "] | 2[" + toString(p2NumberArray[1]) + "] | 1[" + toString(p2NumberArray[0]) + "] | " + toString(p1NumberArray[6]) + " |"};
        String[] kalahBoardTwoLine = {"|    |-------+-------+-------+-------+-------+-------|    |"};
        String[] kalahBoardThreeLine = {"| " + toString(p2NumberArray[6]) + " | 1[" + toString(p1NumberArray[0]) + "] | 2[" + toString(p1NumberArray[1]) + "] | 3[" + toString(p1NumberArray[2]) + "] | 4[" + toString(p1NumberArray[3]) + "] | 5[" + toString(p1NumberArray[4]) + "] | 6[" + toString(p1NumberArray[5]) + "] | P1 |"};
        kalahBoard[0] = kalahBoardZeroOrLastLine;
        kalahBoard[1] = kalahBoardOneLine;
        kalahBoard[2] = kalahBoardTwoLine;
        kalahBoard[3] = kalahBoardThreeLine;
        kalahBoard[4] = kalahBoardZeroOrLastLine;
        for (int i = 0; i < kalahBoard.length; i++) {
            for (int j = 0; j < kalahBoard[i].length; j++) {
                io.print(kalahBoard[i][j] + "");
            }
            io.println("");
        }
    }

    public static String toString(int num) {
        if (num >= 0 && num < 10) {
            return " " + num;
        }
        else {
            return Integer.toString(num);
        }
    }
}


>>>>>>> 866f88214f164e6ba4eb71c5f2ad37dbdbebc9ec
