package com.example.idealweight;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;


public class IdealWeightAPI extends AppCompatActivity {

    private EditText editApiHeight;
    private EditText editApiGender;
    private EditText editApiWeight;
    private TextView apiOutput;
    private TextView apiMessage;
    private Button callApiBtn;
    private Button eduBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal_weight_api);
        setUI();


        callApiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String height = editApiHeight.getText().toString();
                String gender = editApiGender.getText().toString();
                String currentWeight = editApiWeight.getText().toString();

                String apiURL = "http://webstrar99.fulton.asu.edu/page2/Service1.svc/IdealWeight?height=" + height +
                        "&currentWeight=" + currentWeight + "&gender=" + gender;

                String jsonStr = getUrlContents(apiURL);

                try {
                    final JSONObject obj = new JSONObject(jsonStr);
                    String idealWeight = obj.getString("idealW");
                    String riskFactor = obj.getString("riskFactor");
                    apiOutput.setText(idealWeight);
                    apiMessage.setText(riskFactor);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        eduBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String html1 = "https://familydoctor.org/what-you-can-do-to-maintain-your-health/";
                String html2 = "https://www.livestrong.com/article/281134-how-to-calculate-ibw";
                String html3 = "https://www.populytics.com/blog/10-habits-maintain-good-health/";

                String [] arr = {html1, html2, html3};
                Random random = new Random();
                int select = random.nextInt(arr.length);

                Uri uriUrl = Uri.parse(arr[select]);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
    }

    private void setUI() {
        editApiHeight = (EditText) findViewById(R.id.editApiHeight);
        editApiGender = (EditText) findViewById(R.id.editApiGender);
        editApiWeight = (EditText) findViewById(R.id.editApiWeight);
        apiOutput = (TextView) findViewById(R.id.apiOutput);
        apiMessage = (TextView) findViewById(R.id.apiMessage);
        callApiBtn = (Button) findViewById(R.id.callApiBtn);
        eduBtn = (Button) findViewById(R.id.eduBtn);
    }

    private static String getUrlContents(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}

