package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SelectTV6Activity extends AppSettings
{
    SharedPreferences spAppSettings;
    ListView lvShows;
    String strShowSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tv6);

        // Instantiate
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = spAppSettings.edit();
        lvShows = (ListView) findViewById(R.id.listView);

        // Declare and populate array.
        String [] aryShows = getResources().getStringArray(R.array.shows);

        // Populate ListView
        ArrayAdapter<String> aryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aryShows);

        // Display populated ListView.
        lvShows.setAdapter(aryAdapter);

        // ListView Listener
        lvShows.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Find the selected item and store the value.
                strShowSelected = ((TextView) view).getText().toString();
                editor.putString(TVSHOW, strShowSelected);

                // Execute the code to save changes.
                editor.commit();

                // Declare and Instantiate Intent variable to switch to second screen.
                Intent switchActivity = new Intent(SelectTV6Activity.this, SelectCharacter7Activity.class);

                // Run the desired Intent.
                startActivity(switchActivity);
                finish();
            }
        });
    }
}
