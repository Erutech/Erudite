package com.example.erudite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // references to buttons and other controls on the layout
    Button button_viewALL = findViewById(R.id.viewDB);
    String true_name, true_abc123, true_courses, true_eruID; //should be changed to variable
    ListView lv_studentList;

    private Button menuBtn;
    private ProgressBar mProgressBar;

    ArrayAdapter studentArrayAdapter;
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
        ShowDataBaseOnListView(dataBaseHelper);

        StudentModel studentModel;
        try {
            studentModel = new StudentModel(-1, true_name, true_abc123, true_courses, true_eruID);
        } catch (Exception e) {
            studentModel = new StudentModel(-1, "error", "abc123", "course", "eru name");
        }
        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
        boolean sucess = dataBaseHelper.addOne(studentModel);
        ShowDataBaseOnListView(dataBaseHelper);

        button_viewALL.setOnClickListener((v) -> {
            DataBaseHelper dataBaseHelper1 = new DataBaseHelper(MainActivity.this);
            ShowDataBaseOnListView(dataBaseHelper1);
        });
    }

    public void openMenu() {
        //Intent intent = new Intent(this, menu)
    }

    private void ShowDataBaseOnListView(DataBaseHelper dataBaseHelper){
        studentArrayAdapter = new ArrayAdapter<StudentModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEverything());
        lv_studentList.setAdapter(studentArrayAdapter);
    }


    /** Called when the user taps the profile card button */
    public void saveToDatabase(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }
}