package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SelectCharacter7Activity extends AppSettings
{
    // Variables
    SharedPreferences spAppSettings;
    ListView lvActors;
    ImageView imvShow;
    String strShowSelected;
    String strCharacterSelected;
    String [] aryActors;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_character7);

        // Instantiate variables
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
        lvActors = (ListView) findViewById(R.id.listView2);
        imvShow = (ImageView)findViewById(R.id.imageView3);

        strShowSelected = (spAppSettings.getString(TVSHOW, ""));
        if (strShowSelected.equals("Buffy the Vampire Slayer"))
        {
            // populate array.
            aryActors = getResources().getStringArray(R.array.buffy_actors);
            imvShow.setImageResource(R.drawable.buffy);
        }
        else if (strShowSelected.equals("Beverly Hills 90210"))
        {
            // populate array.
            aryActors = getResources().getStringArray(R.array.beverly_actors);
            imvShow.setImageResource(R.drawable.beverly);
        }
        else if (strShowSelected.equals("Melrose Place"))
        {
            // populate array.
            aryActors = getResources().getStringArray(R.array.melrose_actors);
            imvShow.setImageResource(R.drawable.melrose);
        }
        else if (strShowSelected.equals("Magnum PI"))
        {
            // populate array.
            aryActors = getResources().getStringArray(R.array.magnum_actors);
            imvShow.setImageResource(R.drawable.magnum);
        }
        else // "Angel"
        {
            // populate array.
            aryActors = getResources().getStringArray(R.array.angel_actors);
            imvShow.setImageResource(R.drawable.angel);
        }

        // Populate ListView
        ArrayAdapter<String> aryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aryActors);

        // Display populated ListView.
        lvActors.setAdapter(aryAdapter);

        // ListView Listener
        lvActors.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Find the selected item and store the value.
                strCharacterSelected = ((TextView) view).getText().toString();

                // Declare and Instantiate Intent variable to switch to second screen.
                Intent switchActivity = new Intent(SelectCharacter7Activity.this, Picture8Activity.class);
                // Password change flag
                switchActivity.putExtra(CHARACTER, strCharacterSelected);

                // Run the desired Intent.
                startActivity(switchActivity);
                finish();
            }
        });
    }
}
