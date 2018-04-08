package com.lifeistech.android.ken.tictactoe;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int[] PLAYER_IMAGES = {R.drawable.icon_batsu, R.drawable.icon_maru};
    public int turn;
    public int[] gameBoard;
    public ImageButton[] boardButtons;
    public TextView playerTextView;
    public TextView winnerTextView;

    public int[] buttonIds = {
            R.id.image_button_1,
            R.id.image_button_2,
            R.id.image_button_3,
            R.id.image_button_4,
            R.id.image_button_5,
            R.id.image_button_6,
            R.id.image_button_7,
            R.id.image_button_8,
            R.id.image_button_9,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerTextView = (TextView) findViewById(R.id.player_text);
        winnerTextView = (TextView) findViewById(R.id.winner_text);

        boardButtons = new ImageButton[9];
        for (int i = 0; i < boardButtons.length; i++) {
            boardButtons[i] = (ImageButton) findViewById(buttonIds[i]);
        }
        init();
        setPlayer();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id =item.getItemId();

        if(id == R.id.action_menu_reset){
            init();
            setPlayer();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void init() {
        turn = 1;
        gameBoard = new int[boardButtons.length];
        for (int i = 0; i < boardButtons.length; i++) {
            gameBoard[i] = -1;
            boardButtons[i].setImageBitmap(null);
            //TODO: null！？
        }
        winnerTextView.setVisibility(View.GONE);
    }

    public void setPlayer() {
        if (turn % 2 == 1) {
            playerTextView.setText("Player: 👑 (1)");
        } else {
            playerTextView.setText("Player ⭐ (2)");
        }
    }

    public void tapImageButton(View v) {
        if (winnerTextView.getVisibility() == View.VISIBLE) return;

        int tappedButtonPosition;
        int viewId = v.getId();

        //TODO:v？view？

        if (viewId == R.id.image_button_1) {
            tappedButtonPosition = 0;
        } else if (viewId == buttonIds[1]) {
            tappedButtonPosition = 1;
        } else if (viewId == buttonIds[2]) {
            tappedButtonPosition = 2;
        } else if (viewId == buttonIds[3]) {
            tappedButtonPosition = 3;
        } else if (viewId == buttonIds[4]) {
            tappedButtonPosition = 4;
        } else if (viewId == buttonIds[5]) {
            tappedButtonPosition = 5;
        } else if (viewId == buttonIds[6]) {
            tappedButtonPosition = 6;
        } else if (viewId == buttonIds[7]) {
            tappedButtonPosition = 7;
        } else {
            tappedButtonPosition = 8;
        }

        if (gameBoard[tappedButtonPosition] == -1) {
            boardButtons[tappedButtonPosition].setImageResource(PLAYER_IMAGES[turn % 2]);
            gameBoard[tappedButtonPosition] = turn % 2;

            int judge = judgeGame(v);
                //TODO:なぜかvにしたらいけた。
            if (judge != -1) {
                if (judge == 0) {
                    winnerTextView.setText("Game End\nPlayer: ⭐ (2)\nWon");
                    winnerTextView.setTextColor(Color.BLUE);
                } else {
                    winnerTextView.setText("Game End\nPlayer: 👑 (1)\nWon");
                    winnerTextView.setTextColor(Color.RED);
                }
                winnerTextView.setVisibility(View.VISIBLE);
            } else {
                if (turn >= gameBoard.length) {
                    winnerTextView.setText("Game End\nDraw");
                    winnerTextView.setTextColor(Color.YELLOW);
                    winnerTextView.setVisibility(View.VISIBLE);
                }
            }
            turn++;
            setPlayer();
        }
    }

    public int judgeGame(View v) {
        for (int i = 0; i < 3; i++) {
            if (isMarkedHorizontal(i)) {
                return gameBoard[i * 3];
            }
            if (isMarkedVertical(i)) {
                return gameBoard[i];
            }
        }
        if (isMarkedDiagonal()) {
            return gameBoard[4];
        }
        return -1;

        /*考えてみた結果。右のもの。if (gameBoard[tappedButtonPosition % 3 == 0] == 1 &&。で続けていく。mod的な考え方。){}*/
    }

    public boolean isMarkedHorizontal(int i) {
        if (gameBoard[i] != -1 && gameBoard[i * 3] == gameBoard[i * 3 + 1] && gameBoard[i * 3] == gameBoard[i * 3 + 2]) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMarkedVertical(int i) {
        if (gameBoard[i] != -1 && gameBoard[i] == gameBoard[i + 3] && gameBoard[i] == gameBoard[i + 6]) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMarkedDiagonal() {
        if (gameBoard[0] != -1 && gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8]) {
            return true;
        } else if (gameBoard[2] != -1 && gameBoard[2] == gameBoard[4] && gameBoard[2] == gameBoard[6]) {
            return true;
        } else {
            return false;
        }
    }


}
