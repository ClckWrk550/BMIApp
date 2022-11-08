package com.example.idealweight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;

public class IdealWeightCalc extends AppCompatActivity {

    private EditText editHeight;
    private EditText editGender;
    private EditText editWeight;
    private TextView output;
    private TextView message;
    private Button goBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal_weight_calc);
        setUI();

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int height = Integer.parseInt(editHeight.getText().toString());
                String gender = editGender.getText().toString();
                int currentWeight = Integer.parseInt(editWeight.getText().toString());
                int idealWeight = 100 + (height-60)*5;

                output.setText(String.valueOf(idealWeight));

                int difWeight = currentWeight - idealWeight;

                if (difWeight >= 15) {
                    message.setTextColor(Color.RED);
                    message.setText("Obese");
                }
                else if (15 > difWeight && difWeight >= 10) {
                    message.setTextColor(Color.YELLOW);
                    message.setText("Pre-Obese");
                }
                else if (10 > difWeight && difWeight >= -5) {
                    message.setTextColor(Color.GREEN);
                    message.setText("Normal");
                }
                else {
                    message.setTextColor(Color.BLUE);
                    message.setText("Underweight");
                }

            }
        });
    }

    private void setUI() {
        editHeight = (EditText) findViewById(R.id.editHeight);
        editGender = (EditText) findViewById(R.id.editGender);
        editWeight = (EditText) findViewById(R.id.editWeight);
        output = (TextView) findViewById(R.id.output);
        message = (TextView) findViewById(R.id.message);
        goBtn = (Button) findViewById(R.id.goBtn);
    }

}