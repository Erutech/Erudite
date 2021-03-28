package com.example.erudite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.erudite.ui.login.MonsterModel;

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
        this.dataBaseHelperStudent = new DataBaseHelperStudent(MainActivity.this);
        StudentModel studentModel;
        try {
            studentModel = new StudentModel(-1, st_name, st_abc123, st_courses, true_eruID);
            Toast.makeText( MainActivity.this, studentModel.toString() , Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            studentModel = new StudentModel(-1, "error", "abc123", "course", "eru name");
            Toast.makeText( MainActivity.this, "Error creating student", Toast.LENGTH_SHORT).show();
        }
        DataBaseHelperStudent dataBaseHelperStudent = new DataBaseHelperStudent(MainActivity.this);
        boolean sucess = dataBaseHelperStudent.addOne(studentModel);

        // MONSTER TABLE
        this.dataBaseHelperMonster= new DataBaseHelperMonster(MainActivity.this);
        MonsterModel monsterModel;
        try {
            monsterModel = new MonsterModel(-1, species, nickname, -1, -1, true_eruID);
            Toast.makeText( MainActivity.this, monsterModel.toString() , Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            monsterModel = new MonsterModel(-1, "specie", "nickname", -1 , -1, "eru name");
            Toast.makeText( MainActivity.this, "Error creating monster", Toast.LENGTH_SHORT).show();
        }
        DataBaseHelperMonster dataBaseHelperMonster = new DataBaseHelperMonster(MainActivity.this);
        sucess = dataBaseHelperMonster.addOne(monsterModel);
        
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