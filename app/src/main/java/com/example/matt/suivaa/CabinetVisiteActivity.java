package com.example.matt.suivaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxime on 02/05/2017.
 */
public class CabinetVisiteActivity extends AppCompatActivity {

    Spinner spinner1;
    Button boutonValider;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet_visite);

        boutonValider = (Button)findViewById(R.id.btnValider3);

        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent passageVue3 = new Intent(CabinetVisiteActivity.this, MedecinVisiteActivity.class );
                startActivity(passageVue3);
            }
        });



        spinner1 = (Spinner) findViewById(R.id.listeCabinet);
        List<String> list = new ArrayList<String>();
        list.add("cabinet 1");
        list.add("cabinet 2");
        list.add("cabinet 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);

        //testClasseDAO();
    }
}
