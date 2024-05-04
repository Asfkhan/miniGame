package com.myproject.newprac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive = true;

    int activeplayer = 0;
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winpositions = {{1,2,3},{4,5,6},{7,8,9},
            {1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};

       public void emptycell(View view){
           ImageView img = (ImageView) view;
           int tappedimage = Integer.parseInt(img.getTag().toString());
           if(!gameactive)
           {
               Clicktoreset(view);
           }

     if(gamestate[tappedimage]==2) {
               gamestate[tappedimage] = activeplayer;
               img.setTranslationY(-1000f);
               if(activeplayer == 0){
                   img.setImageResource(R.drawable.ax);
                   activeplayer = 1;
                   TextView status = findViewById(R.id.status);
                   status.setText("O's turn - Tap to play");
               }
               else{
                   img.setImageResource(R.drawable.zero);
                   activeplayer = 0;
                   TextView status = findViewById(R.id.status);
                   status.setText("X's turn - Tap to play");
               }
         img.animate().translationYBy(1000f).setDuration(300);
               }


            for(int[] disposition: winpositions){
                if(gamestate[disposition[0]] == gamestate[disposition[1]] &&
                        gamestate[disposition[1]] == gamestate[disposition[2]] && gamestate[disposition[0]] != 2)
                {
                    String winnerstr;
                    gameactive = false;
                    if(gamestate[disposition[0]] == 0){
                         winnerstr = "X WON";
                    }else {
                    winnerstr = "O WON";
                    }
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerstr);

                }




            }
       }

    public void Clicktoreset(View view){

           gameactive=true;
           activeplayer = 0;
            for(int i=0; i<gamestate.length;i++)
        {
            gamestate[i]=2;

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
        TextView status = findViewById(R.id.status);
        status.setText("X's turn - Tap to play");
       }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}