package com.ypnors.bmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String s = new String("abc");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bHelp = (Button) findViewById(R.id.b_help);
        bHelp.setOnClickListener(listener);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI說明")
                        .setMessage("體重/身高的平方")
                        .setPositiveButton("ok", null)
                        .show();

            }
        };
    }


    public void bmi(View view) {
        // System.out.println("what???");
        Log.d("MainActivity", "testing bmi method");
        EditText edWeight = (EditText) findViewById(R.id.ed_weight);
        EditText edHeight = (EditText) findViewById(R.id.ed_height);
        float weight = Float.parseFloat(edWeight.getText().toString());
        float height = Float.parseFloat(edHeight.getText().toString());
        float bmi = weight / (height * height);
        new AlertDialog.Builder(this)
                .setMessage(getString(R.string.your_bmi_is) + bmi)
                .setTitle(R.string.my_title)
                .setPositiveButton(R.string.ok, null)
                .show();
        Log.d("MainActivity", String.valueOf(bmi));

        if(height>3){
            new AlertDialog.Builder(this)
                    .setMessage("身高單位應為公尺")
                    .setPositiveButton("ok",null)
                    .show();
        }


        if (bmi < 20) {
            new AlertDialog.Builder(this)
                    .setMessage("請多吃點")
                    .setPositiveButton("ok", null)
                    .show();
        }
    }

}


