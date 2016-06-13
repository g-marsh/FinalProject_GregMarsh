package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Currency;

public class TipCalculatorActivity extends AppCompatActivity
{
    // Variables
    EditText etAmount;
    EditText etPercentage;
    TextView tvTip10;
    TextView tvTotal10;
    TextView tvTip15;
    TextView tvTotal15;
    TextView tvTip20;
    TextView tvTotal20;
    TextView tvPercent;
    TextView tvTipPercent;
    TextView tvTotalPercent;
    double dblAmount;
    double dblPercentage;
    double dblTip10;
    double dblTotal10;
    double dblTip15;
    double dblTotal15;
    double dblTip20;
    double dblTotal20;
    double dblTipPercent;
    double dblTotalPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        // Instantiate
        etAmount = (EditText) findViewById(R.id.editText6);
        etPercentage = (EditText) findViewById(R.id.editText7);
        tvTip10 = (TextView) findViewById(R.id.textView17B);
        tvTotal10 = (TextView) findViewById(R.id.textView17C);
        tvTip15 = (TextView) findViewById(R.id.textView18B);
        tvTotal15 = (TextView) findViewById(R.id.textView18C);
        tvTip20 = (TextView) findViewById(R.id.textView19B);
        tvTotal20 = (TextView) findViewById(R.id.textView19C);
        tvPercent = (TextView) findViewById(R.id.textView20);
        tvTipPercent = (TextView) findViewById(R.id.textView20B);
        tvTotalPercent = (TextView) findViewById(R.id.textView20C);

        // Calculate Tips
        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Error check input not values
                try
                {
                    dblAmount = Double.valueOf(etAmount.getText().toString());
                    dblPercentage = Double.valueOf(etPercentage.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(TipCalculatorActivity.this,
                            "Enter values only",
                            Toast.LENGTH_LONG).show();
                }

                // 10 percent calculate
                dblTip10 = dblAmount * 0.1;
                dblTotal10 = dblAmount * 1.1;
                tvTip10.setText(String.format("%.2f",dblTip10));
                tvTotal10.setText(String.format("%.2f", dblTotal10));

                // 15 percent
                dblTip15 = dblAmount * 0.15;
                dblTotal15 = dblAmount * 1.15;
                tvTip15.setText(String.format("%.2f", dblTip15));
                tvTotal15.setText(String.format("%.2f",dblTotal15));

                // 20 percent
                dblTip20 = dblAmount * 0.2;
                dblTotal20 = dblAmount * 1.2;
                tvTip20.setText(String.format("%.2f", dblTip20));
                tvTotal20.setText(String.format("%.2f",dblTotal20));

                // Custom percent
                if (dblPercentage > 0)
                {
                    dblTipPercent = dblAmount * dblPercentage / 100.0;
                    dblTotalPercent = dblAmount * (1.0+dblPercentage/100.0);
                    tvPercent.setText(String.valueOf(dblPercentage));
                    tvTipPercent.setText(String.format("%.2f", dblTipPercent));
                    tvTotalPercent.setText(String.format("%.2f", dblTotalPercent));
                }
            }
        });

        // Tip Calculator
        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switchActivity = new Intent(TipCalculatorActivity.this, Menu3Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

    }
}
