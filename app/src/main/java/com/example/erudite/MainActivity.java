package com.example.erudite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button menuBtn;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Erugon myErugon = new Erugon("Bud");
        setProgressBar(myErugon);






    }

    public void openMenu() {
        //Intent intent = new Intent(this, menu)
    }

    public void setProgressBar(Erugon myErugon) {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar3);
        mProgressBar.setMax(myErugon.getXpMax());
        myErugon.setXp(2);
        mProgressBar.setProgress(myErugon.getXp());
    }
}