package com.example.erudite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // references to buttons and other controls on the layout
    String true_name, true_abc123, true_courses, true_eruID; //should be changed to variable

    private Button menuBtn;
    private ProgressBar mProgressBar;

    // create object for database
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Erugon myErugon = new Erugon("Bud");

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar3);
        mProgressBar.setMax(myErugon.getXpMax());
        myErugon.setXp(2);
        mProgressBar.setProgress(myErugon.getXp());

        dataBaseHelper = new DataBaseHelper(MainActivity.this);
        StudentModel studentModel;
        try {
            studentModel = new StudentModel(-1, true_name, true_abc123, true_courses, true_eruID);
            Toast.makeText( MainActivity.this, studentModel.toString() , Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            studentModel = new StudentModel(-1, "error", "abc123", "course", "eru name");
            Toast.makeText( MainActivity.this, "Error creating student", Toast.LENGTH_SHORT).show();
        }
        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
        boolean sucess = dataBaseHelper.addOne(studentModel);
    }
    public void openMenu() {
        //Intent intent = new Intent(this, menu)
    }
}