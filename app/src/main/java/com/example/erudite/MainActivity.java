package com.example.erudite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    // references to buttons and other controls on the layout
    String st_name, st_abc123, st_courses, true_eruID; //should be changed to variable
    String species, nickname;
    int m_xp, m_lvl;

    private AppBarConfiguration mAppBarConfiguration;
    private ProgressBar mProgressBar;

    // create object for databases
    DataBaseHelperStudent dataBaseHelperStudent;
    DataBaseHelperMonster dataBaseHelperMonster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_info, R.id.nav_profile)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
/*
        Erugon myErugon = new Erugon("Bud");
        setProgressBar(myErugon);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar3);
        mProgressBar.setMax(myErugon.getXpMax());
        myErugon.setXp(2);
        mProgressBar.setProgress(myErugon.getXp());
*/

        // STUDENT TABLE
        dataBaseHelperStudent = new DataBaseHelperStudent(MainActivity.this);
        StudentModel studentModel;
        try {
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Beth", "hrx876", "cs2312, cs3425", "adorb123"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Vanessa", "acb345", "cs4567", "sixx897"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Theresa", "ids345", "cs2323", "other234"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Jason", "mbd094", "cs4421, cs3213, cs2453", "samp456"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Chris", "fdg234", "cs2345, cs7423, cs2345", "sdf234"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Anna", "sdf234", "mat3242, cs5634", "adorb123"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Tommy", "dfg456", "cs3462", "sixx897"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Claudia", "rty678", "cs2134", "other234"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "Zabdi", "xcz789", "sci4356, bs2341, mat1234", "samp456"));
            dataBaseHelperStudent.addStudent(new StudentModel(1, "John", "iuy724", "cs2345, cs7423, cs2345", "sdf234"));
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
            dataBaseHelperMonster.addMonster(new MonsterModel(1, "Erugon", "Cutie", 10, 1, "adorb123"));
            dataBaseHelperMonster.addMonster(new MonsterModel(1, "Psilobite", "Mushy", 1, 50, "sixx897"));
            dataBaseHelperMonster.addMonster(new MonsterModel(1, "Psilobite", "Bloop", 200, 100, "other234"));
            dataBaseHelperMonster.addMonster(new MonsterModel(1, "Erugon", "Eru", 500, 20, "samp456"));
            dataBaseHelperMonster.addMonster(new MonsterModel(1, "Erugon", "Drago", 75, 4, "sdf234"));
            dataBaseHelperMonster.addMonster(new MonsterModel(1, "Psilobite", "Puppy", 10, 1, "sdf235"));
            dataBaseHelperMonster.addMonster(new MonsterModel(1, "Psilobite", "Toothless", 1, 50, "dfg645"));
            dataBaseHelperMonster.addMonster(new MonsterModel(1, "Psilobite", "Apple", 200, 100, "fgf976"));
            dataBaseHelperMonster.addMonster(new MonsterModel(1, "Erugon", "Cookie", 500, 20, "hfg234"));
            dataBaseHelperMonster.addMonster(new MonsterModel(1, "Erugon", "Normi", 75, 4, "jfg765"));
            //monsterModel = new MonsterModel(-1, species, nickname, -1, -1, true_eruID);
            //Toast.makeText( MainActivity.this, monsterModel.toString() , Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            monsterModel = new MonsterModel(-1, "specie", "nickname", -1 , -1, "eru name");
            Toast.makeText( MainActivity.this, "Error creating monster", Toast.LENGTH_SHORT).show();
        }
        //Toast.makeText( MainActivity.this, monsterModel.toString() , Toast.LENGTH_SHORT).show();
        DataBaseHelperMonster dataBaseHelperMonster = new DataBaseHelperMonster(MainActivity.this);
    }

    public void setProgressBar(Erugon myErugon) {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar3);
        mProgressBar.setMax(myErugon.getXpMax());
        myErugon.setXp(2);
        mProgressBar.setProgress(myErugon.getXp());
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}