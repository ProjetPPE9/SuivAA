package com.example.matt.suivaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Maxime on 28/04/2017.
 */
public class VisiteActivity extends AppCompatActivity
{
    //Button boutonValider;
    Button boutonSaisieVisite;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visite);

       /* boutonValider = (Button)findViewById(R.id.btnNouvelleVisite);


        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent passageVue3 = new Intent(VisiteActivity.this, CabinetVisiteActivity.class );
                startActivity(passageVue3);
            }
        });*/
        boutonSaisieVisite= (Button)findViewById(R.id.btnCompteRendu);

        boutonSaisieVisite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent passageVue4 = new Intent(VisiteActivity.this, CabinetSaisieActivity.class );
                startActivity(passageVue4);
            }
        });
        //testClasseDAO();
        //testClasseDAO();
    }
}
