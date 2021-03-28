package com.example.erudite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.TextView;
import android.os.Handler;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher;
import java.lang.Math;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    // references to buttons and other controls on the layout
    String st_name, st_abc123, st_courses, true_eruID; //should be changed to variable
    String species, nickname;
    int m_xp, m_lvl;

    private AppBarConfiguration mAppBarConfiguration;

    //Jason Stuff
    private Button mLevelup;
    private ProgressBar mProgressBar;
    private Handler mHandler = new Handler();
    private TextSwitcher mLevelSwitch;
    private int stringIndex = 0;
    private String[] row = {"Level: 1", "Level: 2", "Level: 3", "Level: 4", "Level: 5", "Level: 6", "Level: 7", "Level: 8", "Level: 9", "Level: 10"};
    private TextView mLevel;
    private Button mNavstuff;

    // create object for databases
    DataBaseHelperStudent dataBaseHelperStudent;
    DataBaseHelperMonster dataBaseHelperMonster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mLevelup = findViewById(R.id.levelup);

        mProgressBar = findViewById(R.id.progressBar3);
        mLevelSwitch = findViewById(R.id.textSwitcher);
        Erugon myErugon = new Erugon("Bud");

        /*
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
        NavigationUI.setupWithNavController(navigationView, navController);*/
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
        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
        boolean sucess = dataBaseHelper.addOne(studentModel);
    }



    public void setProgressBar(Erugon myErugon, TextSwitcher mLevelSwitch) {

        mProgressBar.setMax(myErugon.getXpMax());
        mProgressBar.setProgress(myErugon.getXp());

        int gainedxp;
        gainedxp = (int) Math.ceil(100/10);

        for(int i = 0; i < gainedxp; i++) {

            int startxp = myErugon.getXp();
            startxp++;
            System.out.println(startxp);
            myErugon.setXp(startxp);

            mProgressBar.setProgress(startxp);
            SystemClock.sleep(50);



            if(myErugon.getXpMax() == startxp) {
                myErugon.lvlup();
                mProgressBar.setProgress(0);
                mProgressBar.setMax(myErugon.getLvl()*5);

                if(myErugon.getLvl() != 10) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mLevelSwitch.setText(row[myErugon.getLvl()-1]);
                        }
                    });

                }

            }
        }

    }

    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}