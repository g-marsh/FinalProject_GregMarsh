package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class UserInfo2Activity extends AppSettings
{
    // Variables
    SharedPreferences spAppSettings;
    EditText etFirstName;
    EditText etLastName;
    EditText etEmail;
    EditText etState;
    RadioButton rbFemale;
    RadioButton rbMale;
    boolean blnFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info2);

        // Instantiate Shared Prefs.
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);

        // Instantiate Editor.
        final SharedPreferences.Editor editor = spAppSettings.edit();

        // Variables
        etFirstName = (EditText)findViewById(R.id.editText);
        etLastName = (EditText)findViewById(R.id.editText2);
        etEmail = (EditText)findViewById(R.id.editText3);
        etState = (EditText)findViewById(R.id.editText4);
        rbFemale = (RadioButton) findViewById(R.id.radioButton);
        rbMale = (RadioButton) findViewById(R.id.radioButton2);

        // Fill in Edit Texts with existing values
        etFirstName.setText(String.valueOf(spAppSettings.getString(FIRST_NAME, "")));
        etLastName.setText(String.valueOf(spAppSettings.getString(LAST_NAME, "")));
        etEmail.setText(String.valueOf(spAppSettings.getString(EMAIL, "")));
        etState.setText(String.valueOf(spAppSettings.getString(STATE, "")));
        if (spAppSettings.getBoolean(FEMALE,true))
        {
            rbFemale.setChecked(true);
        }
        else
        {
            rbMale.setChecked(true);
        }

        // Update values
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String strFirstName = String.valueOf(etFirstName.getText());
                String strLastName = String.valueOf(etLastName.getText());
                String strEmail = String.valueOf(etEmail.getText());
                String strState = String.valueOf(etState.getText());
                if(rbFemale.isChecked())
                {
                    blnFemale = true;
                }
                else
                {
                    blnFemale = false;
                }

                editor.putString(FIRST_NAME,strFirstName);
                editor.putString(LAST_NAME, strLastName);
                editor.putString(EMAIL, strEmail);
                editor.putString(STATE, strState);
                editor.putBoolean(FEMALE, blnFemale);

                // Execute the code to save changes.
                editor.commit();

                Intent switchActivity = new Intent(UserInfo2Activity.this, Date3Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });
    }
}
