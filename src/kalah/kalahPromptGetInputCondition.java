<<<<<<< HEAD
package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 * This class is the kalahPromptGetInputCondition class, contains 
 * 2 prompt functions to return the inputChar for each player.
 */

public class kalahPromptGetInputCondition {
    public char p1Prompt(IO io) {
        String promptForP1Round = "Player P1's turn - Specify house number or 'q' to quit: ";
		String inputStringForP1 = io.readFromKeyboard(promptForP1Round);
        char inputCharForP1 = inputStringForP1.charAt(0);
        return inputCharForP1;
    }

    public char p2Prompt(IO io) {
        String promptForP2Round = "Player P2's turn - Specify house number or 'q' to quit: ";
        String inputStringForP2 = io.readFromKeyboard(promptForP2Round);
        char inputCharForP2 = inputStringForP2.charAt(0);
        return inputCharForP2;
    }


}
=======
package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 * This class is the kalahPromptGetInputCondition class, contains 
 * 2 prompt functions to return the inputChar for each player.
 */

public class kalahPromptGetInputCondition {
    public char p1Prompt(IO io) {
        String promptForP1Round = "Player P1's turn - Specify house number or 'q' to quit: ";
		String inputStringForP1 = io.readFromKeyboard(promptForP1Round);
        char inputCharForP1 = inputStringForP1.charAt(0);
        return inputCharForP1;
    }

    public char p2Prompt(IO io) {
        String promptForP2Round = "Player P2's turn - Specify house number or 'q' to quit: ";
        String inputStringForP2 = io.readFromKeyboard(promptForP2Round);
        char inputCharForP2 = inputStringForP2.charAt(0);
        return inputCharForP2;
    }


}
>>>>>>> 866f88214f164e6ba4eb71c5f2ad37dbdbebc9ec
