package com.nef.corgi.apppowercorpore;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.widget.TextView;
import android.widget.Toast;


//el email sera el identificador unico de nuestra aplicacion
public class MainActivity extends AppCompatActivity implements Autehtication.OnFragmentInteractionListener{
private userDTO user=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("INICIO","Bienvenido a PowerCorpore");
        FragmentManager fm = getSupportFragmentManager();
        Fragment email_user = fm.findFragmentById(R.id.main_container);
        //Binvenida y muestra el nombre de usuario
        if(email_user==null) {
            FragmentTransaction ft = fm.beginTransaction();
            Autehtication fragment = Autehtication.newInstance("", "");
            ft.add(R.id.main_container, fragment, "login");
            ft.commit();
        } else
            Toast.makeText(this,getString(R.string.mainactivity_fragmentepresent), Toast.LENGTH_SHORT).show();

        if(savedInstanceState!=null){
            String name = savedInstanceState.getString("name");
            user = new userDTO();
            user.setUser_name(name);

        }
        else {
            user = new userDTO();

        }

       //changetitle(user.getUser_name());//evitamos q coja el nombre name por defecto del ya creado en la clase userDTO
    }

    public void changetitle(String title){
        TextView tuser = findViewById(R.id.main_apptitle);
        tuser.setText(title);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("name",user.getUser_name());
    }

    @Override
    public void onFragmentInteraction(userDTO name) {

        this.user.setUser_name(name.getUser_name());
        changetitle(user.getUser_name());
    }
    }

