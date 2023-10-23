package com.example.lab5;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final LinearLayout mylayout = (LinearLayout) findViewById(R.id.root);
        int id = item.getItemId();
        if (id == R.id.red) {
            mylayout.setBackgroundColor(getResources().getColor(R.color.red));
            return true;
        } else if (id == R.id.green) {
            mylayout.setBackgroundColor(getResources().getColor(R.color.green));
            return true;
        } else if (id == R.id.blue) {
            mylayout.setBackgroundColor(getResources().getColor(R.color.blue));
            return true;
        } else if (id == R.id.exit) {
            finish();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }
}