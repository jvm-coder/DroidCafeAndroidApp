package com.example.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String extraMessage = "com.example.android.droidcafe.extra.MESSAGE";
    public String mOrderMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(extraMessage, mOrderMsg);
                startActivity(intent);

            }
        });
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

        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        switch (item.getItemId()) {
            case R.id.action_contact:
                displayToast(getString(R.string.actionContactMsg));
                /*Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(extraMessage, mOrderMsg);
                startActivity(intent);*/
                return true;
            case R.id.action_favorites:
                displayToast(getString(R.string.actionFavoritesMsg));
                /*Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(extraMessage, mOrderMsg);
                startActivity(intent);*/
                return true;
            case R.id.action_order:
                displayToast(getString(R.string.actionOrderMsg));
                //Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(extraMessage, mOrderMsg);
                startActivity(intent);
                return true;
            case R.id.action_status:
                displayToast(getString(R.string.actionStatusMsg));
                /*Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(extraMessage, mOrderMsg);
                startActivity(intent);*/
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {
        mOrderMsg = getString(R.string.donutOrderMsg);
        displayToast(mOrderMsg);
    }

    public void showIceCreamOrder(View view) {
        mOrderMsg = getString(R.string.iceCreamOrderMsg);
        displayToast(mOrderMsg);
    }

    public void showFroyoOrder(View view) {
        mOrderMsg = getString(R.string.froyoOrderMsg);
        displayToast(mOrderMsg);
    }

    public void showDialer(MenuItem item) {
        Intent intent1 = new Intent(Intent.ACTION_DIAL);
        intent1.setData(Uri.parse("tel:7652067597"));
        startActivity(intent1);
    }
}