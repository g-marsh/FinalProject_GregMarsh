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

public class Picture8Activity extends AppSettings
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
        tvShowChar.setText("Favorite character " + extras.getString(CHARACTER) + " in " + (spAppSettings.getString(TVSHOW, "")));

        // Actors Buff
        if (extras.get("user_character").equals("Buffy"))
        {
            imgActor.setImageResource(R.drawable.sarah_g);
            tvActor.setText(getString(R.string.buffy_act));
        }
        else if (extras.get("user_character").equals("Willow"))
        {
            imgActor.setImageResource(R.drawable.alyson_h);
            tvActor.setText(getString(R.string.willow_act));
        }
        else if (extras.get("user_character").equals("Xander"))
        {
            imgActor.setImageResource(R.drawable.nicholas_b);
            tvActor.setText(getString(R.string.xander_act));
        }
        else if (extras.get("user_character").equals("Rupert"))
        {
            imgActor.setImageResource(R.drawable.anthony2_h);
            tvActor.setText(getString(R.string.rupert_act));
        }
        else if (extras.get("user_character").equals("Angel"))
        {
            imgActor.setImageResource(R.drawable.david_b);
            tvActor.setText(getString(R.string.angel_act));
        }
        else if (extras.get("user_character").equals("Spike"))
        {
            imgActor.setImageResource(R.drawable.james_m);
            tvActor.setText(getString(R.string.spike_act));
        }
        // Actors Angel + Pre-sequel
        else if (extras.get("user_character").equals("Cordelia"))
        {
            imgActor.setImageResource(R.drawable.charisma_c);
            tvActor.setText(getString(R.string.cordelia_act));
        }
        else if (extras.get("user_character").equals("Wesley"))
        {
            imgActor.setImageResource(R.drawable.alexis_d);
            tvActor.setText(getString(R.string.wesley_act));
        }
        else if (extras.get("user_character").equals("Illyria"))
        {
            imgActor.setImageResource(R.drawable.amy_a);
            tvActor.setText(getString(R.string.illyria_act));
        }
        else if (extras.get("user_character").equals("Charles"))
        {
            imgActor.setImageResource(R.drawable.august_r);
            tvActor.setText(getString(R.string.charles_act));
        }
        else if (extras.get("user_character").equals("Lorne"))
        {
            imgActor.setImageResource(R.drawable.andy_h);
            tvActor.setText(getString(R.string.lorne_act));
        }
        // Beverly Hills characters
        else if (extras.get("user_character").equals("Kelly"))
        {
            imgActor.setImageResource(R.drawable.jennie_g);
            tvActor.setText(getString(R.string.kelly_act));
        }
        else if (extras.get("user_character").equals("Donna"))
        {
            imgActor.setImageResource(R.drawable.torri_s);
            tvActor.setText(getString(R.string.donna_act));
        }
        else if (extras.get("user_character").equals("Brandon"))
        {
            imgActor.setImageResource(R.drawable.jason_p);
            tvActor.setText(getString(R.string.brandon_act));
        }
        else if (extras.get("user_character").equals("Brenda"))
        {
            imgActor.setImageResource(R.drawable.shannen_d);
            tvActor.setText(getString(R.string.brenda_act));
        }
        else if (extras.get("user_character").equals("Dylan"))
        {
            imgActor.setImageResource(R.drawable.luke_p);
            tvActor.setText(getString(R.string.dylan_act));
        }
        else if (extras.get("user_character").equals("David"))
        {
            imgActor.setImageResource(R.drawable.brian_g);
            tvActor.setText(getString(R.string.david_act));
        }
        // Melrose characters
        else if (extras.get("user_character").equals("Amanda"))
        {
            imgActor.setImageResource(R.drawable.heather_l);
            tvActor.setText(getString(R.string.amanda_act));
        }
        else if (extras.get("user_character").equals("Jake"))
        {
            imgActor.setImageResource(R.drawable.grant_s);
            tvActor.setText(getString(R.string.jake_act));
        }
        else if (extras.get("user_character").equals("Billy"))
        {
            imgActor.setImageResource(R.drawable.andrew_s);
            tvActor.setText(getString(R.string.billy_act));
        }
        else if (extras.get("user_character").equals("Sydney"))
        {
            imgActor.setImageResource(R.drawable.laura_l);
            tvActor.setText(getString(R.string.sydney_act));
        }
        else if (extras.get("user_character").equals("Michael"))
        {
            imgActor.setImageResource(R.drawable.thomas_c);
            tvActor.setText(getString(R.string.michael_act));
        }
        else if (extras.get("user_character").equals("Jane"))
        {
            imgActor.setImageResource(R.drawable.josie_b);
            tvActor.setText(getString(R.string.jane_act));
        }
        // Magnum PI characters
        else if (extras.get("user_character").equals("Magnum"))
        {
            imgActor.setImageResource(R.drawable.tom_s);
            tvActor.setText(getString(R.string.magnum_act));
        }
        else if (extras.get("user_character").equals("Higgins"))
        {
            imgActor.setImageResource(R.drawable.john_h);
            tvActor.setText(getString(R.string.higgins_act));
        }
        else if (extras.get("user_character").equals("TC"))
        {
            imgActor.setImageResource(R.drawable.roger_m);
            tvActor.setText(getString(R.string.tc_act));
        }
        else if (extras.get("user_character").equals("Rick"))
        {
            imgActor.setImageResource(R.drawable.larry_m);
            tvActor.setText(getString(R.string.rick_act));
        }
        else if (extras.get("user_character").equals("Carol"))
        {
            imgActor.setImageResource(R.drawable.kathleen_l);
            tvActor.setText(getString(R.string.carol_act));
        }
        else if (extras.get("user_character").equals("Allison"))
        {
            imgActor.setImageResource(R.drawable.courtney_t);
            tvActor.setText(getString(R.string.allison_act));
        }

        // Go to next screen
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(Picture8Activity.this, View9Activity.class));
                finish();
            }
        });

    }

}