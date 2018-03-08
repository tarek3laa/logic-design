/**
    *coding by
    *Tarek Alaa &&  Abd ElRahman Shata*

 */

package com.app_tarek.logicdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.app_tarek.logicdesign.numericalSystem.conversionFromBinary;
import com.app_tarek.logicdesign.numericalSystem.conversionFromDecimal;
import com.app_tarek.logicdesign.numericalSystem.conversionFromHex;
import com.app_tarek.logicdesign.numericalSystem.conversionFromOctal;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

import static java.lang.Long.parseLong;

//************************************************
//****************************************************

public class Logic_Activity extends AppCompatActivity {

    private AdView mAdView;
//********************************

    Spinner spinner1;
    Spinner spinner2;

    EditText editText;
    TextView textView;

    Button button;

    protected String val1;
    protected String val2;
    protected String setVal = " ";
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_);
        //*****************************************************

        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
//**************************************************************************

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        editText = (EditText) findViewById(R.id.edit_text);
        textView = (TextView) findViewById(R.id.text_val);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    val1 = spinner1.getSelectedItem().toString();
                    val2 = spinner2.getSelectedItem().toString();

                    String a = editText.getText().toString();
                    long num = parseLong(a);
                    check(num, val1, val2, editText.getText().toString());

                    textView.setText(setVal);
                    arrayList.clear();
                    setVal = " ";
                } catch (Exception e) {
                    Toast.makeText(Logic_Activity.this, "Error", Toast.LENGTH_LONG).show();

                }
            }
        });


    }

    protected void check(long num, String val1, String val2, String editText) {

        if (val1.equals(getString(R.string.decimal))) {

            conversionFromDecimal decimal = new conversionFromDecimal(num, editText);

            if (val2.equals(getString(R.string.binary))) {
                this.setVal += decimal.toBinary();

            } else if (val2.equals(getString(R.string.octal))) {
                this.setVal += decimal.toOctal();
            } else if (val2.equals(getString(R.string.Hex))) {
                this.setVal += decimal.toHex();
            }
        } else if (val1.equals(getString(R.string.binary))) {

            conversionFromBinary binary = new conversionFromBinary(editText);

            if (val2.equals(getString(R.string.decimal))) {
                this.setVal += binary.toDecimal();

            } else if (val2.equals(getString(R.string.octal))) {
                this.setVal += binary.toOctal();
            } else if (val2.equals(getString(R.string.Hex))) {
                this.setVal += binary.toHex();
            }

        } else if (val1.equals(getString(R.string.octal))) {
            conversionFromOctal octal = new conversionFromOctal(editText);
            if (val2.equals(getString(R.string.decimal))) {

                this.setVal += octal.toDecimal();

            } else if (val2.equals(getString(R.string.binary))) {
                this.setVal += octal.toBinary();

            } else if (val2.equals(getString(R.string.Hex))) {
                this.setVal += octal.toHex();

            }


        } else if (val1.equals(getString(R.string.Hex))) {

            conversionFromHex hex = new conversionFromHex(editText);
            if (val2.equals(getString(R.string.decimal))) {

                this.setVal += hex.toDecimal();

            } else if (val2.equals(getString(R.string.binary))) {
                this.setVal += hex.toBinary();

            } else if (val2.equals(getString(R.string.octal))) {
                this.setVal += hex.toOctal();

            }
        }


    }

}








