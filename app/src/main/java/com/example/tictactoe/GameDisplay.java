package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playAgainBTN = findViewById(R.id.play_again_button);
        Button homeBTN = findViewById(R.id.home_button);
        TextView playerTurn = findViewById(R.id.player_display);
        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        // hide "home" and "play again" buttons during game
        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);


        //initiate the first player turn
        if (playerNames!=null){
            playerTurn.setText((playerNames[0]+"'s Turn"));
            int newColor = Color.parseColor("#0091EA"); // Replace with your desired color code
            playerTurn.setTextColor(newColor);
            //playerTurn.setText(getColoredString(playerNames[0],"playerNames[0](0)",Color.RED));;

        }

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);
        ticTacToeBoard.setUpGame(playAgainBTN,homeBTN,playerTurn,playerNames);

    }




    public void playAgainButtonClick(View view){
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }

    public void homeButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}