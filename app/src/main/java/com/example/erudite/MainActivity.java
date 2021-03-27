package com.example.erudite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button menuBtn;

    //private ProgressBar mProgressBar;
    //private int mProgressStatus = 0;
    //private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(mProgressStatus < maxXp)
            }
        })
        */

    }

    public void openMenu() {
        //Intent intent = new Intent(this, menu)
    }
}