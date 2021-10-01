package com.example.homework2_yrjanson;
import android.graphics.Color;
import android.widget.Button;
import java.util.ArrayList;

/**
 * PuzzleView: Generates the resets the puzzle in both the display
 * and the array views
 * @author annayrjanson
 */

public class PuzzleView{
    public static final int PUZZLE_SIZE = 4;
    public ArrayList<Button> buttons;
    int[][] pArray;
    int[][] solArray;

    /**
     * Constructor PuzzleView: Creates arrays that store, display and verify the puzzle solution
     * pArray: stores the randomized values
     * buttons: stores the button objects that are displayed
     * solArray: the constant solution array
     */

    public PuzzleView(){
        super();
        pArray = new int[PUZZLE_SIZE][PUZZLE_SIZE];
        buttons = new ArrayList<Button>(16);
        solArray = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, -1}};
    }

    /**
     * genPuzzle: generates the randomized values that are placed into the pArray
     * Assigns each number (1-15) by randomizing plot points and fills the ones that haven't already
     * been selected
     */

    public void genPuzzle(){
        // Instantiates all the pArray values as -1; to then be randomized
        for(int i = 0; i < PUZZLE_SIZE; i++){
            for(int j = 0; j < PUZZLE_SIZE; j++){
                pArray[i][j] = -1;
            }
        }

        // Randomizes possible location and allocates based on whether a space is occupied
        for(int i = 1; i <= PUZZLE_SIZE*PUZZLE_SIZE-1; i++){
            // Attempts location
            int randomRow = (int) ((PUZZLE_SIZE)*Math.random());
            int randomCol = (int) ((PUZZLE_SIZE)*Math.random());
            // Checks if location is occupied or not
            if(pArray[randomRow][randomCol] == -1) {
                // If unused, places value in that location
                pArray[randomRow][randomCol] = i;
            // If occupied, keeps the value to place the same
            }else{
                i--;
            }
        }
    }

    /**
     * resetPuzzle: calls genPuzzle() and sets the text for the display buttons accordingly.
     * Also resets the background colors
     * Enhancement: Always resets the button colors back to black at the start of every reset
     */

    public void resetPuzzle() {
        // Generates the puzzle array
        this.genPuzzle();
        // Sets the button text based on the random array
        for (int i = 0; i < PUZZLE_SIZE; i++) {
            for (int j = 0; j < PUZZLE_SIZE; j++) {
                // If the empty spot, sets the text to empty
                if (pArray[i][j] == -1) this.buttons.get((i*4)+j).setText("");
                // If a number, sets the text to the number
                else this.buttons.get((i * 4) + j).setText("" + this.pArray[i][j]);
                // Sets the background color of all buttons to black at initial reset
                this.buttons.get((i*4) + j).setBackgroundColor(Color.BLACK);
            }
        }
    }
}
