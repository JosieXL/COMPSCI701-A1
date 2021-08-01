<<<<<<< HEAD
package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 * This class is the KalahCases class, contains 2 gameFinish functions 
 * and 2 seedIsZero functions for player1 round and player2. 
 */

public class KalahCases {
    public int[] gameFinishP1Round(IO io, KalahBoard kalahBoard, int[] p1NumberArray, int[] p2NumberArray) {
		int[] storeTotalNumberArr = new int[2];
		int p1StoreTotalNumber = 0;
		int p2StoreTotalNumber = 0;
		if (p1NumberArray[0]==0 && p1NumberArray[1]==0 && p1NumberArray[2]==0 && p1NumberArray[3]==0 && p1NumberArray[4]==0 && p1NumberArray[5]==0) {
			io.println("Game over");
			kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
			p1StoreTotalNumber = p1NumberArray[6];
			p2StoreTotalNumber = p2NumberArray[6] + p2NumberArray[0] + p2NumberArray[1] + p2NumberArray[2] + p2NumberArray[3] + p2NumberArray[4] + p2NumberArray[5];
			io.println("	player 1:" + p1StoreTotalNumber);
			io.println("	player 2:" + p2StoreTotalNumber);
		}
		storeTotalNumberArr[0] = p1StoreTotalNumber;
		storeTotalNumberArr[1] = p2StoreTotalNumber;
		if (storeTotalNumberArr[1] > storeTotalNumberArr[0]) {
			io.println("Player 2 wins!");
		}
		else if (storeTotalNumberArr[0] > storeTotalNumberArr[1]) {
			io.println("Player 1 wins!");
		}
		else if ((storeTotalNumberArr[0] == storeTotalNumberArr[1]) && (storeTotalNumberArr[0] != 0)) {
			io.println("A tie!");
		}
		return storeTotalNumberArr;
		
	}

	public int[] gameFinishP2Round(IO io, KalahBoard kalahBoard, int[] p1NumberArray, int[] p2NumberArray) {
		int[] storeTotalNumberArr = new int[2];
		int p1StoreTotalNumber = 0;
		int p2StoreTotalNumber = 0;
		if (p2NumberArray[0]==0 && p2NumberArray[1]==0 && p2NumberArray[2]==0 && p2NumberArray[3]==0 && p2NumberArray[4]==0 && p2NumberArray[5]==0) {
			io.println("Game over");
			kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
			p2StoreTotalNumber = p2NumberArray[6];
			p1StoreTotalNumber = p1NumberArray[6] + p1NumberArray[0] + p1NumberArray[1] + p1NumberArray[2] + p1NumberArray[3] + p1NumberArray[4] + p1NumberArray[5];
			io.println("	player 1:" + p1StoreTotalNumber);
			io.println("	player 2:" + p2StoreTotalNumber);
		}
		storeTotalNumberArr[0] = p1StoreTotalNumber;
		storeTotalNumberArr[1] = p2StoreTotalNumber;
		if (storeTotalNumberArr[1] > storeTotalNumberArr[0]) {
			io.println("Player 2 wins!");
		}
		else if (storeTotalNumberArr[0] > storeTotalNumberArr[1]) {
			io.println("Player 1 wins!");
		}
		else if ((storeTotalNumberArr[0] == storeTotalNumberArr[1]) && (storeTotalNumberArr[0] != 0)) {
			io.println("A tie!");
		}
		return storeTotalNumberArr;
		
	}

	public boolean seedIsZeroPlayerOne(IO io, KalahBoard kalahBoard, Player playerOne, kalahPromptGetInputCondition p1Prompt, char inputChar, int[] p1NumberArray, int[] p2NumberArray, int collectSeedFromHouse, boolean finished) {
		int inputInt = inputChar - '0';
		//int collectSeedFromHouse = p1NumberArray[inputInt-1];
		while (collectSeedFromHouse == 0) {
			io.println("House is empty. Move again.");
			kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
			// one more round
			inputChar = p1Prompt.p1Prompt(io);
			inputInt = inputChar - '0';
            if (inputChar == 'q') {
                io.println("Game over");
                kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
                finished = true;
                break;
            }
			collectSeedFromHouse = p1NumberArray[inputInt-1];
			returnIntWithTwoIntArr intElementsP1Array = playerOne.playerOneRound(io, p1NumberArray, p2NumberArray, inputInt);
			p1NumberArray = intElementsP1Array.p1Array;
			p2NumberArray = intElementsP1Array.p2Array;
			
		}
        return finished;
	}

	public boolean seedIsZeroPlayerTwo(IO io, KalahBoard kalahBoard, Player playerTwo, kalahPromptGetInputCondition p2Prompt, char inputChar, int[] p1NumberArray, int[] p2NumberArray, int collectSeedFromHouse, boolean finished) {
		int inputInt = inputChar - '0';
		//int collectSeedFromHouse = p2NumberArray[inputInt-1];
		while (collectSeedFromHouse == 0) {
			io.println("House is empty. Move again.");
			kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
			// one more round
			inputChar = p2Prompt.p2Prompt(io);
			inputInt = inputChar - '0';
            if (inputChar == 'q') {
                io.println("Game over");
                kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
                finished = true;
                break;
            }
			collectSeedFromHouse = p2NumberArray[inputInt-1];
			returnIntWithTwoIntArr intElementsP2Array = playerTwo.playerTwoRound(io, p1NumberArray, p2NumberArray, inputInt);
			p1NumberArray = intElementsP2Array.p1Array;
			p2NumberArray = intElementsP2Array.p2Array;
			
		}
        return finished;
	}
}
=======
package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 * This class is the KalahCases class, contains 2 gameFinish functions 
 * and 2 seedIsZero functions for player1 round and player2. 
 */

public class KalahCases {
    public int[] gameFinishP1Round(IO io, KalahBoard kalahBoard, int[] p1NumberArray, int[] p2NumberArray) {
		int[] storeTotalNumberArr = new int[2];
		int p1StoreTotalNumber = 0;
		int p2StoreTotalNumber = 0;
		if (p1NumberArray[0]==0 && p1NumberArray[1]==0 && p1NumberArray[2]==0 && p1NumberArray[3]==0 && p1NumberArray[4]==0 && p1NumberArray[5]==0) {
			io.println("Game over");
			kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
			p1StoreTotalNumber = p1NumberArray[6];
			p2StoreTotalNumber = p2NumberArray[6] + p2NumberArray[0] + p2NumberArray[1] + p2NumberArray[2] + p2NumberArray[3] + p2NumberArray[4] + p2NumberArray[5];
			io.println("	player 1:" + p1StoreTotalNumber);
			io.println("	player 2:" + p2StoreTotalNumber);
		}
		storeTotalNumberArr[0] = p1StoreTotalNumber;
		storeTotalNumberArr[1] = p2StoreTotalNumber;
		if (storeTotalNumberArr[1] > storeTotalNumberArr[0]) {
			io.println("Player 2 wins!");
		}
		else if (storeTotalNumberArr[0] > storeTotalNumberArr[1]) {
			io.println("Player 1 wins!");
		}
		else if ((storeTotalNumberArr[0] == storeTotalNumberArr[1]) && (storeTotalNumberArr[0] != 0)) {
			io.println("A tie!");
		}
		return storeTotalNumberArr;
		
	}

	public int[] gameFinishP2Round(IO io, KalahBoard kalahBoard, int[] p1NumberArray, int[] p2NumberArray) {
		int[] storeTotalNumberArr = new int[2];
		int p1StoreTotalNumber = 0;
		int p2StoreTotalNumber = 0;
		if (p2NumberArray[0]==0 && p2NumberArray[1]==0 && p2NumberArray[2]==0 && p2NumberArray[3]==0 && p2NumberArray[4]==0 && p2NumberArray[5]==0) {
			io.println("Game over");
			kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
			p2StoreTotalNumber = p2NumberArray[6];
			p1StoreTotalNumber = p1NumberArray[6] + p1NumberArray[0] + p1NumberArray[1] + p1NumberArray[2] + p1NumberArray[3] + p1NumberArray[4] + p1NumberArray[5];
			io.println("	player 1:" + p1StoreTotalNumber);
			io.println("	player 2:" + p2StoreTotalNumber);
		}
		storeTotalNumberArr[0] = p1StoreTotalNumber;
		storeTotalNumberArr[1] = p2StoreTotalNumber;
		if (storeTotalNumberArr[1] > storeTotalNumberArr[0]) {
			io.println("Player 2 wins!");
		}
		else if (storeTotalNumberArr[0] > storeTotalNumberArr[1]) {
			io.println("Player 1 wins!");
		}
		else if ((storeTotalNumberArr[0] == storeTotalNumberArr[1]) && (storeTotalNumberArr[0] != 0)) {
			io.println("A tie!");
		}
		return storeTotalNumberArr;
		
	}

	public boolean seedIsZeroPlayerOne(IO io, KalahBoard kalahBoard, Player playerOne, kalahPromptGetInputCondition p1Prompt, char inputChar, int[] p1NumberArray, int[] p2NumberArray, int collectSeedFromHouse, boolean finished) {
		int inputInt = inputChar - '0';
		//int collectSeedFromHouse = p1NumberArray[inputInt-1];
		while (collectSeedFromHouse == 0) {
			io.println("House is empty. Move again.");
			kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
			// one more round
			inputChar = p1Prompt.p1Prompt(io);
			inputInt = inputChar - '0';
            if (inputChar == 'q') {
                io.println("Game over");
                kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
                finished = true;
                break;
            }
			collectSeedFromHouse = p1NumberArray[inputInt-1];
			returnIntWithTwoIntArr intElementsP1Array = playerOne.playerOneRound(io, p1NumberArray, p2NumberArray, inputInt);
			p1NumberArray = intElementsP1Array.p1Array;
			p2NumberArray = intElementsP1Array.p2Array;
			
		}
        return finished;
	}

	public boolean seedIsZeroPlayerTwo(IO io, KalahBoard kalahBoard, Player playerTwo, kalahPromptGetInputCondition p2Prompt, char inputChar, int[] p1NumberArray, int[] p2NumberArray, int collectSeedFromHouse, boolean finished) {
		int inputInt = inputChar - '0';
		//int collectSeedFromHouse = p2NumberArray[inputInt-1];
		while (collectSeedFromHouse == 0) {
			io.println("House is empty. Move again.");
			kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
			// one more round
			inputChar = p2Prompt.p2Prompt(io);
			inputInt = inputChar - '0';
            if (inputChar == 'q') {
                io.println("Game over");
                kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
                finished = true;
                break;
            }
			collectSeedFromHouse = p2NumberArray[inputInt-1];
			returnIntWithTwoIntArr intElementsP2Array = playerTwo.playerTwoRound(io, p1NumberArray, p2NumberArray, inputInt);
			p1NumberArray = intElementsP2Array.p1Array;
			p2NumberArray = intElementsP2Array.p2Array;
			
		}
        return finished;
	}
}
>>>>>>> 866f88214f164e6ba4eb71c5f2ad37dbdbebc9ec
