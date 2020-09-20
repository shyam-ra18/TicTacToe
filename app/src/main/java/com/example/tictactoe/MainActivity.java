package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean gameactive = true;
    //0 - x
    //1 - O
    int activeplayer = 0;
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //0 = x
    //1 = O
    //2 = Null(blank)

    int[][] win_position ={{0,1,2},{3,4,5},{6,7,8},
                           {0,3,6},{1,4,7},{2,5,8},
                           {0,4,8},{2,4,6}};

    public void user_click(View view){
        ImageView img = (ImageView)view;
        int clickedimg = Integer.parseInt(img.getTag().toString());

        if(!gameactive){
            gamereset(view);
        }

        if(gamestate[clickedimg] == 2 ) {
            gamestate[clickedimg] = activeplayer;
            img.setTranslationY(-1000f);


            if (activeplayer == 0) {
                img.setImageResource(R.drawable.x);
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }


            img.animate().translationYBy(1000f).setDuration(400);
        }
        //check if any player won.
        for(int[] winposition: win_position){
         if(gamestate[winposition[0]] == gamestate[winposition[1]] &&
                 gamestate[winposition[1]] == gamestate[winposition[2]] &&
                 gamestate[winposition[0]] !=2){
             //sombody has won.
             String winnerstr;
             gameactive = false;
             if(gamestate[winposition[0]] == 0){
                //winnerstr = "X has won";
                winnerstr = "X has won";
             }else{
                 winnerstr = "O has won";
             }
             //update the status bar for winner
             TextView status = findViewById(R.id.status);
             status.setText(winnerstr);
         }

        }


        }
    public void gamereset(View view){
        gameactive = true;
        activeplayer = 0;

        for(int i=0; i<gamestate.length; i++){
            gamestate[i] = 2;

        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}