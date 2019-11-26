package edu.niu.z1807314.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ShipItem shipItem;
    private EditText weightET;
    private TextView baseTV, addedTV, totalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shipItem = new ShipItem();
        weightET = (EditText)findViewById(R.id.editTextOZ);
        baseTV = (TextView)findViewById(R.id.textViewBase);
        addedTV = (TextView)findViewById(R.id.textViewAdded);
        totalTV = (TextView)findViewById(R.id.textViewTotal);
        weightET.addTextChangedListener(weightTextWatcher);
    } //end onCreate

    private TextWatcher weightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                shipItem.setWeight((int) Double.parseDouble(charSequence.toString()));
            }
            catch (NumberFormatException nfe) {
                shipItem.setWeight(0);
            }
            displayShipping();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private void displayShipping() {
        baseTV.setText("$" + String.format("%.02f", shipItem.getBaseCost()));
        addedTV.setText("$" + String.format("%.02f", shipItem.getAddedCost()));
        totalTV.setText("$" + String.format("%.02f", shipItem.getTotalCost()));
    }
}
