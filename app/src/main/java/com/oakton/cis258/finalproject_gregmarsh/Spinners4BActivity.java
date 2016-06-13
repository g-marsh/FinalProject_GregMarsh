package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Spinners4BActivity extends AppSettings
{
    // Variables
    SharedPreferences spAppSettings;
    Spinner spnColor;
    String strColor;
    String strFood;
    String strBand;
    EditText etFood;
    EditText etBand;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinners4_b);

        // Instantiate Shared Prefs.
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);

        // Instantiate Editor.
        final SharedPreferences.Editor editor = spAppSettings.edit();

        // Variables
        spnColor = (Spinner) findViewById(R.id.spinner);
        etFood = (EditText)findViewById(R.id.editText5);
        etBand = (EditText)findViewById(R.id.editTextS6);

        // Instantiate Spinners Method.
        addItemsSpinnerColor();

        // Fill in Edit Texts with previous values
        etBand.setText(String.valueOf(spAppSettings.getString(BAND, "")));
        etFood.setText(String.valueOf(spAppSettings.getString(FOOD, "")));


        // View Results
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                strColor = String.valueOf(spnColor.getSelectedItem());
                strFood = String.valueOf(etFood.getText());
                strBand = String.valueOf(etBand.getText());
                // Store Info into shared preferences and switch activity
                editor.putString(COLOR, strColor);
                editor.putString(FOOD, strFood);
                editor.putString(BAND, strBand);

                // Execute the code to save changes.
                editor.commit();
                Intent switchActivity = new Intent(Spinners4BActivity.this, View9Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

    }

    // Setup the Color Spinner.
    public void addItemsSpinnerColor()
    {
        // Declare and populate array
        String [] aryColor = getResources().getStringArray(R.array.color);

        // Bind the array to the Spinner.
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, aryColor);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the settings to the Spinner.
        spnColor.setAdapter(dataAdapter);
    }

}
