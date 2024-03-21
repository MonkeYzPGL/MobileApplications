package com.example.application3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView card_right, card_left;
    TextView score_left, score_right;
    Button turn,reset;
    Random r;
    int raz = 0;
    int score1, score2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card_right = (ImageView) findViewById(R.id.iv_card_right);
        card_left = (ImageView) findViewById(R.id.iv_card_left);
        score_left = (TextView) findViewById(R.id.score_left);
        score_right = (TextView) findViewById(R.id.score_right);
        turn = (Button) findViewById(R.id.turn);
        reset = (Button) findViewById(R.id.reset);

        turn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r = new Random();
                //generam cele 2 carti
                int a = r.nextInt(13) + 2;
                int b = r.nextInt(13) + 2;

                //afișăm imaginea cu cărțiile
                int leftImg = getResources().getIdentifier("card" + a, "drawable",getPackageName());
                card_left.setImageResource(leftImg);

                int rightImg = getResources().getIdentifier("card" + b, "drawable",getPackageName());
                card_right.setImageResource(rightImg);

                //comparăm numerele
                if(a > b){
                    if(raz == 0){
                        score1++;
                    } else {
                        raz = 0;
                        score1 = score1 + 2;
                    }
                    score_left.setText(String.valueOf(score1));
                }else if(a < b){
                    if(raz == 0){
                        score2++;
                    } else {
                        raz = 0;
                        score2 = score2 + 2;
                    }
                    score_right.setText(String.valueOf(score2));
                }else {
                    raz = 1;
                    Toast.makeText(MainActivity.this,"RĂZBOI",Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 = 0;
                score2 = 0;
                score_left.setText(String.valueOf(score1));
                score_right.setText(String.valueOf(score2));
                int x = getResources().getIdentifier("back","drawable",getPackageName());
                card_left.setImageResource(x);
                card_right.setImageResource(x);
            }
        });
    }
}