package com.example.matt.suivaa;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Maxime on 04/05/2017.
 */


public class InformationVisiteActivity extends AppCompatActivity {

    Button btnDate;
    Button btnHeureArrivée;
    Button btnHeureEntretien;
    Button btnHeureDépart;
    int year,month,day,heure,minute;
    static final int DIALOG_ID = 0;
    TextView txtHeureArrivée;
    TextView txtHeureEntretien;
    TextView txtHeureDépart;
    TextView txtDate;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_visite);

        btnDate= (Button)findViewById(R.id.btnDate);
        btnHeureArrivée= (Button)findViewById(R.id.btnHeureArrivée);
        btnHeureEntretien= (Button)findViewById(R.id.btnHeureEntretien);
        btnHeureDépart= (Button)findViewById(R.id.btnHeureDépart);

        txtDate= (TextView)findViewById(R.id.txtDate);
        txtHeureArrivée= (TextView)findViewById(R.id.txtHeureArrivée);
        txtHeureEntretien= (TextView)findViewById(R.id.txtHeureEntretien);
        txtHeureDépart= (TextView)findViewById(R.id.txtHeureDépart);

        showDialogOnButtonClick();


        final java.util.Calendar recup = java.util.Calendar.getInstance();
        year = recup.get(java.util.Calendar.YEAR);
        month = recup.get(java.util.Calendar.MONTH);
        day = recup.get(java.util.Calendar.DAY_OF_MONTH);

        btnHeureArrivée.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                final Calendar recup2 = Calendar.getInstance();
                heure = recup2.get(Calendar.HOUR_OF_DAY);
                minute = recup2.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog1=new TimePickerDialog(InformationVisiteActivity.this,
                        new TimePickerDialog.OnTimeSetListener()
                        {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute1)
                            {
                                if(minute<10)
                                {
                                    txtHeureArrivée.setText(hourOfDay + ":0"+minute1);
                                }
                                else
                                {
                                    txtHeureArrivée.setText(hourOfDay+":"+minute1);
                                }
                            }
                        },heure,minute,true);
                timePickerDialog1.show();
            }
        });

        btnHeureEntretien.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                final Calendar recup2 = Calendar.getInstance();
                heure = recup2.get(Calendar.HOUR_OF_DAY);
                minute = recup2.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog1=new TimePickerDialog(InformationVisiteActivity.this,
                        new TimePickerDialog.OnTimeSetListener()
                        {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute1)
                            {
                                if(minute<10)
                                {
                                    txtHeureEntretien.setText(hourOfDay + ":0"+minute1);
                                }
                                else
                                {
                                    txtHeureEntretien.setText(hourOfDay+":"+minute1);
                                }
                            }
                        },heure,minute,true);
                timePickerDialog1.show();
            }
        });

        btnHeureDépart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                final Calendar recup2 = Calendar.getInstance();
                heure = recup2.get(Calendar.HOUR_OF_DAY);
                minute = recup2.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog1=new TimePickerDialog(InformationVisiteActivity.this,
                        new TimePickerDialog.OnTimeSetListener()
                        {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute1)
                            {
                                if(minute<10)
                                {
                                    txtHeureDépart.setText(hourOfDay + ":0"+minute1);
                                }
                                else
                                {
                                    txtHeureDépart.setText(hourOfDay+":"+minute1);
                                }
                            }
                        },heure,minute,true);
                timePickerDialog1.show();
            }
        });

    }

    public void showDialogOnButtonClick()
    {



        btnDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showDialog(DIALOG_ID);

            }


        });
    }
    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth1)
        {
            year = year1;
            month = month1 +1;
            day = dayOfMonth1;


            txtDate.setText(day + "-" + month + "-" + year);


        }

    };



    @Override
    protected Dialog onCreateDialog(int id)
    {
        if (id == DIALOG_ID)
            return new DatePickerDialog(InformationVisiteActivity.this, datePickerListener, year ,month,day);

        return null;


    }




}
