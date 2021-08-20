package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static RadioButton rd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Spinner spinner = findViewById(R.id.spinnerLabel);
        if(spinner != null)
            spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.arrayLabels, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if(spinner != null)
            spinner.setAdapter(adapter);

        Intent intent = getIntent();

        //check a delivery option by default
        rd = (RadioButton)findViewById(R.id.nextday);
        rd.setChecked(true);
        String msg = "Order : "+intent.getStringExtra(MainActivity.extraMessage);
        TextView textview = findViewById(R.id.orderTextView);
        textview.setText(msg);
    }

    public void onRadioClick(View view) {
        switch (view.getId()) {
            case R.id.sameday:
                displayToast(getString(R.string.sameDayService));
                break;
            case R.id.nextday:
                displayToast(getString(R.string.nextDayDelivery));
                break;
            case R.id.pickup:
                displayToast(getString(R.string.pickUp));
                break;
            default:
                break;
        }
    }

    public void displayToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerLabel = parent.getItemAtPosition(position).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}