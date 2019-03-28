package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.vmware.displayjoke.DisplayJokesActivity;
import com.vmware.jokes.Jokes;


public class MainActivity extends AppCompatActivity implements EndpointAsyncTask.LaunchDisplayJokesActivityCallback {

    private Jokes jokes;
    private String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokes = new Jokes();
        joke = jokes.tellAJoke();

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
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
    }

    public void displayJoke(View view) {

        Intent intent = new Intent(this, DisplayJokesActivity.class);
        intent.putExtra("joke", joke);
        startActivity(intent);
    }

    public void displayJokeFromGCE(View view) {
        new EndpointAsyncTask(this).execute();
    }


    @Override
    public void startDisplayJokesActivity(String joke) {
        Intent intent = new Intent(this, DisplayJokesActivity.class);
        intent.putExtra("joke", joke);
        startActivity(intent);
    }
}

