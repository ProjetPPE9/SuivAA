package com.example.matt.suivaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Maxime on 04/05/2017.
 */
public class MedecinSaisieActivity extends AppCompatActivity {

    ListView listeMedecin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medecin_saisie);

        listeMedecin= (ListView)findViewById(R.id.listeMedecin);

        String[] medecins = new String[]{
                "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
                "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
                "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
                "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
                "Yann", "Zoé"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MedecinSaisieActivity.this,
                android.R.layout.simple_list_item_1, medecins);
        listeMedecin.setAdapter(adapter);

        listeMedecin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent passageVue5 = new Intent(MedecinSaisieActivity.this, InformationVisiteActivity.class );
                startActivity(passageVue5);
            }
        });





    }
}
