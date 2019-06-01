package com.sayantanbanerjee.guessthecelebrity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    EditText edit;

    public void button(View view){

        if(edit.getText().toString().equals("")){
            Toast.makeText(this,"First Enter Your Name",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(this, Guess.class);
            intent.putExtra("message", edit.getText().toString());
            startActivity(intent);
            this.finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        getSupportActionBar().hide();
        edit = (EditText) findViewById(R.id.editText);
    }
}
