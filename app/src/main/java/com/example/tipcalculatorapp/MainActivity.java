package com.example.tipcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.Locale;
import android.icu.text.NumberFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.icu.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput1;
    private EditText editTextInput2;

    private RadioButton radioButtonZero;
    private RadioButton radioButtonFive;
    private RadioButton radioButtonTen;
    private RadioButton radioButtonTwenty;

    private TextView textResultTip;
    private TextView textResultGrand;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextInput1=findViewById(R.id.editTextInput1);
        editTextInput2=findViewById(R.id.editTextInput2);


        radioButtonZero=findViewById(R.id.radioButtonZero);
        radioButtonFive=findViewById(R.id.radioButtonFive);
        radioButtonTen=findViewById(R.id.radioButtonTen);
        radioButtonTwenty=findViewById(R.id.radioButtonTwenty);
        textResultTip=findViewById(R.id.textResultTip);
        textResultGrand=findViewById(R.id.textResultGrand);

        radioButtonZero.setChecked(true);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        textResultTip.setText(currencyFormat.format(0.00));
        textResultGrand.setText(currencyFormat.format(0.00));

    }
    public void clearForm(View view){
        editTextInput1.setText("");
        editTextInput2.setText("");
        radioButtonZero.setChecked(true);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        textResultTip.setText(currencyFormat.format(0.00));
        textResultGrand.setText(currencyFormat.format(0.00));
    }
    public void calculate(View view){

        double num1 ;
        double num2 ;
        double tip = 0;
        double total = 0;

        try {
            num1 = Double.parseDouble(editTextInput1.getText().toString());
        }
        catch (NumberFormatException ex) {
            Toast.makeText(this, "Number must be numerical", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            num2 = Double.parseDouble(editTextInput2.getText().toString());
        }
        catch (NumberFormatException ex) {
            Toast.makeText(this, "Number must be numerical", Toast.LENGTH_LONG).show();
            return;
        }

        if (radioButtonZero.isChecked()) {
            tip = num1 * 0.0;
            total= num1 + num2 + tip;
        }
        else if (radioButtonFive.isChecked()) {
            tip = num1 * 0.05;
            total= num1 + num2 +tip;
        }
        else if (radioButtonTen.isChecked()) {
            tip = num1 * 0.10;
            total= num1 + num2 + tip;
        }
        else if (radioButtonTwenty.isChecked()) {
            tip = num1 * 0.20;
            total= num1 + num2 + tip;
        }



        textResultTip.setText(Double.toString(tip));
        textResultGrand.setText(Double.toString(total));




        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        textResultTip.setText(decimalFormat.format(tip));
        textResultGrand.setText(decimalFormat.format(total));

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        textResultTip.setText(currencyFormat.format (tip));
        textResultGrand.setText(currencyFormat.format (total));

    }


}