package edu.niu.z1807314.burgercaloriecalculator;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Burger burger;
    private RadioGroup pattyRG, cheeseRG;
    private CheckBox prosciuttoCBX;
    private SeekBar caviarSB;
    private TextView caloriesTXT;
    public final static String TAG = "burger";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        burger = new Burger();
        Log.d(TAG, "after create burger");
        initialize();
        registerChanged();
    }

    private void registerChanged() {
        Log.d(TAG, "in registerChanged");
        pattyRG.setOnCheckedChangeListener(foodListener);
        cheeseRG.setOnCheckedChangeListener(foodListener);
        prosciuttoCBX.setOnClickListener(baconListener);
        caviarSB.setOnSeekBarChangeListener(sauceListener);
    }

    private void initialize() {
        //get references to all variables
        pattyRG = (RadioGroup)findViewById(R.id.radioGroupMeat);
        cheeseRG = (RadioGroup)findViewById(R.id.RadioGroupCheese);
        prosciuttoCBX = (CheckBox)findViewById(R.id.checkBoxProsciutto);
        caviarSB = (SeekBar)findViewById(R.id.seekBarCaviar);
        caloriesTXT = (TextView)findViewById(R.id.textViewCal);
        displayCalories();
    }

    private void displayCalories() {
        String calStr = "Calories = " + burger.getTotalCalories();
        caloriesTXT.setText(calStr);
    }

    private RadioGroup.OnCheckedChangeListener foodListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
            switch (checkedID) {
                case R.id.radioBeef: //Beef Patty
                    burger.setPattyCal(Burger.BEEF);
                    break;
                case R.id.radioLamb: //Lamb Patty
                    burger.setPattyCal(Burger.LAMB);
                    break;
                case R.id.radioOstrich: //Ostrich Patty
                    burger.setPattyCal(Burger.OSTRICH);
                    break;
                case R.id.radioButtonAsiago: //Asiago Cheese
                    burger.setCheeseCal(Burger.ASIAGO);
                    break;
                case R.id.radioButtonProvolone: //Provolone Cheese
                    burger.setCheeseCal(Burger.PROVOLONE);
                    break;
                //End
            }
            displayCalories();
        }
    };
    private View.OnClickListener baconListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(((CheckBox)view).isChecked()) {
                burger.setProsciuttoCal(Burger.PROSCIUTTO);
            }
            else {
                burger.clearProsciutto();
            }
            displayCalories();
        }
    };
    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            burger.setSauceCal(seekBar.getProgress());
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}
