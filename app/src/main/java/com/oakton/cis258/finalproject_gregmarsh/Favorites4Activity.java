package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Favorites4Activity extends AppSettings
{
    // Variables
    SharedPreferences spAppSettings;
    ListView lvSport;
    String strSport;
    String [] arySport;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites4);

        // Instantiate Shared Prefs.
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);

        // Instantiate Editor.
        final SharedPreferences.Editor editor = spAppSettings.edit();

        // Declare and populate array
        arySport = getResources().getStringArray(R.array.sport);

        // Instantiate Variables
        lvSport = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> aryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arySport);
        lvSport.setAdapter(aryAdapter);

        // ListView Listener
        lvSport.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Store Info into shared preferences and switch activity
                strSport = ((TextView) view).getText().toString();
                editor.putString(SPORT, strSport);

                // Execute the code to save changes.
                editor.commit();

                Intent switchActivity = new Intent(Favorites4Activity.this, Spinners4BActivity.class);
                startActivity(switchActivity);
                finish();
            }
        });

    }
}
