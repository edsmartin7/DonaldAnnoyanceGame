package com.example.emartin.donaldannoyancegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


//Main Screen
public class MainActivity extends AppCompatActivity {

    private int current_guess;
    private int random_number;
    private int current_number;
    private Button enter_button;
    private Button new_game;
    private EditText editText;
    private TextView last_guess;
    private TextView total_guesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get a random number between 1 and 100
        Random random_generator = new Random();
        random_number = random_generator.nextInt(100) + 1;

        editText = (EditText) findViewById(R.id.guessed_number);
        last_guess = (TextView) findViewById(R.id.last_guess);
        total_guesses = (TextView) findViewById(R.id.number_of_tries);

        enter_button = (Button) findViewById(R.id.enter_button);
        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guessNumber(view);
            }
        });

        new_game = (Button) findViewById(R.id.new_game_button);
        new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame(view);
            }
        });
    }

    //called when a user guesses a number
    public void guessNumber(View view) {

        current_number = Integer.parseInt(editText.getText().toString());

        if(current_number == random_number) {
            displayPicture(view, 1);
        } else {
            //last guess, lose game
            if(current_guess == 10) {
                displayPicture(view, 0);
                newGame(view);
            }


            //change current guess number
            current_guess++;
            //change last number chosen
            last_guess.setText(current_number);
            //change number of tries left
            total_guesses.setText(current_guess); //

        }

    }

    //called when user presses new game
    public void newGame(View view) {
        current_guess = 0;
    }

    public void displayPicture(View view, int num) {

        if(num ==1) {
            //you win
        } else {
            //you lose
        }
    }

}
