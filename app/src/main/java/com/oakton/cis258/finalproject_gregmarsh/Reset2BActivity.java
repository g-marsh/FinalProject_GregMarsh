package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Reset2BActivity extends AppSettings
{

    // Variables
    SharedPreferences spAppSettings;
    EditText etPasswordSecurityQuestion;
    String strUserInput;
    String strPasswordSecurityQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset2_b);

        // Instantiate variables
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
        etPasswordSecurityQuestion = (EditText)findViewById(R.id.editText3);

        // Compare user input and security question
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                strUserInput = etPasswordSecurityQuestion.getText().toString();
                strPasswordSecurityQuestion = spAppSettings.getString("SecurityQuestion", "");

                if (strUserInput.equals(strPasswordSecurityQuestion))
                {
                    Intent switchActivity = new Intent(Reset2BActivity.this, Settings1Activity.class);
                    switchActivity.putExtra("flag", 0);
                    startActivity(switchActivity);
                    finish();
                } else
                {
                    Toast.makeText(Reset2BActivity.this,
                            "Wrong color entered",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
