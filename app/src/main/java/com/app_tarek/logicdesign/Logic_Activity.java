package com.app_tarek.logicdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

//************************************************
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
//****************************************************


public class Logic_Activity extends AppCompatActivity {

    private AdView mAdView;
//********************************

    Spinner spinner1;
    Spinner spinner2;

    EditText editText;
    TextView textView;

    Button button;

    String val1;
    String val2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_);
      //*****************************************************

        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544/6300978111");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
//**************************************************************************

    spinner1=(Spinner)findViewById(R.id.spinner1);
    spinner2=(Spinner)findViewById(R.id.spinner2);

    editText=(EditText)findViewById(R.id.edit_text);
    textView=(TextView)findViewById(R.id.text_val);

    button=(Button)findViewById(R.id.button);

   /* spinner1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
       val1= spinner1.getSelectedItem().toString();

        }
    });

    spinner2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            val2=spinner2.getSelectedItem().toString();

        }
    });
*/
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            val1= spinner1.getSelectedItem().toString();
            val2=spinner2.getSelectedItem().toString();

            textView.setText(val1+" "+val2);
        }
    });



    }
}
