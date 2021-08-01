<<<<<<< HEAD
package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 * This class is the Move class, contains moveStepP1RoundReturnFinalMoveIndex 
 * method and moveStepP2RoundReturnFinalMoveIndex method to do the moving 
 * in the back of the kalah board.
 * The methods return an integer lastIndexMove, two int[] p1NumberArray 
 * and p2NumberArray.
 */

public class Move {
    public returnIntWithTwoIntArr moveStepP1RoundReturnFinalMoveIndex(IO io, int[] p1NumberArray, int[] p2NumberArray,
                                                                      int inputInt) {
        KalahBoard kalahBoard = new KalahBoard();

        int p2Store = p2NumberArray[p2NumberArray.length-1];
        int[] reactiveArray = {p1NumberArray[0], p1NumberArray[1], p1NumberArray[2], p1NumberArray[3], p1NumberArray[4], p1NumberArray[5], p1NumberArray[6], p2NumberArray[0], p2NumberArray[1], p2NumberArray[2], p2NumberArray[3], p2NumberArray[4], p2NumberArray[5]};
        //initial1 [4,4,4,4,4,4,0,4,4,4,4,4,4] length=13
        
        int collectSeedFromHouse = reactiveArray[inputInt-1];
               
        // Collect all the seed from the inputInt corresponding house => set the seed in the house to be 0
        reactiveArray[inputInt-1] = 0;

        int lastMoveIndex = 0; // for checking purpose

        // while the collected seed is not 0, plant 1 each house anti-clockwise, including the player's store (p1 houses + p1 store + p2 house; if out of index then start again at the P1's house 1)      
        if ((collectSeedFromHouse+inputInt)<=reactiveArray.length){ //if inputInt=6, collectedSeed<=7
            for (int i=0; i<collectSeedFromHouse; i++){
                reactiveArray[inputInt+i]++;
                lastMoveIndex = inputInt+i;
            }
        }
        else if ((reactiveArray.length<(collectSeedFromHouse+inputInt)) && ((collectSeedFromHouse+inputInt)<=(reactiveArray.length*2))){ // if inputInt=6, 8<=collectedSeed<=20
            for (int i=0; i<reactiveArray.length-inputInt; i++){
                reactiveArray[inputInt+i]++;
            }
            for (int i=0; i<collectSeedFromHouse-(reactiveArray.length-inputInt); i++){
                reactiveArray[i]++;
                lastMoveIndex = i;
            }
        }
        else if ((reactiveArray.length*2<(collectSeedFromHouse+inputInt)) && ((collectSeedFromHouse+inputInt)<=(reactiveArray.length*3))){ // if inputInt=6, 21<=collectedSeed<=33
            for (int i=0; i<reactiveArray.length-inputInt; i++){
                reactiveArray[inputInt+i]++;
            }
            for (int i=0; i<reactiveArray.length; i++){
                reactiveArray[i]++;
            }
            for (int i=0; i<collectSeedFromHouse-(reactiveArray.length*2-inputInt); i++){
                reactiveArray[i]++;
                lastMoveIndex = i;
            }
        }

        // split the reactiveArray back into p1NumberArray and p2NumberArray
        for (int position=0; position<reactiveArray.length; position++) {
            if (position < p1NumberArray.length) {
                p1NumberArray[position] = reactiveArray[position];
            }
            else {
                p2NumberArray[position-p1NumberArray.length] = reactiveArray[position];
            }
        }
        p2NumberArray[p2NumberArray.length-1]= p2Store;

        // Special case - if a move ends in player's house that is empty, 
        // the player gets that seed and all seeds in the opposing house.
        if ((lastMoveIndex != 6) && (lastMoveIndex < p1NumberArray.length) && (p1NumberArray[lastMoveIndex] == 1)) {
            if (p2NumberArray[p2NumberArray.length-2-lastMoveIndex] > 0) {
                int p1Seed = p1NumberArray[lastMoveIndex];
                int p2Seed = p2NumberArray[p2NumberArray.length-2-lastMoveIndex];
                p1NumberArray[lastMoveIndex] = 0;
                p2NumberArray[p2NumberArray.length-2-lastMoveIndex] = 0;
                p1NumberArray[p1NumberArray.length-1] = p1NumberArray[p1NumberArray.length-1] + p1Seed + p2Seed;
                kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
            }
            else {
                kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
            } 
        }
        // In case of empty seed, straight print "House empty. Move again." and then print the existing kalah board.
        else if (collectSeedFromHouse != 0) {
            kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
        }
        return new returnIntWithTwoIntArr(lastMoveIndex, p1NumberArray, p2NumberArray);
    }

    public returnIntWithTwoIntArr moveStepP2RoundReturnFinalMoveIndex(IO io, int[] p1NumberArray, int[] p2NumberArray, int inputInt) {

        KalahBoard kalahBoard = new KalahBoard();

        int p1Store = p1NumberArray[p1NumberArray.length-1];
        int[] reactiveArray = {p2NumberArray[0], p2NumberArray[1], p2NumberArray[2], p2NumberArray[3], p2NumberArray[4], p2NumberArray[5], p2NumberArray[6], p1NumberArray[0], p1NumberArray[1], p1NumberArray[2], p1NumberArray[3], p1NumberArray[4], p1NumberArray[5]};
        //initial: [4,4,4,4,4,4,0,4,4,4,4,4,4] length=13
        
        int collectSeedFromHouse = reactiveArray[inputInt-1];
               
        // Collect all the seed from the inputInt corresponding house => set the seed in the house to be 0
        reactiveArray[inputInt-1] = 0;

        int lastMoveIndex = 0; // for check purpose

        // while the collected seed is not 0, plant 1 each house anti-clockwise, including the player's store (p1 houses + p1 store + p2 house; if out of index then start again at the P1's house 1)      
        if ((collectSeedFromHouse+inputInt)<=reactiveArray.length){ // if inputInt=6, collectSeed<=7
            for (int i=0; i<collectSeedFromHouse; i++){
                reactiveArray[inputInt+i]++;
                lastMoveIndex = inputInt+i;
            }
        }
        else if ((reactiveArray.length<(collectSeedFromHouse+inputInt)) && ((collectSeedFromHouse+inputInt)<=(reactiveArray.length*2))){ // if inputInt=6, 8<=collectSeed<=20
            for (int i=0; i<reactiveArray.length-inputInt; i++){
                reactiveArray[inputInt+i]++;
            }
            for (int j=0; j<collectSeedFromHouse-(reactiveArray.length-inputInt); j++){
                reactiveArray[j]++;
                lastMoveIndex = j;
            }
        }
        else if ((reactiveArray.length*2<(collectSeedFromHouse+inputInt)) && ((collectSeedFromHouse+inputInt)<=(reactiveArray.length*3))){ // if inputInt=6, 21<=collectSeed<=33
            for (int i=0; i<reactiveArray.length-inputInt; i++){
                reactiveArray[inputInt+i]++;
            }
            for (int j=0; j<reactiveArray.length; j++){
                reactiveArray[j]++;
            }
            for (int k=0; k<collectSeedFromHouse-(reactiveArray.length*2-inputInt); k++){
                reactiveArray[k]++;
                lastMoveIndex = k;
            }
        }

        // split the reactiveArray back into p2NumberArray and p1NumberArray
        for (int position=0; position<reactiveArray.length; position++) {
            if (position < p1NumberArray.length) {
                p2NumberArray[position] = reactiveArray[position];
            }
            else {
                p1NumberArray[position-p1NumberArray.length] = reactiveArray[position];
            }
        }
        p1NumberArray[p1NumberArray.length-1]= p1Store;

        // Special Case - see above comment
        if ((lastMoveIndex != 6) && (lastMoveIndex < p2NumberArray.length) && (p2NumberArray[lastMoveIndex] == 1)) {
            if (p1NumberArray[p1NumberArray.length-2-lastMoveIndex] > 0) {
                int p2Seed = p2NumberArray[lastMoveIndex];
                int p1Seed = p1NumberArray[p1NumberArray.length-2-lastMoveIndex];
                p2NumberArray[lastMoveIndex] = 0;
                p1NumberArray[p1NumberArray.length-2-lastMoveIndex] = 0;
                p2NumberArray[p2NumberArray.length-1] = p2NumberArray[p1NumberArray.length-1] + p1Seed + p2Seed;
                kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
            }
            else {
                kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
            }   
        }
        else if (collectSeedFromHouse != 0) {
            kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
        }

        return new returnIntWithTwoIntArr(lastMoveIndex, p1NumberArray, p2NumberArray);
    }
}
=======
package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 * This class is the Move class, contains moveStepP1RoundReturnFinalMoveIndex 
 * method and moveStepP2RoundReturnFinalMoveIndex method to do the moving 
 * in the back of the kalah board.
 * The methods return an integer lastIndexMove, two int[] p1NumberArray 
 * and p2NumberArray.
 */

public class Move {
    public returnIntWithTwoIntArr moveStepP1RoundReturnFinalMoveIndex(IO io, int[] p1NumberArray, int[] p2NumberArray,
                                                                      int inputInt) {
        KalahBoard kalahBoard = new KalahBoard();

        int p2Store = p2NumberArray[p2NumberArray.length-1];
        int[] reactiveArray = {p1NumberArray[0], p1NumberArray[1], p1NumberArray[2], p1NumberArray[3], p1NumberArray[4], p1NumberArray[5], p1NumberArray[6], p2NumberArray[0], p2NumberArray[1], p2NumberArray[2], p2NumberArray[3], p2NumberArray[4], p2NumberArray[5]};
        //initial1 [4,4,4,4,4,4,0,4,4,4,4,4,4] length=13
        
        int collectSeedFromHouse = reactiveArray[inputInt-1];
               
        // Collect all the seed from the inputInt corresponding house => set the seed in the house to be 0
        reactiveArray[inputInt-1] = 0;

        int lastMoveIndex = 0; // for checking purpose

        // while the collected seed is not 0, plant 1 each house anti-clockwise, including the player's store (p1 houses + p1 store + p2 house; if out of index then start again at the P1's house 1)      
        if ((collectSeedFromHouse+inputInt)<=reactiveArray.length){ //if inputInt=6, collectedSeed<=7
            for (int i=0; i<collectSeedFromHouse; i++){
                reactiveArray[inputInt+i]++;
                lastMoveIndex = inputInt+i;
            }
        }
        else if ((reactiveArray.length<(collectSeedFromHouse+inputInt)) && ((collectSeedFromHouse+inputInt)<=(reactiveArray.length*2))){ // if inputInt=6, 8<=collectedSeed<=20
            for (int i=0; i<reactiveArray.length-inputInt; i++){
                reactiveArray[inputInt+i]++;
            }
            for (int i=0; i<collectSeedFromHouse-(reactiveArray.length-inputInt); i++){
                reactiveArray[i]++;
                lastMoveIndex = i;
            }
        }
        else if ((reactiveArray.length*2<(collectSeedFromHouse+inputInt)) && ((collectSeedFromHouse+inputInt)<=(reactiveArray.length*3))){ // if inputInt=6, 21<=collectedSeed<=33
            for (int i=0; i<reactiveArray.length-inputInt; i++){
                reactiveArray[inputInt+i]++;
            }
            for (int i=0; i<reactiveArray.length; i++){
                reactiveArray[i]++;
            }
            for (int i=0; i<collectSeedFromHouse-(reactiveArray.length*2-inputInt); i++){
                reactiveArray[i]++;
                lastMoveIndex = i;
            }
        }

        // split the reactiveArray back into p1NumberArray and p2NumberArray
        for (int position=0; position<reactiveArray.length; position++) {
            if (position < p1NumberArray.length) {
                p1NumberArray[position] = reactiveArray[position];
            }
            else {
                p2NumberArray[position-p1NumberArray.length] = reactiveArray[position];
            }
        }
        p2NumberArray[p2NumberArray.length-1]= p2Store;

        // Special case - if a move ends in player's house that is empty, 
        // the player gets that seed and all seeds in the opposing house.
        if ((lastMoveIndex != 6) && (lastMoveIndex < p1NumberArray.length) && (p1NumberArray[lastMoveIndex] == 1)) {
            if (p2NumberArray[p2NumberArray.length-2-lastMoveIndex] > 0) {
                int p1Seed = p1NumberArray[lastMoveIndex];
                int p2Seed = p2NumberArray[p2NumberArray.length-2-lastMoveIndex];
                p1NumberArray[lastMoveIndex] = 0;
                p2NumberArray[p2NumberArray.length-2-lastMoveIndex] = 0;
                p1NumberArray[p1NumberArray.length-1] = p1NumberArray[p1NumberArray.length-1] + p1Seed + p2Seed;
                kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
            }
            else {
                kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
            } 
        }
        // In case of empty seed, straight print "House empty. Move again." and then print the existing kalah board.
        else if (collectSeedFromHouse != 0) {
            kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
        }
        return new returnIntWithTwoIntArr(lastMoveIndex, p1NumberArray, p2NumberArray);
    }

    public returnIntWithTwoIntArr moveStepP2RoundReturnFinalMoveIndex(IO io, int[] p1NumberArray, int[] p2NumberArray, int inputInt) {

        KalahBoard kalahBoard = new KalahBoard();

        int p1Store = p1NumberArray[p1NumberArray.length-1];
        int[] reactiveArray = {p2NumberArray[0], p2NumberArray[1], p2NumberArray[2], p2NumberArray[3], p2NumberArray[4], p2NumberArray[5], p2NumberArray[6], p1NumberArray[0], p1NumberArray[1], p1NumberArray[2], p1NumberArray[3], p1NumberArray[4], p1NumberArray[5]};
        //initial: [4,4,4,4,4,4,0,4,4,4,4,4,4] length=13
        
        int collectSeedFromHouse = reactiveArray[inputInt-1];
               
        // Collect all the seed from the inputInt corresponding house => set the seed in the house to be 0
        reactiveArray[inputInt-1] = 0;

        int lastMoveIndex = 0; // for check purpose

        // while the collected seed is not 0, plant 1 each house anti-clockwise, including the player's store (p1 houses + p1 store + p2 house; if out of index then start again at the P1's house 1)      
        if ((collectSeedFromHouse+inputInt)<=reactiveArray.length){ // if inputInt=6, collectSeed<=7
            for (int i=0; i<collectSeedFromHouse; i++){
                reactiveArray[inputInt+i]++;
                lastMoveIndex = inputInt+i;
            }
        }
        else if ((reactiveArray.length<(collectSeedFromHouse+inputInt)) && ((collectSeedFromHouse+inputInt)<=(reactiveArray.length*2))){ // if inputInt=6, 8<=collectSeed<=20
            for (int i=0; i<reactiveArray.length-inputInt; i++){
                reactiveArray[inputInt+i]++;
            }
            for (int j=0; j<collectSeedFromHouse-(reactiveArray.length-inputInt); j++){
                reactiveArray[j]++;
                lastMoveIndex = j;
            }
        }
        else if ((reactiveArray.length*2<(collectSeedFromHouse+inputInt)) && ((collectSeedFromHouse+inputInt)<=(reactiveArray.length*3))){ // if inputInt=6, 21<=collectSeed<=33
            for (int i=0; i<reactiveArray.length-inputInt; i++){
                reactiveArray[inputInt+i]++;
            }
            for (int j=0; j<reactiveArray.length; j++){
                reactiveArray[j]++;
            }
            for (int k=0; k<collectSeedFromHouse-(reactiveArray.length*2-inputInt); k++){
                reactiveArray[k]++;
                lastMoveIndex = k;
            }
        }

        // split the reactiveArray back into p2NumberArray and p1NumberArray
        for (int position=0; position<reactiveArray.length; position++) {
            if (position < p1NumberArray.length) {
                p2NumberArray[position] = reactiveArray[position];
            }
            else {
                p1NumberArray[position-p1NumberArray.length] = reactiveArray[position];
            }
        }
        p1NumberArray[p1NumberArray.length-1]= p1Store;

        // Special Case - see above comment
        if ((lastMoveIndex != 6) && (lastMoveIndex < p2NumberArray.length) && (p2NumberArray[lastMoveIndex] == 1)) {
            if (p1NumberArray[p1NumberArray.length-2-lastMoveIndex] > 0) {
                int p2Seed = p2NumberArray[lastMoveIndex];
                int p1Seed = p1NumberArray[p1NumberArray.length-2-lastMoveIndex];
                p2NumberArray[lastMoveIndex] = 0;
                p1NumberArray[p1NumberArray.length-2-lastMoveIndex] = 0;
                p2NumberArray[p2NumberArray.length-1] = p2NumberArray[p1NumberArray.length-1] + p1Seed + p2Seed;
                kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
            }
            else {
                kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
            }   
        }
        else if (collectSeedFromHouse != 0) {
            kalahBoard.printKalahBoard(io, p1NumberArray, p2NumberArray);
        }

        return new returnIntWithTwoIntArr(lastMoveIndex, p1NumberArray, p2NumberArray);
    }
}
>>>>>>> 866f88214f164e6ba4eb71c5f2ad37dbdbebc9ec
