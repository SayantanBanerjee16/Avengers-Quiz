package com.sayantanbanerjee.guessthecelebrity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Guess extends AppCompatActivity {

    ArrayList<String> imaged = new ArrayList();
    ArrayList<String> named = new ArrayList();

    ImageView imageView;
    EditText editText;
    int temp = 0;

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream in = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(in);
                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }


    public void setImage(int a) {
        ImageDownloader task = new ImageDownloader();
        Bitmap myImage;

        try {

            String abc = imaged.get(a);
            myImage = task.execute(abc).get();
            imageView.setImageBitmap(myImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void check(View view) {
        try {

            String namee = named.get(temp);
            if((editText.getText().toString()).equals(""))
            {
                Toast.makeText(this, "Type the name in Name Bar", Toast.LENGTH_SHORT).show();
            }
            else{
                if ((editText.getText().toString()).equalsIgnoreCase(namee))
                {
                    Toast.makeText(this, "YUPP, You are right!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "Nope. Correct answer: " + namee, Toast.LENGTH_LONG).show();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void refresh(View view) {
        int n;
        do {
            Random rand = new Random();
            n = rand.nextInt(named.size());
        }while( n==temp);
        temp = n;
        setImage(n);
    }

    public void pattern(String name) {
      //  Pattern p = Pattern.compile("<img src=\"(.*?)\" alt");
        Pattern p = Pattern.compile("<img src=\"(.*?)\" data-src-x2");
        Matcher m = p.matcher(name);

        while (m.find()) {
            imaged.add(m.group(1));
        }

       // Pattern p2 = Pattern.compile("alt=\"(.*?)\"/>");
        Pattern p2 = Pattern.compile("<div class=\"media-body media-vertical-align\">\n" + "<h4>(.*?)</h4>");
        Matcher m2 = p2.matcher(name);

        while (m2.find()) {
            named.add(m2.group(1));
        }

    }

    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... string) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(string[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;
            } catch (Exception e) {
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

        editText = (EditText) findViewById(R.id.editText);

        imageView = (ImageView) findViewById(R.id.imageView2);

        try {
            result = task.execute("https://m.imdb.com/title/tt4154796/fullcredits/cast").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        pattern(result);
        setImage(0);
        Log.i("Result : ", result);

    }
}
