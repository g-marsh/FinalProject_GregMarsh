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

public class SelectMovieCharacter6Activity extends AppSettings
{
    // Variables
    SharedPreferences spAppSettings;
    ListView lvActors;
    ImageView imvMovie;
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
        imvMovie = (ImageView)findViewById(R.id.imageView3);

        strShowSelected = (spAppSettings.getString(MOVIE, ""));
        if (strShowSelected.equals("Saving Private Ryan"))
        {
            // populate array.
            aryActors = getResources().getStringArray(R.array.ryan_actors);
            imvMovie.setImageResource(R.drawable.saving_private_ryan);
        }
        else if (strShowSelected.equals("Army of Darkness"))
        {
            // populate array.
            aryActors = getResources().getStringArray(R.array.darkness_actors);
            imvMovie.setImageResource(R.drawable.army_darkness);
        }
        else if (strShowSelected.equals("Gone with the Wind"))
        {
            // populate array.
            aryActors = getResources().getStringArray(R.array.gone_actors);
            imvMovie.setImageResource(R.drawable.gone_wind);
        }
        else if (strShowSelected.equals("Top Gun"))
        {
            // populate array.
            aryActors = getResources().getStringArray(R.array.top_actors);
            imvMovie.setImageResource(R.drawable.top_gun);
        }
        else // Forest Gump
        {
            // populate array.
            aryActors = getResources().getStringArray(R.array.forest_actors);
            imvMovie.setImageResource(R.drawable.forest_gump);
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
                Intent switchActivity = new Intent(SelectMovieCharacter6Activity.this, MoviePicture7Activity.class);
                // Password change flag
                switchActivity.putExtra(CHARACTER, strCharacterSelected);

                // Run the desired Intent.
                startActivity(switchActivity);
                finish();
            }
        });
    }
}
