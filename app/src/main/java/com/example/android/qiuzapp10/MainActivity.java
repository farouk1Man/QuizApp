package com.example.android.qiuzapp10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Defining action when Start Button is Clicked
    public void startButtonClicked(View v)
    {
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}
