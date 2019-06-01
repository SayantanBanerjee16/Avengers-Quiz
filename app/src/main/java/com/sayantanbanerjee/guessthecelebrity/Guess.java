package com.sayantanbanerjee.guessthecelebrity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Guess extends AppCompatActivity {

    ArrayList<String> imaged = new ArrayList();
    ArrayList<String> named = new ArrayList();
    ArrayList<String> name2d = new ArrayList();
    ArrayList<String> name3d = new ArrayList();
    ArrayList<String> nametemp = new ArrayList();
    ArrayList<Integer> used = new ArrayList();


    RadioGroup radio;
    String playerName;
    ImageView imageView;
    EditText editText;
    TextView textView;
    boolean checked;
    int Button = -1;
    boolean flagDOWN = true;
    int temp = 0;
    int fina = -2;
    int counter = 0;
    int correct = 0;
    Button button;

    public void abc(){

    }

    public int Rand1() {
        Random rand = new Random();
        int a = rand.nextInt(13);
        return a;
    }

    public int Rand2() {
        Random rand = new Random();
        int a = rand.nextInt(13) + 13;
        return a;
    }

    public int Rand3() {
        Random rand = new Random();
        int a = rand.nextInt(13) + 26;
        return a;
    }


    public int RandQue() {
        Random rand = new Random();
        int a = rand.nextInt(3);
        return a;
    }

    public void radioButtonCheck(View view) {

        checked = true;
        switch (view.getId()) {


            case R.id.radioButton:
                Button = 0;

                break;

            case R.id.radioButton2:

                Button = 1;
                break;

            case R.id.radioButton3:

                Button = 2;
                break;

            case R.id.radioButton4:

                Button = 3;
                break;
        }


    }

    public void addition() {

        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Robert_Downey%2C_Jr._SDCC_2014_%28cropped%29.jpg/220px-Robert_Downey%2C_Jr._SDCC_2014_%28cropped%29.jpg");
        named.add("Robert Downey Jr.");
        name2d.add("Tony Stark");
        name3d.add("Iron Man");


        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Chris_Evans_SDCC_2014.jpg/220px-Chris_Evans_SDCC_2014.jpg");
        named.add("Chris Evans");
        name2d.add("Steve Rogers");
        name3d.add("Captain America");


        imaged.add("https://i.pinimg.com/originals/10/77/af/1077af4642ed60747ae2691c3e7a64ca.jpg");
        named.add("Chris Hemsworth");
        name2d.add("Thor Odinson");
        name3d.add("God of Thunder");


        imaged.add("https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTE4MDAzNDEwNzkxOTI1MjYy/scarlett-johansson-13671719-1-402.jpg");
        named.add("Scarlett Johansson");
        name2d.add("Natasha Romanoff");
        name3d.add("Black Widow");


        imaged.add("https://m.media-amazon.com/images/M/MV5BOTk2NDc2ODgzMF5BMl5BanBnXkFtZTcwMTMzOTQ4Nw@@._V1_UX214_CR0,0,214,317_AL_.jpg");
        named.add("Jeremy Renner");
        name2d.add("Clint Barton");
        name3d.add("Hawkeye");


        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Mark_Ruffalo_in_2017_by_Gage_Skidmore.jpg/220px-Mark_Ruffalo_in_2017_by_Gage_Skidmore.jpg");
        named.add("Mark Ruffalo");
        name2d.add("Bruce Banner");
        name3d.add("Hulk");

        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Benedict_Cumberbatch_by_Gage_Skidmore.jpg/220px-Benedict_Cumberbatch_by_Gage_Skidmore.jpg");
        named.add("Benedict Cumberbatch");
        name2d.add("Dr. Stephen Strange");
        name3d.add("Doctor Strange");


        imaged.add("https://www.aceshowbiz.com/images/wennpic/preview/anthony-mackie-premiere-black-or-white-01.jpg");
        named.add("Anthony Mackie");
        name2d.add("Sam Wilson");
        name3d.add("Falcon");


        imaged.add("https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTU0ODc4NDQ5OTM5MzkyMTkz/gettyimages-931925994-square.jpg");
        named.add("Chadwick Boseman");
        name2d.add("King T'Chala");
        name3d.add("Black Panther");


        imaged.add("https://www.famousbirthdays.com/headshots/sebastian-stan-9.jpg");
        named.add("Sebastian Stan");
        name2d.add("Bucky Barnes");
        name3d.add("Winter Soldier");


        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Captain_Marvel_trailer_at_the_National_Air_and_Space_Museum_2_%28cropped%29.jpg/220px-Captain_Marvel_trailer_at_the_National_Air_and_Space_Museum_2_%28cropped%29.jpg");
        named.add("Brie Larson");
        name2d.add("Carol Danvers");
        name3d.add("Captain Marvel");


        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/10/Elizabeth_Olsen_SDCC_2014_2_%28cropped%29.jpg/220px-Elizabeth_Olsen_SDCC_2014_2_%28cropped%29.jpg");
        named.add("Elizabeth Olsen");
        name2d.add("Wanda Maximoff");
        name3d.add("Scarlett Witch");

        imaged.add("https://www.famousbirthdays.com/faces/russo-rene-image.jpg");
        named.add("Rene Russo");
        name2d.add("Frigga");
        name3d.add("Queen of Asgard");

        imaged.add("https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTQ4MTUwOTQyMDE1OTU2Nzk4/tom-holland-photo-jason-kempin-getty-images-801510482-profile.jpg");
        named.add("Tom Holland");
        name2d.add("Peter Parker");
        name3d.add("Spiderman");

        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Tom_Hiddleston_%2827992938324%29_%28cropped%29.jpg/220px-Tom_Hiddleston_%2827992938324%29_%28cropped%29.jpg");
        named.add("Tom Hiddleston");
        name2d.add("Loki");
        name3d.add("God of Mischief");

        imaged.add("https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTQxMDA4Nzk5MDIzNTA2NjE1/chris--pratt-gettyimages-452625304_1350jpg.jpg");
        named.add("Chris Pratt");
        name2d.add("Peter Quill");
        name3d.add("Star Lord");

        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/VinDieselMarch09.jpg/220px-VinDieselMarch09.jpg");
        named.add("Vin Deisel");
        name2d.add("Groot");
        name3d.add("Tree");

        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Zoe_Saldana_by_Gage_Skidmore_2.jpg/220px-Zoe_Saldana_by_Gage_Skidmore_2.jpg");
        named.add("Zoe Saldana");
        name2d.add("Gamora");
        name3d.add("Thanos Adopted Daughter");

        imaged.add("http://2.bp.blogspot.com/-vpUB2YAnZU4/VlWXrea2MLI/AAAAAAAAAEg/xrse6V2injg/s320/Nick.jpg");
        named.add("Samuel L Jackson");
        name2d.add("Nick Fury");
        name3d.add("Director of S.H.I.E.L.D.");

        imaged.add("https://i.pinimg.com/originals/d2/10/bc/d210bc78e422d4477b00b94ca5261f83.jpg");
        named.add("Cobie Smulders");
        name2d.add("Maria Hill");
        name3d.add("Agent of S.H.I.E.L.D.");

        imaged.add("https://pixel.nymag.com/imgs/daily/vulture/2016/04/11/11-tessa-thompson.w330.h330.jpg");
        named.add("Tessa Thompson");
        name2d.add("Brunnhilde");
        name3d.add("Valkyrie");

        imaged.add("https://i.redd.it/pnyt4x0v29pz.png");
        named.add("Don Cheadle");
        name2d.add("James Rupert Rhodes");
        name3d.add("War Machine");

        imaged.add("https://66.media.tumblr.com/aa6bc4da874e75170829c2751c92ecd7/tumblr_p93oja0S7i1wr1mryo5_250.png");
        named.add("Paul Rudd");
        name2d.add("Scott Lang");
        name3d.add("Ant Man");


        imaged.add("https://www.famousbirthdays.com/headshots/karen-gillan-1.jpg");
        named.add("Karen Gillian");
        name2d.add("Nebula");
        name3d.add("Adopted daughter of Thanos");

        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/GwynethPaltrowByAndreaRaffin2011.jpg/220px-GwynethPaltrowByAndreaRaffin2011.jpg");
        named.add("Gwyneth Paltrow");
        name2d.add("Pepper Potts");
        name3d.add("Tony Stark's Wife");

        imaged.add("https://ficquotes.com/images/characters/jane-foster.jpg");
        named.add("Natalie Portman");
        name2d.add("Jane Foster");
        name3d.add("Love Interest of Thor");

        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Cate_Blanchett_2011.jpg/191px-Cate_Blanchett_2011.jpg");
        named.add("Cate Blanchett");
        name2d.add("Hela");
        name3d.add("Goddess of Death");

        imaged.add("https://pixel.nymag.com/imgs/daily/vulture/2018/06/20/20-josh-brolin.w330.h330.jpg");
        named.add("Josh Brolin");
        name2d.add("Thanos");
        name3d.add("Mad Titan");

        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Glasto17-44_%2835547413626%29_Cropped.jpg/220px-Glasto17-44_%2835547413626%29_Cropped.jpg");
        named.add("Bradley Cooper");
        name2d.add("Rocket");
        name3d.add("Racoon");

        imaged.add("https://notednames.com/ImgProfile/a@@h_Evangeline%20Lilly.jpg");
        named.add("Evangeline Lilly");
        name2d.add("Hope Pym");
        name3d.add("Mother of Wasp");

        imaged.add("https://frostsnow.com//uploads/biography/2018/04/04/ty-simpkins.jpg");
        named.add("Ty Simpkins");
        name2d.add("Harley");
        name3d.add("Kid from Iron Man 3");

        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Jon_Favreau_2016.jpeg/220px-Jon_Favreau_2016.jpeg");
        named.add("Jon Favreau");
        name2d.add("Happy Hogan");
        name3d.add("Tony Stark bodyguard & chauffeur");

        imaged.add("https://m.media-amazon.com/images/M/MV5BMTUzNjI0Njc5NF5BMl5BanBnXkFtZTYwOTM2MjYz._V1_UX214_CR0,0,214,317_AL_.jpg");
        named.add("Michelle Pfeiffer");
        name2d.add("Janet van Dyne");
        name3d.add("Wasp");

        imaged.add("https://pixel.nymag.com/imgs/daily/vulture/2019/02/08/08-danai-gurira.w330.h330.jpg");
        named.add("Danai Gurira");
        name2d.add("Okoye");
        name3d.add("Member of the Dora Milaje");

        imaged.add("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Benedict_Wong_by_Gage_Skidmore.jpg/266px-Benedict_Wong_by_Gage_Skidmore.jpg");
        named.add("Benedict Wong");
        name2d.add("Wong");
        name3d.add("Chinese Monk of Kamar-Taj");

        imaged.add("https://images3.static-bluray.com/products/22/25133_1_front.jpg");
        named.add("Emma Fuhrmann");
        name2d.add("Cassie Lang");
        name3d.add("Daughter of Ant Man");

        imaged.add("https://m.media-amazon.com/images/M/MV5BMjI4NjQ5NDA5M15BMl5BanBnXkFtZTgwNDE0MjQzMjE@._V1_UY317_CR142,0,214,317_AL_.jpg");
        named.add("Dave Bautista");
        name2d.add("Arthur Douglas");
        name3d.add("Drax The Destroyer");

        imaged.add("https://m.media-amazon.com/images/M/MV5BMzc5ZjRhNTItMTM5MS00ZDIxLTk4MzYtYzZkZDBhMjE1ZjMwXkEyXkFqcGdeQXVyNTEwNTA1Njg@._V1_UY317_CR79,0,214,317_AL_.jpg");
        named.add("Winston Duke");
        name2d.add("M'Baku");
        name3d.add("Leader of Jabari Tribe");

        imaged.add("https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTU2MDExMzA1MDA4ODk5ODI0/gettyimages-9179665520-cropped.jpg");
        named.add("Letitia Wright");
        name2d.add("Shuri");
        name3d.add("Sister of Black Panther");


        //upto 39


    }

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                flagDOWN = true;
                checked = false;
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

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            flagDOWN = false;
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

    public void setup(int k) {
        int num1, num2, num3;
        String var = "";
        setImage(k);

        int textnum = RandQue();

        do {
            num1 = Rand1();
        } while (num1 == k);
        do {
            num2 = Rand2();
        } while (num2 == k);
        do {
            num3 = Rand3();
        } while (num3 == k);


        if (textnum == 0) {
            textView.setText("Name of this actor/actress?");
            var = named.get(k);
            nametemp.add(named.get(k));
            nametemp.add(named.get(num1));
            nametemp.add(named.get(num2));
            nametemp.add(named.get(num3));
        } else if (textnum == 1) {
            textView.setText("Name of the character this actor/actress plays?");
            var = name2d.get(k);
            nametemp.add(name2d.get(k));
            nametemp.add(name2d.get(num1));
            nametemp.add(name2d.get(num2));
            nametemp.add(name2d.get(num3));
        } else if (textnum == 2) {
            textView.setText("This actor/actress known for the Marvel character?");
            var = name3d.get(k);
            nametemp.add(name3d.get(k));
            nametemp.add(name3d.get(num1));
            nametemp.add(name3d.get(num2));
            nametemp.add(name3d.get(num3));
        }

        Collections.shuffle(nametemp);

        for (int i = 0; i < 4; i++) {
            if ((nametemp.get(i)).equals(var)) {
                fina = i;
                break;
            }
        }

        RadioButton button = (RadioButton) findViewById(R.id.radioButton);
        button.setText(nametemp.get(0));
        RadioButton button2 = (RadioButton) findViewById(R.id.radioButton2);
        button2.setText(nametemp.get(1));
        RadioButton button3 = (RadioButton) findViewById(R.id.radioButton3);
        button3.setText(nametemp.get(2));
        RadioButton button4 = (RadioButton) findViewById(R.id.radioButton4);
        button4.setText(nametemp.get(3));

        nametemp.clear();
    }

    public boolean check(int n){
        boolean a = false;
        for (Integer i : used)
        {
            if(i == n){
                a = true;
            }
        }
        return a;
    }

    public void refresh(View view) {

        if (flagDOWN == false) {
            if (checked == false) {
                Toast.makeText(this, "First Select a Button", Toast.LENGTH_SHORT).show();
            } else {

                if (Button == fina) {
                    Toast.makeText(this, "RIGHT", Toast.LENGTH_SHORT).show();
                    correct++;
                } else {
                    Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
                }



                if(counter != 10)
                {
                    counter++;
                }

                if(counter == 9)
                {
                     button.setText("FINISH");
                }


                if(counter == 10)
                {
                    abc();
                    Intent intent = new Intent(this, Winner.class);
                    intent.putExtra("playerName", playerName);
                    intent.putExtra("correct", correct);
                    startActivity(intent);
                    this.finish();
                }
                else
                {
                    radio.clearCheck();
                    Button = -1;
                    fina = -2;
                    int n;
                    do {
                        Random rand = new Random();
                        n = rand.nextInt(named.size());
                    } while (check(n));
                    temp = n;
                    used.add(n);
                    setup(n);
                }

            }

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        used.clear();
        Intent startingIntent = getIntent();
        playerName = startingIntent.getStringExtra("message");
        counter = 0;
        correct = 0;
        getSupportActionBar().hide();
        addition();
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView2);
        radio = (RadioGroup) findViewById(R.id.radioGroup);
        Random rand = new Random();
        int n = rand.nextInt(named.size());
        temp = n;
        used.add(temp);
        setup(n);

    }
}
