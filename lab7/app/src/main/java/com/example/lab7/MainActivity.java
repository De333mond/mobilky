package com.example.lab7;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.MyDialogFragmentListener {

    private TextView tvDialogResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowDialog = findViewById(R.id.btnShowDialog);
        tvDialogResult = findViewById(R.id.tvDialogResult);

        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialogFragment myDialogFragment = new MyDialogFragment();
                myDialogFragment.show(getSupportFragmentManager(), "myDialog");
            }
        });
    }

    @Override
    public void onReturnValue(String value) {
        tvDialogResult.setText("Здравствуйте, "+value+"!");
    }
}
