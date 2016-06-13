package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings1Activity extends AppSettings
{

    // Variables
    SharedPreferences spAppSettings;
    Button btnUpdate;
    EditText etUsername;
    EditText etPassword;
    EditText etPasswordConfirm;
    EditText etPasswordSecurityQuestion;
    String strUsername;
    String strPassword;
    String strPasswordConfirm;
    String strPasswordSecurityQuestion;
    int intFlag;
    boolean blnPasswordOk;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings1);

        // Instantiate variables
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = spAppSettings.edit();
        btnUpdate = (Button)findViewById(R.id.buttonS);
        etUsername = (EditText)findViewById(R.id.editTextS);
        etPassword = (EditText)findViewById(R.id.editTextS2);
        etPasswordConfirm = (EditText)findViewById(R.id.editTextS3);
        etPasswordSecurityQuestion = (EditText)findViewById(R.id.editTextS4);

        // Determine flag value extra from welcome screen
        Bundle bFlag = getIntent().getExtras();

        if (bFlag != null)
        {
            // Get flag value
            intFlag = bFlag.getInt("flag");
        }
        else
        {
            // Assign flag value
            intFlag = -1;
        }

        if (spAppSettings.contains(USER_NAME))
        {
            if (intFlag == 0)
            {
                // User came from menu screen, allow user to update info
            }
            else
            {
                // Account exists - have user login / not from welcome screen
                startActivity(new Intent(Settings1Activity.this, Login2Activity.class));
                finish();
            }
        }
        else
        {
            // No account - have user create one.
            // Update button name
            btnUpdate.setText("Create Account");
        }

        btnUpdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Run password check method
                onUpdateButtonClick();

                if (blnPasswordOk)
                // Save password and go to login screen
                {
                    editor.putString("Username", strUsername);
                    editor.putString("Password", strPassword);
                    editor.putString("SecurityQuestion", strPasswordSecurityQuestion);
                    editor.commit();
                    Intent switchActivity = new Intent(Settings1Activity.this, Login2Activity.class);
                    startActivity(switchActivity);
                    finish();
                }

            }
        });

    }

    // check password criteria
    public void onUpdateButtonClick()
    {
        strUsername = etUsername.getText().toString();
        strPassword = etPassword.getText().toString();
        strPasswordConfirm = etPasswordConfirm.getText().toString();
        strPasswordSecurityQuestion = etPasswordSecurityQuestion.getText().toString();
        if (strPassword.equals(strPasswordConfirm))
        {
            blnPasswordOk = true;

            // Password must be at least 2 characters
            if (!(strPassword.length() >=2))
            {
                blnPasswordOk = false;
                Toast.makeText(Settings1Activity.this,
                        "Passwords must have at least two characters.",
                        Toast.LENGTH_LONG
                ).show();
            }

            // Password must have at least one lowercase letter
            if (!strPassword.matches(".*[a-z].*"))
            {
                blnPasswordOk = false;
                Toast.makeText(Settings1Activity.this,
                        "Passwords must have at least one lowercase letter.",
                        Toast.LENGTH_LONG
                ).show();
            }

            // Password cannot have spaces.
            if (strPassword.matches(".*\\s.*"))
            {
                blnPasswordOk = false;
                Toast.makeText(Settings1Activity.this,
                        "Passwords cannot have spaces.",
                        Toast.LENGTH_LONG
                ).show();
            }

            // Password not more than 16 characters
            if (strPassword.length() > 16)
            {
                blnPasswordOk = false;
                Toast.makeText(Settings1Activity.this,
                        "Passwords cannot be more than 16 characters.",
                        Toast.LENGTH_LONG
                ).show();
            }
        }
        else
        {
            blnPasswordOk = false;
            // Display Toast.
            Toast.makeText(Settings1Activity.this,
                    "Passwords do not match. Please re-enter password.",
                    Toast.LENGTH_LONG).show();
            etPassword.setText("");
            etPasswordConfirm.setText("");
        }

    }

}
