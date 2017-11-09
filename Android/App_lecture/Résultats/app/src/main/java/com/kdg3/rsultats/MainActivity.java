package com.kdg3.rsultats;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.kdg3.rsultats.ui.GroupListActivity;
import com.kdg3.rsultats.page.MainChallenge;


public class MainActivity extends AppCompatActivity {
    private TextView ui_welcomeLabel;//création de variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ui_welcomeLabel = (TextView) findViewById(R.id.welcome_label);//charge le welcome_label dans le layaout en la métant dans une variable

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    //méthode pour afficher la vue a l'appui du boutton dans content_main
    public void welcomeButtonPressed(View button) {
        Intent openGroups = new Intent(this, MainChallenge.class);
        startActivity(openGroups);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else  if (id==R.id.action_droid){
            Intent openGroups = new Intent(this, GroupListActivity.class);//fait en sorte que le droid envoi vers GroupListActivity qui permer de vérifier en console les commande
            startActivity(openGroups);
        }

        return super.onOptionsItemSelected(item);
    }
}
