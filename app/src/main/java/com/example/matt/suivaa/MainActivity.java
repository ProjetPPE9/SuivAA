package com.example.matt.suivaa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
