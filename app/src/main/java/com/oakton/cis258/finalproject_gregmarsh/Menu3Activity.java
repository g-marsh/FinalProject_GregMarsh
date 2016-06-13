package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu3Activity extends AppSettings
{
    // Variables
    SharedPreferences spAppSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);

        // Instantiate
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);

        // Instantiate Editor.
        final SharedPreferences.Editor editor = spAppSettings.edit();

        // Change password/username
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switchActivity = new Intent(Menu3Activity.this, Settings1Activity.class);
                // Password change flag
                switchActivity.putExtra("flag", 0);
                startActivity(switchActivity);
                finish();
            }
        });

        // Change User Info
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switchActivity = new Intent(Menu3Activity.this, UserInfo2Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

        // Change Favorites Info
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switchActivity = new Intent(Menu3Activity.this, Favorites4Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

        // Select Shows
        findViewById(R.id.button8B).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switchActivity = new Intent(Menu3Activity.this, SelectMovie5Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

        // View Info Screen
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switchActivity = new Intent(Menu3Activity.this, View9Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

        // Tip Calculator
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switchActivity = new Intent(Menu3Activity.this, TipCalculatorActivity.class);
                startActivity(switchActivity);
                finish();
            }
        });

        // Reset Info Entered
        findViewById(R.id.button12).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Overwrited stored info
                editor.putString(FIRST_NAME, "");
                editor.putString(LAST_NAME, "");
                editor.putString(EMAIL, "");
                editor.putBoolean(FEMALE, true);
                editor.putString(TVSHOW, "");
                editor.putInt(BIRTH_DAY, 1);
                editor.putInt(BIRTH_MONTH, 1);
                editor.putString(STATE, "");
                editor.putString(SPORT, "");
                editor.putString(MOVIE, "");
                editor.putString(FOOD, "");
                editor.putString(BAND, "");
                editor.putString(COLOR, "");
                editor.putString(CHARACTER, "");

                // Execute the code to save changes.
                editor.commit();
                Intent switchActivity = new Intent(Menu3Activity.this, View9Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

    }
}
