package com.vmware.displayjoke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);

        String joke = getIntent().getStringExtra("joke");

        TextView textJoke = findViewById(R.id.text_joke);

        textJoke.setText(joke);

    }

}
