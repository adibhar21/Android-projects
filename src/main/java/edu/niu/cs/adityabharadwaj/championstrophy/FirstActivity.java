package edu.niu.cs.adityabharadwaj.championstrophy;

/*

App Description: This Android app helps the user to navigate to the information section of a soccer team selected.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class FirstActivity extends AppCompatActivity implements OnItemSelectedListener {

    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        final Button sc = (Button)findViewById(R.id.score);
        sc.setEnabled(false);

        Spinner spin = (Spinner) findViewById(R.id.spinner);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Champions_list, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final Button sc = (Button)findViewById(R.id.score);
    String p = (String) parent.getItemAtPosition(position);
        if (position==0)
        {
            ImageView img = (ImageView)findViewById(R.id.homeimg);
            img.setImageResource(R.drawable.cl);
            cnt = 0;
            sc.setEnabled(false);

        }

        if (position==1)
        {

            ImageView img = (ImageView)findViewById(R.id.homeimg);
            img.setImageResource(R.drawable.celebratebarca);
            cnt = 1;
            sc.setEnabled(true);
        }
        if (position==2)
        {
            ImageView img = (ImageView)findViewById(R.id.homeimg);
            img.setImageResource(R.drawable.bayerncelebrate);
            cnt = 2;
            sc.setEnabled(true);
        }
        if (position==3)
        {
            ImageView img = (ImageView)findViewById(R.id.homeimg);
            img.setImageResource(R.drawable.realcelebrate);
            cnt = 3;
            sc.setEnabled(true);
        }
        if (position==4)
        {
            ImageView img = (ImageView)findViewById(R.id.homeimg);
            img.setImageResource(R.drawable.manu);
            cnt = 4;
            sc.setEnabled(true);
        }
        if (position==5)
        {
            ImageView img = (ImageView)findViewById(R.id.homeimg);
            img.setImageResource(R.drawable.psg);
            cnt = 5;
            sc.setEnabled(true);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture)
    {

    }

    public void score(View view)
    {

        switch (cnt)
        {
            case 0:break;

            case 1: startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                break;
            case 2: startActivity(new Intent(getApplicationContext(),ThirdActivity.class));
                break;
            case 3: startActivity(new Intent(getApplicationContext(),FourthActivity.class));
                break;
            case 4: startActivity(new Intent(getApplicationContext(),FifthActivity.class));
                break;
            case 5: startActivity(new Intent(getApplicationContext(),SixthActivity.class));
                break;
        }

    }





}
