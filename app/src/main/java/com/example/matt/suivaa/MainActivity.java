package com.example.matt.suivaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button boutonCo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        boutonCo = (Button)findViewById(R.id.btnConnexion);

        boutonCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent passageVue1 = new Intent(MainActivity.this, VisiteActivity.class );
                startActivity(passageVue1);
            }
        });
        //testClasseDAO();
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
