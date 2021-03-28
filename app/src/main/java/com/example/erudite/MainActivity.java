package com.example.erudite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // references to buttons and other controls on the layout
    String st_name, st_abc123, st_courses, true_eruID; //should be changed to variable
    String species, nickname;
    int m_xp, m_lvl;

    private Button menuBtn;
    private ProgressBar mProgressBar;

    // create object for databases
    DataBaseHelperStudent dataBaseHelperStudent;
    DataBaseHelperMonster dataBaseHelperMonster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Erugon myErugon = new Erugon("Bud");
        setProgressBar(myErugon);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar3);
        mProgressBar.setMax(myErugon.getXpMax());
        myErugon.setXp(2);
        mProgressBar.setProgress(myErugon.getXp());

        // STUDENT TABLE
        dataBaseHelperStudent = new DataBaseHelperStudent(MainActivity.this);
        StudentModel studentModel;
        try {
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Beth", "hrx876", "cs2312, cs3425", "adorb123"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Vanessa", "acb345", "cs4567", "sixx897"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Theresa", "ids345", "cs2323", "other234"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Jason", "mbd094", "cs4421, cs3213, cs2453", "samp456"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Chris", "fdg234", "cs2345, cs7423, cs2345", "sdf234"));
            //studentModel = new StudentModel(-1, st_name, st_abc123, st_courses, true_eruID);
            //Toast.makeText( MainActivity.this, studentModel.toString() , Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            studentModel = new StudentModel(-1, "error", "abc123", "course", "eru name");
            Toast.makeText( MainActivity.this, "Error creating student", Toast.LENGTH_SHORT).show();
        }
        DataBaseHelperStudent dataBaseHelperStudent = new DataBaseHelperStudent(MainActivity.this);

        // MONSTER TABLE
        dataBaseHelperMonster = new DataBaseHelperMonster(MainActivity.this);
        MonsterModel monsterModel = new MonsterModel();
        try {
            //populate some data
            dataBaseHelperMonster.addMonster(new MonsterModel(1, "dragon", "Cutie", 10, 1, "adorb123"));
            dataBaseHelperMonster.addMonster(new MonsterModel(2, "mushroom", "Mushy", 1, 50, "sixx897"));
            dataBaseHelperMonster.addMonster(new MonsterModel(3, "mushroom", "Bloop", 200, 100, "other234"));
            dataBaseHelperMonster.addMonster(new MonsterModel(4, "dragon", "Eru", 500, 20, "samp456"));
            dataBaseHelperMonster.addMonster(new MonsterModel(5, "dragon", "Drago", 75, 4, "sdf234"));
            //monsterModel = new MonsterModel(-1, species, nickname, -1, -1, true_eruID);
            //Toast.makeText( MainActivity.this, monsterModel.toString() , Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            monsterModel = new MonsterModel(-1, "specie", "nickname", -1 , -1, "eru name");
            Toast.makeText( MainActivity.this, "Error creating monster", Toast.LENGTH_SHORT).show();
        }
        //Toast.makeText( MainActivity.this, monsterModel.toString() , Toast.LENGTH_SHORT).show();
        DataBaseHelperMonster dataBaseHelperMonster = new DataBaseHelperMonster(MainActivity.this);
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