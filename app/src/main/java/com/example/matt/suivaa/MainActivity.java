package com.example.matt.suivaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    Button boutonCo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtxt_id = (EditText) findViewById(R.id.editTxt_login);
        final EditText edtxt_mdp = (EditText) findViewById(R.id.editTxt_mdp);
        boutonCo = (Button)findViewById(R.id.btnConnexion);
        final VisiteurDAO unVisiteurDAO = new VisiteurDAO(this.getApplicationContext());

        /* Test de l'ajout d'un visiteur
        unVisiteurDAO.addVisiteur("a17","dandre", "oppg5");
        Toast.makeText(MainActivity.this, unVisiteurDAO.getVisiteur().toString(),
                Toast.LENGTH_LONG).show();*/

        boutonCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WebServices maTache = new WebServices();
                maTache.execute("wsRecupID.php",edtxt_id.getText().toString(), edtxt_mdp.getText().toString());

                try
                {
                    // dans le cas où on récupère un objet

                    String resultat = maTache.get();
                    Log.d("resultat_execute", resultat);

                    // dans le cas où on récupère un tableau d'objet
                    /*JSONArray array = new JSONArray(resultat);
                    Log.d("debogage ",""+array.length());
                    String valeurRecuperee;
                    for(int i = 0 ; i < array.length() ; i++) {
                        valeurRecuperee= array.getJSONObject(i).getString("libelleCat");
                        Log.d("debogage for", valeurRecuperee);
                    }*/

                    // ajoute un visiteur dans la bdd locale
                    unVisiteurDAO.addVisiteur(resultat.toString(),edtxt_id.getText().toString(), edtxt_mdp.getText().toString());
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                /*Intent passageVue1 = new Intent(MainActivity.this, VisiteActivity.class );
                startActivity(passageVue1);*/
            }

        });
    }



    public void testClasseDAO()
    {
        CabinetDAO unCabinetDAO = new CabinetDAO(this.getApplicationContext());

        Cabinet unCabinet = new Cabinet(1,"rue","paris","75000",473728.0,73827.0);

        unCabinetDAO.addCabinet(unCabinet);

        Toast.makeText(MainActivity.this, unCabinetDAO.getCabinet(1).getAdresse().toString(),
                Toast.LENGTH_LONG).show();
        //test


    }


}
