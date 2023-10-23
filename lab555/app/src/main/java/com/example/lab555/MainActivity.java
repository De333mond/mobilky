package com.example.lab555;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    method to create text view
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
        }

        if (id == R.id.green) {
            mylayout.setBackgroundColor(getResources().getColor(R.color.green));
            return true;
        } else if (id == R.id.blue) {
            mylayout.setBackgroundColor(getResources().getColor(R.color.blue));
            return true;
        }
        else if (id == R.id.addNiceDay) {
            TextView textView = new TextView(this);
            textView.setText("Have a nice day!");
            textView.setTextAppearance(R.style.SpecialText);
            mylayout.addView(textView);
            return true;
        }
        else if (id == R.id.addThank) {
            TextView textView = new TextView(this);
            textView.setTextAppearance(R.style.SpecialText);
            textView.setText("Thanks!");
            mylayout.addView(textView);
            return true;
        }
        else if (id == R.id.exit) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
