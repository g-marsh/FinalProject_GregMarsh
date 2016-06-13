package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login2Activity extends AppSettings
{
    // Variables
    SharedPreferences spAppSettings;
    EditText etUsername;
    EditText etPassword;
    Button btnSubmit;
    String strUsername;
    String strPassword;
    String strUsernameInput;
    String strPasswordInput;
    String strLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        // Instantiate variables
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
        btnSubmit = (Button)findViewById(R.id.button);
        etUsername = (EditText)findViewById(R.id.editText);
        etPassword = (EditText)findViewById(R.id.editText2);
        strUsername = spAppSettings.getString(USER_NAME, "");
        strPassword = spAppSettings.getString(PASSWORD, "");
        strLastName = spAppSettings.getString(LAST_NAME, "");

        // Login check
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                strUsernameInput = etUsername.getText().toString();
                strPasswordInput = etPassword.getText().toString();

                if (strUsernameInput.equals(strUsername) && strPasswordInput.equals(strPassword))
                {
                    // if no user info entered go to input user info
                    if(strLastName.equals(""))
                    {
                        Intent switchActivity = new Intent(Login2Activity.this, UserInfo2Activity.class);
                        startActivity(switchActivity);
                    }
                    // user info present, go to menu
                    else
                    {
                        Intent switchActivity = new Intent(Login2Activity.this, Menu3Activity.class);
                        startActivity(switchActivity);
                    }
                    finish();
                }
                else
                {
                    Toast.makeText(Login2Activity.this,
                            "Wrong username and/or password",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        // Reset username/pass
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switchActivity = new Intent(Login2Activity.this, Reset2BActivity.class);
                startActivity(switchActivity);
                finish();
            }
        });

    }
}
