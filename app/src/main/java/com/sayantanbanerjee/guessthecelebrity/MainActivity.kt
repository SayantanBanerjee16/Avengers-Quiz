package com.sayantanbanerjee.guessthecelebrity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        Handler().postDelayed({

            val intent = Intent(this,Guess::class.java)
            startActivity(intent)
            this.finish()
        },1500);
    }
}
