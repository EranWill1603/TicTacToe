package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class GameLogic {
    private int [][] gameBoard;

    private Button playAgainBTN;
    private Button homeBTN;
    private TextView playerTurn;

    private String[] playerNames = {"player 1","player 2"};
    private int player = 1;

    //1st element --> row, 2nd element --> col, 3rd element --> line type
    private int[] winType = new int [3];


    GameLogic(){
        gameBoard = new int [3][3];
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                gameBoard[r][c] = 0;
            }
        }
    }


    @SuppressLint("SetTextI18n")
    public boolean updateGameBoard(int row, int col){
        if(gameBoard[row-1][col-1]==0){
            gameBoard[row-1][col-1]=player;

            if(player==1){
                playerTurn.setText((playerNames[1]+"'s Turn"));

                // Set the background color programmatically

                int newColor = Color.parseColor("#00C853"); // Replace with your desired color code
                playerTurn.setTextColor(newColor);
            }
            else{
                playerTurn.setText((playerNames[0]+"'s Turn"));

                int newColor = Color.parseColor("#0091EA"); // Replace with your desired color code
                playerTurn.setTextColor(newColor);
            }

            return true;
        }
        else{
            return false;
        }
    }


    public void resetGame(){
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                gameBoard[r][c] = 0;
            }
        }
        // updated player 1 to start a reset game
        player = 1;
        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        playerTurn.setText(playerNames[0]+"'s Turn");
        int newColor = Color.parseColor("#0091EA"); // Replace with your desired color code
        playerTurn.setTextColor(newColor);
    }


    public boolean winnerCheck(){
        boolean isWinner = false;

        int newColor;// Replace with your desired color code

        // Horizontal check (winType==1)
        for(int r=0; r<3;r++){
            if(gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] && gameBoard[r][0] != 0){
                winType = new int[] {r,0,1};
                isWinner = true;

            }
        }
        // Vertical check (winType==2)
        for(int c=0; c<3;c++){
            if(gameBoard[0][c] == gameBoard[1][c] && gameBoard[0][c] == gameBoard[2][c] && gameBoard[0][c] != 0){
                winType = new int[] {0,c,2};
                isWinner = true;
            }
        }
        // Diagonal negative check (winType==3)
        for(int d=0; d<1 ;d++){
            if(gameBoard[d][d] == gameBoard[d+1][d+1] && gameBoard[d][d] == gameBoard[d+2][d+2] && gameBoard[d][d] != 0){
                winType = new int[] {0,2,3};
                isWinner = true;
            }
        }
        // Diagonal positive check (winType==4)
        for(int r=2; r>1;r--){
            if(gameBoard[0][r] == gameBoard[r-1][r-1] && gameBoard[0][r] == gameBoard[r][0] && gameBoard[0][r] != 0){
                winType = new int[] {2,2,4};
                isWinner = true;
            }
        }

        //checks how many spaces are filled in
        int boardFilled = 0;
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                if(gameBoard[r][c]!=0)
                    boardFilled++;
            }
        }

        if(isWinner){
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player-1]+"'s Won!"));

            if (player == 1) {
                newColor = Color.parseColor("#0091EA");
            }
            else {
                newColor = Color.parseColor("#00C853");
            }
            playerTurn.setTextColor(newColor);

            return true;
        }
        else if (boardFilled==9) {
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText(("Tie Game!"));
            newColor = Color.parseColor("#FF0000");
            playerTurn.setTextColor(newColor);
            return false;
        }
        else{
            return false;
        }

    }


    public void setPlayAgainBTN(Button playAgainBTN){
        this.playAgainBTN=playAgainBTN;
    }

    public void setHomeBTN(Button homeBTN) {
        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }


    public int[][] getGameBoard(){
        return gameBoard;
    }
    public void setPlayer(int player){
        this.player=player;
    }

    public int getPlayer(){
        return player;
    }

    public int[] getWinType() {
        return winType;
    }
}
