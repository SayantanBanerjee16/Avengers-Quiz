package com.sayantanbanerjee.guessthecelebrity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Guess extends AppCompatActivity {

    public void check(View view){

    }

    public void refresh(View view){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        getSupportActionBar().hide();
    }
}
