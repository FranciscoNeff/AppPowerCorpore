package com.nef.corgi.apppowercorpore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
private userDTO user=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("INICIO","Bienvenido a PowerCorpore");
        FragmentManager fm = getSupportFragmentManager();
        Fragment temp = fm.findFragmentById(R.id.main_container);
        if(temp==null) {
            FragmentTransaction ft = fm.beginTransaction();
            Autehtication fragment = Autehtication.newInstance("", "");
            ft.add(R.id.main_container, fragment, "login");
            ft.commit();
        } else
            Toast.makeText(this,getString(R.string.mainactivity_fragmentepresent), Toast.LENGTH_SHORT).show();

        if(savedInstanceState!=null){
            String email = savedInstanceState.getString("email");
            user = new userDTO();
            user.setEmail_user(email);

        }
        else {
            user = new userDTO();

        }

        changetitle(user.getEmail_user());
    }

    public void changetitle(String title){
        TextView tuser = findViewById(R.id.main_apptitle);
        tuser.setText(title);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("domain",user.getEmail_user());
    }


    public void onFragmentInteraction(userDTO emailu) {

        this.user.setEmail_user(emailu.getEmail_user());
        changetitle(user.getEmail_user());
    }
    }

