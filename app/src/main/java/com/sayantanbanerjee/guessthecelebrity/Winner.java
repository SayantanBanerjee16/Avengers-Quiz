package com.sayantanbanerjee.guessthecelebrity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Winner extends AppCompatActivity {

    String playerName,player;

    int Winner;
    TextView text;

    public void player2(){
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
        this.finish();
    }

    public void  button(View view){
        new CountDownTimer(1000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                player2();
            }
        }.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        getSupportActionBar().hide();
        Intent startingIntent = getIntent();
        playerName = startingIntent.getStringExtra("playerName");
        Winner = startingIntent.getIntExtra("correct",0);
        text = (TextView) findViewById(R.id.textView4);

        player = playerName.toUpperCase();

        if(player.length()< 25){
            text.setText(player + "\n scored \n" + Winner + " correct out of 10.");    
        }
        else
        {
            player = player.substring(0, 25);
            player += "...";
            text.setText(player + "\n scored \n" + Winner + " correct out of 10.");
            
        }
        text.animate().alpha(1f).setDuration(1000);
    }
}
