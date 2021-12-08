package com.example.a1kontras_1var;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;

import java.sql.Time;
import java.text.DateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id
        TextView textView = (TextView) findViewById(R.id.textView);
        Button btn = (Button) findViewById(R.id.button);
        Button btn1 = (Button) findViewById(R.id.button2);
        Button btn2 = (Button) findViewById(R.id.button3);
        Button btn3 = (Button) findViewById(R.id.button4);

        //1 button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        Calendar cc = Calendar.getInstance();

        String currentDateString = DateFormat.getDateInstance().format(cc.getTime());
        String pickedDateString = DateFormat.getDateInstance().format(c.getTime());
        Date date = c.getTime();
        Date cdate = cc.getTime();
        long diff = date.getTime() - cdate.getTime();
        long likoo = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(currentDateString + " - " +  pickedDateString +
                " ,Liko dienu: " + likoo);
    }

    public void startChronometer(View v, long num) {
        TextView textView = (TextView) findViewById(R.id.textView);
        if (!running) {
            for(int i=0; i<num; i++)

            running = true;
        }
    }
}