package com.example.emartin.donaldannoyancegame;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


//Main Screen
public class MainActivity extends AppCompatActivity {

    private int currentGuess;
    private int randomNumber;
    private int currentNumber;
    private Button enterButton;
    private Button newGame;
    private EditText editText;
    private TextView previousGuess;
    private TextView totalGuesses;
    private TextView clueMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumber = getRandomNumber();
        currentGuess = 10;

        editText = (EditText) findViewById(R.id.guessed_number);
        previousGuess = (TextView) findViewById(R.id.last_guess);
        totalGuesses = (TextView) findViewById(R.id.number_of_tries);
        clueMessage = (TextView) findViewById(R.id.clue_message);

        enterButton = (Button) findViewById(R.id.enter_button);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guessNumber(view);
            }
        });

        newGame = (Button) findViewById(R.id.new_game_button);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewGame(view, false);
            }
        });
    }

    //called when a user guesses a number
    public void guessNumber(View view) {

        currentNumber = Integer.parseInt(editText.getText().toString());

        if(currentNumber == randomNumber) {
            //displayPicture(view, 1);
            startNewGame(view, true);
        } else {
            //last guess, lose game
            if(currentGuess == 1) {
                //displayPicture(view, 0);
                startNewGame(view, false);
            }


            //change current guess number
            currentGuess--;
            //change last number chosen
            previousGuess.setText(String.valueOf(currentNumber));
            //change number of tries left
            totalGuesses.setText(String.valueOf(currentGuess)); 
            //give a hint
            String message = "";
            if(currentNumber < randomNumber)
                message = "Incorrect.  Higher than " + currentNumber;
            else
                message = "Incorrect.  Lower than " + currentNumber;
            clueMessage.setText(message);

        }

    }

    //called when user presses new game
    public void startNewGame(View view, boolean win) {

        Context context = getApplicationContext();
        String message = "";

        if(win == true) {
            message = "YOU WIN!";
        } else {
            message = "GAME OVER";
        }

        Toast.makeText(context,
                message,
                Toast.LENGTH_LONG).show();

        currentGuess = 10;
        randomNumber = getRandomNumber();
        this.previousGuess.setText("");
        this.totalGuesses.setText("");
        this.clueMessage.setText("");
        //finish();
    }

    public void displayPicture(View view, int num) {
        if(num ==1) {
            //you win
        } else {
            //you lose
        }
    }

    //get a random number between 1 and 100
    public static int getRandomNumber() {

        Random random_generator = new Random();
        int number = random_generator.nextInt(100) + 1;
        return number;

    }

}
