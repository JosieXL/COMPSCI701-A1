package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;

/**
 * This class is the starting point for a Kalah implementation using
 * the test infrastructure. 
 * This class calls 6 objects from 4 classes.
 * This class is the one that runs for the codes.
 */

public class Kalah {
	public static void main(String[] args) {
		new Kalah().play(new MockIO());
	}

	public void play(IO io) {
		// Replace what's below with your implementation
		//io.println("+----+-------+-------+-------+-------+-------+-------+----+");
		//io.println("| P2 | 6[ 4] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |");
		//io.println("|    |-------+-------+-------+-------+-------+-------|    |");
		//io.println("|  0 | 1[ 4] | 2[ 4] | 3[ 4] | 4[ 4] | 5[ 4] | 6[ 4] | P1 |");
		//io.println("+----+-------+-------+-------+-------+-------+-------+----+");

		KalahBoard kalahBoard = new KalahBoard();
		kalahPromptGetInputCondition p1Prompt = new kalahPromptGetInputCondition();
		kalahPromptGetInputCondition p2Prompt = new kalahPromptGetInputCondition();
		Player playerOne = new Player();
		Player playerTwo = new Player();
		KalahCases kalahCases = new KalahCases();

		/*
        This is the initial state of Kalah board but in array
        */
        int p1HouseOneSeedNumber = 4, p1HouseTwoSeedNumber = 4, p1HouseThreeSeedNumber = 4, p1HouseFourSeedNumber = 4, p1HouseFiveSeedNumber = 4, p1HouseSixSeedNumber = 4;
        int p2HouseOneSeedNumber = 4, p2HouseTwoSeedNumber = 4, p2HouseThreeSeedNumber = 4, p2HouseFourSeedNumber = 4, p2HouseFiveSeedNumber = 4, p2HouseSixSeedNumber = 4;
        int p1StoreNumber = 0, p2StoreNumber = 0;

        int[] p1NumberArray = {p1HouseOneSeedNumber, p1HouseTwoSeedNumber, p1HouseThreeSeedNumber, p1HouseFourSeedNumber, p1HouseFiveSeedNumber, p1HouseSixSeedNumber, p1StoreNumber};
        int[] p2NumberArray = {p2HouseOneSeedNumber, p2HouseTwoSeedNumber, p2HouseThreeSeedNumber, p2HouseFourSeedNumber, p2HouseFiveSeedNumber, p2HouseSixSeedNumber, p2StoreNumber};

		// Print kalah board (initial one)
		kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);

        // round%2==0 => P1 round; round%2==1 => P2 round
        // special case for one more round, round not add 1
		boolean finished = false; // Use with break; to exist for loop when within a while loop
		for (int round=0; round < 100000 && !finished; round++) {
			if (round % 2 == 0) { // P1 round
				int[] storeTotalNumberArr = kalahCases.gameFinishP1Round(io, kalahBoard, p1NumberArray, p2NumberArray);
				if ((storeTotalNumberArr[0] != 0) && (storeTotalNumberArr[1] != 0) ){
					break;
				}
				char inputChar = p1Prompt.p1Prompt(io);
				if (inputChar == 'q') {
					io.println("Game over");
					kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
					break;
				}
				if (inputChar == '1' || inputChar == '2' || inputChar == '3' || inputChar == '4' || inputChar == '5' || inputChar == '6') {
					// do the move
					// Convert char to int
					int inputInt = inputChar - '0';
        			int collectSeedFromHouse = p1NumberArray[inputInt-1];
					if (collectSeedFromHouse == 0){
						finished = kalahCases.seedIsZeroPlayerOne(io, kalahBoard, playerOne, p1Prompt, inputChar, p1NumberArray, p2NumberArray, collectSeedFromHouse, finished);
					}
					else {
						returnIntWithTwoIntArr intElementsP1Array = playerOne.playerOneRound(io, p1NumberArray,
								p2NumberArray, inputInt);
						p1NumberArray = intElementsP1Array.p1Array;
						p2NumberArray = intElementsP1Array.p2Array;
						
						if (intElementsP1Array.finalMoveIndex == 6) {
							while (intElementsP1Array.finalMoveIndex == 6) {
								storeTotalNumberArr = kalahCases.gameFinishP1Round(io, kalahBoard, p1NumberArray, p2NumberArray);
								if ((storeTotalNumberArr[0] != 0) && (storeTotalNumberArr[1] != 0) ){
									finished = true; // Use to exist the outer for loop
									break; // Use to exist the inner while loop
								}
								inputChar = p1Prompt.p1Prompt(io);
								if (inputChar == 'q') {
									io.println("Game over");
									kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
									finished = true;
									break;
								}
								inputInt = inputChar - '0';
								collectSeedFromHouse = p1NumberArray[inputInt-1];
								intElementsP1Array = playerOne.playerOneRound(io, p1NumberArray, p2NumberArray, inputInt);
								p1NumberArray = intElementsP1Array.p1Array;
								p2NumberArray = intElementsP1Array.p2Array;
								if (collectSeedFromHouse == 0) {
									finished = kalahCases.seedIsZeroPlayerOne(io, kalahBoard, playerOne, p1Prompt, inputChar, p1NumberArray, p2NumberArray, collectSeedFromHouse, finished);
								}
							}
						}
					}
				}
			}
			else if (round % 2 == 1) { //P2 round
				int[] storeTotalNumberArr = kalahCases.gameFinishP2Round(io, kalahBoard, p1NumberArray, p2NumberArray);
				if ((storeTotalNumberArr[0] != 0) && (storeTotalNumberArr[1] != 0) ){
					break;
				}
				char inputChar = p2Prompt.p2Prompt(io);
				if (inputChar == 'q') {
					io.println("Game over");
					kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
					break;
				}
				if (inputChar == '1' || inputChar == '2' || inputChar == '3' || inputChar == '4' || inputChar == '5' || inputChar == '6') {
					// do the move
					int inputInt = inputChar - '0';
        			int collectSeedFromHouse = p2NumberArray[inputInt-1];
					if (collectSeedFromHouse == 0){
						finished = kalahCases.seedIsZeroPlayerTwo(io, kalahBoard, playerTwo, p2Prompt, inputChar, p1NumberArray, p2NumberArray, collectSeedFromHouse, finished);
					}
					else {
						returnIntWithTwoIntArr intElementsP2Array = playerTwo.playerTwoRound(io, p1NumberArray,
							p2NumberArray, inputInt);
						p1NumberArray = intElementsP2Array.p1Array;
						p2NumberArray = intElementsP2Array.p2Array;
						if (intElementsP2Array.finalMoveIndex == 6) {
							while (intElementsP2Array.finalMoveIndex == 6) {
								storeTotalNumberArr = kalahCases.gameFinishP2Round(io, kalahBoard, p1NumberArray, p2NumberArray);
								if ((storeTotalNumberArr[0] != 0) && (storeTotalNumberArr[1] != 0) ){
									finished = true;
									break;
								}
								inputChar = p2Prompt.p2Prompt(io);
								if (inputChar == 'q') {
									io.println("Game over");
									kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
									finished = true;
									break;
								}
								inputInt = inputChar - '0';
								collectSeedFromHouse = p2NumberArray[inputInt-1];
								intElementsP2Array = playerTwo.playerTwoRound(io, p1NumberArray, p2NumberArray, inputInt);
								p1NumberArray = intElementsP2Array.p1Array;
								p2NumberArray = intElementsP2Array.p2Array;
								if (collectSeedFromHouse == 0) {
									finished = kalahCases.seedIsZeroPlayerTwo(io, kalahBoard, playerTwo, p2Prompt, inputChar, p1NumberArray, p2NumberArray, collectSeedFromHouse, finished);
								}
							}
						}
					}
				}
			}
        }
	}
}
