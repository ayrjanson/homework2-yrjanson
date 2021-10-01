package com.example.homework2_yrjanson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;

/**
 * MainActivity: Calls the various methods to create and display the puzzle on the device
 * Creates the array of button objects and their listener, same with the reset button
 *
 * Enhancement 1: I changed and added several methods that check during play if some buttons
 * are already in their correct positioning, they are identified with red button backgrounds
 *
 * @author annayrjanson
 * @date October 1st, 2021
 */

public class MainActivity extends AppCompatActivity{
    PuzzleView puzzle;
    @Override

    /**
     * onCreate: Creates the PuzzleView and PuzzleController; used to display the puzzle
     */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        // Creates new puzzleView and generates the first randomized puzzle
        puzzle = new PuzzleView();
        puzzle.genPuzzle();

        // Creates a controller for the puzzleView
        PuzzleController puzzleController = new PuzzleController(puzzle);

        // Creates an array list of buttons that can be accessed by the controller
        setArrayList(puzzle, puzzleController);

        // Creates a reset button to randomize the puzzle again and set the arrays accordingly
        Button resetButton = findViewById(R.id.reset);
        resetButton.setOnClickListener(puzzleController);
    }

    /**
     * setArrayList: Sets the arrayList of buttons used to read clicks and display numbers
     * @param puzzle: the puzzleView extracting the numerical values in the 2D array
     * @param puzzleController: the access to the button clicking
     */

    public void setArrayList(PuzzleView puzzle, PuzzleController puzzleController) {
        // Creates the array list of grid buttons
        Button zeroZero = findViewById(R.id.button00);
        puzzle.buttons.add(zeroZero);
        zeroZero.setOnClickListener(puzzleController);

        Button zeroOne = findViewById(R.id.button01);
        puzzle.buttons.add(zeroOne);
        zeroOne.setOnClickListener(puzzleController);

        Button zeroTwo = findViewById(R.id.button02);
        puzzle.buttons.add(zeroTwo);
        zeroTwo.setOnClickListener(puzzleController);

        Button zeroThree = findViewById(R.id.button03);
        puzzle.buttons.add(zeroThree);
        zeroThree.setOnClickListener(puzzleController);

        Button oneZero = findViewById(R.id.button10);
        puzzle.buttons.add(oneZero);
        oneZero.setOnClickListener(puzzleController);

        Button oneOne = findViewById(R.id.button11);
        puzzle.buttons.add(oneOne);
        oneOne.setOnClickListener(puzzleController);

        Button oneTwo = findViewById(R.id.button12);
        puzzle.buttons.add(oneTwo);
        oneTwo.setOnClickListener(puzzleController);

        Button oneThree = findViewById(R.id.button13);
        puzzle.buttons.add(oneThree);
        oneThree.setOnClickListener(puzzleController);

        Button twoZero = findViewById(R.id.button20);
        puzzle.buttons.add(twoZero);
        twoZero.setOnClickListener(puzzleController);

        Button twoOne = findViewById(R.id.button21);
        puzzle.buttons.add(twoOne);
        twoOne.setOnClickListener(puzzleController);

        Button twoTwo = findViewById(R.id.button22);
        puzzle.buttons.add(twoTwo);
        twoTwo.setOnClickListener(puzzleController);

        Button twoThree = findViewById(R.id.button23);
        puzzle.buttons.add(twoThree);
        twoThree.setOnClickListener(puzzleController);

        Button threeZero = findViewById(R.id.button30);
        puzzle.buttons.add(threeZero);
        threeZero.setOnClickListener(puzzleController);

        Button threeOne = findViewById(R.id.button31);
        puzzle.buttons.add(threeOne);
        threeOne.setOnClickListener(puzzleController);

        Button threeTwo = findViewById(R.id.button32);
        puzzle.buttons.add(threeTwo);
        threeTwo.setOnClickListener(puzzleController);

        Button threeThree = findViewById(R.id.button33);
        puzzle.buttons.add(threeThree);
        threeThree.setOnClickListener(puzzleController);


        // Sets the text for all the grid buttons now in the buttons array
        for (int i = 0; i < puzzle.PUZZLE_SIZE; i++) {
            for (int j = 0; j < puzzle.PUZZLE_SIZE; j++) {
                if (puzzle.pArray[i][j] == -1) {
                    puzzle.buttons.get((i*4) + j).setText("");
                }
                else puzzle.buttons.get((i*4) + j).setText("" + puzzle.pArray[i][j]);
            }
        }
    }
}