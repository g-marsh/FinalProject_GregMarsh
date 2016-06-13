package com.oakton.cis258.finalproject_gregmarsh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MoviePicture7Activity extends AppSettings
{
    // Variables
    SharedPreferences spAppSettings;
    ImageView imgActor;
    TextView tvActor;
    TextView tvShowChar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture8);

        // Instantiate controls
        spAppSettings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
        tvActor = (TextView) findViewById(R.id.textView5);
        tvShowChar = (TextView) findViewById(R.id.textView8);
        imgActor = (ImageView) findViewById(R.id.imageView);

        // Obtain extras
        Bundle extras = getIntent().getExtras();

        // Display character and show
        tvShowChar.setText("Favorite character " + extras.getString(CHARACTER) + " in " + (spAppSettings.getString(MOVIE, "")));

        // Actors Ryan
        if (extras.get("user_character").equals("Captain Miller"))
        {
            imgActor.setImageResource(R.drawable.tom_h);
            tvActor.setText(getString(R.string.miller_act));
        }
        else if (extras.get("user_character").equals("Private Ryan"))
        {
            imgActor.setImageResource(R.drawable.matt_d);
            tvActor.setText(getString(R.string.ryan_act));
        }
        else if (extras.get("user_character").equals("Private Caparzo"))
        {
            imgActor.setImageResource(R.drawable.vin_d);
            tvActor.setText(getString(R.string.caparzo_act));
        }

        // Army of Darkness
        else if (extras.get("user_character").equals("Ash Williams"))
        {
            imgActor.setImageResource(R.drawable.bruce_c);
            tvActor.setText(getString(R.string.ash_act));
        }
        else if (extras.get("user_character").equals("Sheila"))
        {
            imgActor.setImageResource(R.drawable.embeth_d);
            tvActor.setText(getString(R.string.sheila_act));
        }
        else if (extras.get("user_character").equals("Lord Arthur"))
        {
            imgActor.setImageResource(R.drawable.marcus_g);
            tvActor.setText(getString(R.string.arthur_act));
        }

        // Gone with the Wind
        else if (extras.get("user_character").equals("Scarlett O'Hara"))
        {
            imgActor.setImageResource(R.drawable.vivien_l);
            tvActor.setText(getString(R.string.scarlett_act));
        }
        else if (extras.get("user_character").equals("Rhett Butler"))
        {
            imgActor.setImageResource(R.drawable.clark_g);
            tvActor.setText(getString(R.string.rhett_act));
        }
        else if (extras.get("user_character").equals("Melanie Hamilton"))
        {
            imgActor.setImageResource(R.drawable.oliva_h);
            tvActor.setText(getString(R.string.melanie_act));
        }

        // Top Gun
        else if (extras.get("user_character").equals("Maverick"))
        {
            imgActor.setImageResource(R.drawable.tom_c);
            tvActor.setText(getString(R.string.maverick_act));
        }
        else if (extras.get("user_character").equals("Charlie"))
        {
            imgActor.setImageResource(R.drawable.kelly_m);
            tvActor.setText(getString(R.string.charlie_act));
        }
        else if (extras.get("user_character").equals("Iceman"))
        {
            imgActor.setImageResource(R.drawable.val_k);
            tvActor.setText(getString(R.string.iceman_act));
        }

        // Forest Gump
        else if (extras.get("user_character").equals("Forest"))
        {
            imgActor.setImageResource(R.drawable.tom_h);
            tvActor.setText(getString(R.string.forest_act));
        }
        else if (extras.get("user_character").equals("Jenny"))
        {
            imgActor.setImageResource(R.drawable.robin_w);
            tvActor.setText(getString(R.string.jenny_act));
        }
        else if (extras.get("user_character").equals("Lieutenant Dan"))
        {
            imgActor.setImageResource(R.drawable.gary_s);
            tvActor.setText(getString(R.string.lieutenat_act));
        }


        // Go to next screen
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(MoviePicture7Activity.this, SelectTV6Activity.class));
                finish();
            }
        });

    }

}
