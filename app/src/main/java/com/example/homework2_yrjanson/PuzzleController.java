package com.example.homework2_yrjanson;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

/**
 * PuzzleController: Accesses click information and changes values and display accordingly
 * @author annayrjanson
 */

public class PuzzleController implements View.OnClickListener{
    private PuzzleView pView;
    private ArrayList<Button> buttons;

    /**
     * Constructor PuzzleController: Accesses the view, buttons
     * @param pv: The pView
     */

    public PuzzleController(PuzzleView pv) {
        pView = pv;
        buttons = pView.buttons;
    }

    /**
     * onClick: Determines which button was clicked and executes appropriate helper methods
     * @param view: The pView
     */

    @Override
    public void onClick(View view) {
        // Creates the boolean all true to determine if all values in puzzle and solution match
        boolean allTrue;
        // Checks all the buttons and takes the corresponding actions based on the button
        switch (view.getId()) {
            case R.id.button00:
                // Determines which direction to move if a move is possible
                onClickSupplement(0);
                // Checks if the whole puzzle has a matching puzzle and solution array
                allTrue = confirmPuzzle();
                // If the arrays match, color all the buttons green
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button01:
                onClickSupplement(1);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button02:
                onClickSupplement(2);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button03:
                onClickSupplement(3);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button10:
                onClickSupplement(4);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button11:
                onClickSupplement(5);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button12:
                onClickSupplement(6);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button13:
                onClickSupplement(7);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button20:
                onClickSupplement(8);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button21:
                onClickSupplement(9);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button22:
                onClickSupplement(10);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button23:
                onClickSupplement(11);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button30:
                onClickSupplement(12);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button31:
                onClickSupplement(13);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button32:
                onClickSupplement(14);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.button33:
                onClickSupplement(15);
                allTrue = confirmPuzzle();
                if(allTrue) displayAllCorrect();
                break;
            case R.id.reset:
                // Resets the puzzle array
                pView.resetPuzzle();
                // Checks if the puzzle is initially randomized to the solution
                allTrue = confirmPuzzle();
                // If initial puzzle true, displays all the buttons as green
                if(allTrue) displayAllCorrect();
                break;
        }
    }

    /**
     * confirmPuzzle: Determines how many numbers are in the correct location
     * Enhancement: Turns colors red or black based on if the numbers are in the correct location
     * @return: If the pArray and solArray are identical
     */

    public boolean confirmPuzzle() {
        // Tracks the number of matching puzzle and solution array answers
        int correctLocations = 0;
        // Traverses array and determines which values match and sets their colors accordingly
        for (int i = 0; i < pView.PUZZLE_SIZE; i++) {
            for (int j = 0; j < pView.PUZZLE_SIZE; j++) {
                // If values match, set color to red and increment correctLocations
                if(pView.pArray[i][j] == pView.solArray[i][j]) {
                    buttons.get((i * 4) + j).setBackgroundColor(Color.RED);
                    correctLocations++;
                }
                // If values don't match, set color to black
                else {
                    buttons.get((i*4) + j).setBackgroundColor(Color.BLACK);
                }
            }
        }
        // If all the values match, return true
        if (correctLocations == 16) return true;
        // If there is at least one non-matching value, return false
        else return false;
    }

    /**
     * displayAllCorrect: Displays all buttons with green text if all pView and solutionView
     * items are identical
     * Enhancement: Displays a complementary color (green)to the tracker colors (red) to solidify
     * that the user correctly executed the puzzle
     */

    public void displayAllCorrect() {
        // Traverse and set all values to green if all values match in solution and puzzle arrays
        for (int i = 0; i < pView.PUZZLE_SIZE; i++) {
            for (int j = 0; j < pView.PUZZLE_SIZE; j++) {
                buttons.get((i*4)+j).setBackgroundColor(Color.GREEN);
            }
        }
    }

    /**
     * onClickSupplement: Determines if the button selected has a legal move, and executes the
     * switch of both the pArray and buttonText values
     * @param arrayValue: the value in the buttons
     */

    public void onClickSupplement(int arrayValue) {
        // Extract the row and column values from the buttons array position
        int row = arrayValue / 4;
        int column = arrayValue % 4;

        // Determine the one spot location movements and save as variables
        int downRow = row + 1;
        int rightCol = column + 1;
        int upRow = row - 1;
        int leftCol = column -1;

        //Extract the initial pArray value clicked
        int value = pView.pArray[row][column];

        // Determine if the button clicked was the blank button, if not, continue
        if (value != -1) {
            // Determines if the button downward is out of bounds, if not, continue
            if (downRow <= 3) {
                // Determines if the button downward is the blank button, if so, continue
                if (pView.pArray[downRow][column] == -1) {
                    //Switch the pView values
                    int temp = pView.pArray[row][column];
                    pView.pArray[row][column] = pView.pArray[downRow][column];
                    pView.pArray[downRow][column] = temp;

                    //Switch the buttonView array values
                    CharSequence tempString = pView.buttons.get(arrayValue).getText();
                    pView.buttons.get(arrayValue).setText(pView.buttons.get(arrayValue + 4).getText());
                    pView.buttons.get(arrayValue + 4).setText(tempString);
                }
            }
            // Determines if the button rightward is out of bounds, if not, continue
            if (rightCol <= 3) {
                // Determines if the button rightward is the blank button, if so, continue
                if (pView.pArray[row][rightCol] == -1) {
                    //Switch the pView values
                    int temp = pView.pArray[row][column];
                    pView.pArray[row][column] = pView.pArray[row][rightCol];
                    pView.pArray[row][rightCol] = temp;

                    //Switch the buttonView array values
                    CharSequence tempString = pView.buttons.get(arrayValue).getText();
                    pView.buttons.get(arrayValue).setText(pView.buttons.get(arrayValue + 1).getText());
                    pView.buttons.get(arrayValue + 1).setText(tempString);
                }
            }
            // Determines if the button upward is out of bounds, if not, continue
            if (upRow >= 0) {
                // Determines if the button upward is the blank button, if so, continue
                if(pView.pArray[upRow][column] == -1) {
                    //Switch the pView values
                    int temp = pView.pArray[row][column];
                    pView.pArray[row][column] = pView.pArray[upRow][column];
                    pView.pArray[upRow][column] = temp;

                    //Switch the buttonView array values
                    CharSequence tempString = pView.buttons.get(arrayValue).getText();
                    pView.buttons.get(arrayValue).setText(pView.buttons.get(arrayValue - 4).getText());
                    pView.buttons.get(arrayValue - 4).setText(tempString);
                }
            }
            // Determines if the button leftward is out of bounds, if not, continue
            if (leftCol >= 0) {
                // Determines if the button leftward is the blank button, if so, continue
                if(pView.pArray[row][leftCol] == -1) {
                    //Switch the pView values
                    int temp = pView.pArray[row][column];
                    pView.pArray[row][column] = pView.pArray[row][leftCol];
                    pView.pArray[row][leftCol] = temp;

                    //Switch the buttonView array values
                    CharSequence tempString = pView.buttons.get(arrayValue).getText();
                    pView.buttons.get(arrayValue).setText(pView.buttons.get(arrayValue - 1).getText());
                    pView.buttons.get(arrayValue - 1).setText(tempString);
                }
            }
        }
    }
}
