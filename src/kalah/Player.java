<<<<<<< HEAD
package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 * This class is the Player class.  
 * Methods return the corresponding array, includes an integer 
 * lastMoveIndex and two int[] p1NumberArray and p2NumberArray.
 */

public class Player {
    
    public returnIntWithTwoIntArr playerOneRound(IO io, int[] p1NumberArray, int[] p2NumberArray,
                                                 int inputInt) {
        Move p1Move = new Move();
        returnIntWithTwoIntArr intElementsP1Array = p1Move.moveStepP1RoundReturnFinalMoveIndex(io, p1NumberArray,
                p2NumberArray, inputInt);
        return intElementsP1Array;
    }

    public returnIntWithTwoIntArr playerTwoRound(IO io, int[] p1NumberArray, int[] p2NumberArray,
                                                 int inputInt) {
        Move p2Move = new Move();
        returnIntWithTwoIntArr intElementsP2Array = p2Move.moveStepP2RoundReturnFinalMoveIndex(io, p1NumberArray,
                p2NumberArray, inputInt);
        return intElementsP2Array;
    }
    
}
=======
package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 * This class is the Player class.  
 * Methods return the corresponding array, includes an integer 
 * lastMoveIndex and two int[] p1NumberArray and p2NumberArray.
 */

public class Player {
    
    public returnIntWithTwoIntArr playerOneRound(IO io, int[] p1NumberArray, int[] p2NumberArray,
                                                 int inputInt) {
        Move p1Move = new Move();
        returnIntWithTwoIntArr intElementsP1Array = p1Move.moveStepP1RoundReturnFinalMoveIndex(io, p1NumberArray,
                p2NumberArray, inputInt);
        return intElementsP1Array;
    }

    public returnIntWithTwoIntArr playerTwoRound(IO io, int[] p1NumberArray, int[] p2NumberArray,
                                                 int inputInt) {
        Move p2Move = new Move();
        returnIntWithTwoIntArr intElementsP2Array = p2Move.moveStepP2RoundReturnFinalMoveIndex(io, p1NumberArray,
                p2NumberArray, inputInt);
        return intElementsP2Array;
    }
    
}
>>>>>>> 866f88214f164e6ba4eb71c5f2ad37dbdbebc9ec
