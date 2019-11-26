package edu.niu.cs.adityabharadwaj.championstrophy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
    public void home1(View view)
    {
        startActivity(new Intent(getApplicationContext(),FirstActivity.class));
    }
}
