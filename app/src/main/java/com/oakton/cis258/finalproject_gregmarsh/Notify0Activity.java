package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Notify0Activity extends AppSettings
{

    // Variables
    SharedPreferences spAppSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify0);

        // Instantiate variables
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);

        if (spAppSettings.contains("Username"))
        {
            // Account exists - have user login
            startActivity(new Intent(Notify0Activity.this, Login2Activity.class));
            finish();
        }

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Create account
                startActivity(new Intent(Notify0Activity.this, Settings1Activity.class));
                finish();
            }
        });
    }
}
