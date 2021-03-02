package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.*;

import java.lang.Math;

public class TipCalculatorActivity extends AppCompatActivity {
    EditText checkVal;
    EditText partySize;

    EditText tip_15;
    EditText tip_20;
    EditText tip_25;

    EditText total_15;
    EditText total_20;
    EditText total_25;


    Button computeTip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkVal= (EditText)findViewById(R.id.checkAmountValue);
        partySize = (EditText)findViewById(R.id.partySizeValue);

        tip_15 = (EditText)findViewById(R.id.fifteenPercentTipValue);
        tip_20 = (EditText)findViewById(R.id.twentyPercentTipValue);
        tip_25 = (EditText)findViewById(R.id.twentyfivePercentTipValue);

        total_15= (EditText)findViewById(R.id.fifteenPercentTotalValue);
        total_20= (EditText)findViewById(R.id.twentyPercentTotalValue);
        total_25= (EditText)findViewById(R.id.twentyfivePercentTotalValue);





        computeTip =(Button) findViewById(R.id.buttonCompute);
        computeTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Integer.valueOf(checkVal.getText().toString()) <= 0 || Integer.valueOf(partySize.getText().toString()) <= 0) throw new Exception();

                    int amount = Integer.valueOf(checkVal.getText().toString());
                    int party = Integer.valueOf(partySize.getText().toString());

                    //Calculating 15 percent tip & total
                    tip_15.setText(String.valueOf(Math.round((amount * .15) / party)));
                    total_15.setText(String.valueOf(Math.round(((amount * .15) + amount) / party)));

                    //Calculating 20 percent tip & total
                    tip_20.setText(String.valueOf(Math.round((amount * .2) / party)));
                    total_20.setText(String.valueOf(Math.round(((amount * .2) + amount) / party)));

                    //Calculating 25 percent tip & total
                    tip_25.setText(String.valueOf(Math.round((amount * .25) / party)));
                    total_25.setText(String.valueOf(Math.round(((amount * .25) + amount) / party)));



                    // Hides the Keyboard after button click
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);


                }catch (Exception e){
                    // Show Error if incorrect values are in Check Amount and Party Size
                    Toast.makeText(getApplicationContext(), "Empty or Incorrect value(s)!",Toast.LENGTH_LONG).show();

                }


            }
        });

    }
}

