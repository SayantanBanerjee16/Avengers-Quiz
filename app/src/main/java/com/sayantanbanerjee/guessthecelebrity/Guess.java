package com.sayantanbanerjee.guessthecelebrity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Guess extends AppCompatActivity {

    public void check(View view){

    }

    public void refresh(View view){

    }

    public class DownloadTask extends AsyncTask<String , Void , String>{

        @Override
        protected String doInBackground(String... string) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try{
                url  = new URL(string[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while(data != -1)
                {
                    char current = (char) data;
                    result+=current;
                    data = reader.read();
                }
                return  result;
            }catch(Exception e){
                e.printStackTrace();
                return "FAILED";
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        getSupportActionBar().hide();

        DownloadTask task = new DownloadTask();
        String result = null;

        try {
            result = task.execute("https://www.imdb.com/list/ls022546765/").get();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        Log.i("Result : ", result);

    }
}
