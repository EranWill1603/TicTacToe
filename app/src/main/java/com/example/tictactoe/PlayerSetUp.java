package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerSetUp extends AppCompatActivity {

    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_set_up);

        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);
    }

    private boolean validateFields() {
        int yourDesiredLength = 1;
        if (player1.getText().length() < yourDesiredLength) {
            player1.setError("Field cannot be left blank");
            return false;
        } else if (player2.getText().length() < yourDesiredLength) {
            player2.setError("Field cannot be left blank");
            return false;
        } else {
            return true;
        }
    }
    public void submitButtonClick(View view){
        String player1Name = player1.getText().toString();
        String player2Name = player2.getText().toString();
        if (validateFields()) {
            Intent intent = new Intent(this, GameDisplay.class);
            intent.putExtra("PLAYER_NAMES", new String[]{player1Name, player2Name});
            startActivity(intent);
        }
    }

}