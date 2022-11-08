package com.example.idealweight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button calcBtn;
    private Button apiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcBtn = (Button) findViewById(R.id.button1);
        apiBtn = (Button) findViewById(R.id.button2);

        calcBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                openIdealWeightCalc();
            }
        });

        apiBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                openIdealWeightAPI();
            }
        });
    }

    public void openIdealWeightCalc() {
        Intent intent = new Intent(this, IdealWeightCalc.class);
        startActivity(intent);
    }

    public void openIdealWeightAPI() {
        Intent intent = new Intent(this, IdealWeightAPI.class);
        startActivity(intent);
    }


}