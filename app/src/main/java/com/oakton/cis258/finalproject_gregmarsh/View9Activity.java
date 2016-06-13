package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class View9Activity extends AppSettings
{
    // Variables
    SharedPreferences spAppSettings;
    TextView tvFirstName;
    TextView tvLastName;
    TextView tvBirthDay;
    TextView tvEmail;
    TextView tvGender;
    TextView tvState;
    TextView tvColor;
    TextView tvBand;
    TextView tvSport;
    TextView tvFood;
    TextView tvMovie;
    TextView tvShow;
    boolean blnFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view9);

        // Instantiate variables
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
        tvFirstName = (TextView)findViewById(R.id.textView6);
        tvBirthDay = (TextView)findViewById(R.id.textView9);
        tvLastName = (TextView) findViewById(R.id.textView20);
        tvEmail = (TextView) findViewById(R.id.textView22);
        tvGender = (TextView) findViewById(R.id.textView24);
        tvState = (TextView) findViewById(R.id.textView26);
        tvColor = (TextView) findViewById(R.id.textView28);
        tvBand = (TextView) findViewById(R.id.textView30);
        tvSport = (TextView) findViewById(R.id.textView32);
        tvFood = (TextView) findViewById(R.id.textView34);
        tvMovie = (TextView) findViewById(R.id.textView36);
        tvShow = (TextView) findViewById(R.id.textView38);

        // Read UserInfo and update Text
        tvFirstName.setText(spAppSettings.getString(FIRST_NAME, ""));
        tvLastName.setText(spAppSettings.getString(LAST_NAME, ""));
        tvEmail.setText(spAppSettings.getString(EMAIL, ""));
        blnFemale = spAppSettings.getBoolean(FEMALE, false);
        if (blnFemale)
        {
            tvGender.setText(R.string.female);
        }
        else
        {
            tvGender.setText(R.string.male);
        }
        tvState.setText(spAppSettings.getString(STATE, ""));
        String StrBirthDay = String.valueOf(spAppSettings.getInt(BIRTH_DAY, 0));
        String StrBirthMonth = String.valueOf(spAppSettings.getInt(BIRTH_MONTH, 0));
        tvBirthDay.setText(StrBirthMonth+"/"+StrBirthDay);
        tvColor.setText(String.valueOf(spAppSettings.getString(COLOR, "")));
        tvBand.setText(String.valueOf(spAppSettings.getString(BAND, "")));
        tvSport.setText(String.valueOf(spAppSettings.getString(SPORT, "")));
        tvFood.setText(String.valueOf(spAppSettings.getString(FOOD, "")));
        tvMovie.setText(String.valueOf(spAppSettings.getString(MOVIE, "")));
        tvShow.setText(String.valueOf(spAppSettings.getString(TVSHOW, "")));

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent switchActivity = new Intent(View9Activity.this, Menu3Activity.class);
                startActivity(switchActivity);
                finish();
            }
        });

    }
}
