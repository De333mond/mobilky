package com.example.lab4;

import android.nfc.Tag;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

public class MainActivity extends AppCompatActivity {

    private boolean checked1 = false;
    private boolean checked2 = false;
    private boolean checked3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        ImageButton imageButton = findViewById(R.id.imageButton);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        CheckBox checkBox1 = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);

        TextView toggleResult = findViewById(R.id.textView);
        TextView imageResult = findViewById(R.id.textView2);
        TextView radioResult = findViewById(R.id.textView3);
        TextView checkboxResult = findViewById(R.id.textView4);

        toggleResult.setText(String.format("Toggle: %s", toggleButton.getText()));
        imageResult.setText("Image: Deactivated");
        radioResult.setText("Radio: ");
        checkboxResult.setText(String.format("Checked: [%s, %s, %s]", checked1, checked2, checked3));

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleResult.setText(String.format("Toggle: %s", toggleButton.getText()));
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton)
                    radioResult.setText("Radio: RadioButton 1");
                else if (checkedId == R.id.radioButton2)
                    radioResult.setText("Radio: RadioButton 2");
                else if (checkedId == R.id.radioButton3)
                    radioResult.setText("Radio: RadioButton 3");
                else
                    radioResult.setText("Radio: Error");
            }
        });

        checkBox1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checked1 = isChecked;
                ShowCheckRes(checkboxResult);
            }
        });
        checkBox2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checked2 = isChecked;
                ShowCheckRes(checkboxResult);
            }
        });
        checkBox3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checked3 = isChecked;
                ShowCheckRes(checkboxResult);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (imageButton.isActivated()) {
                    imageButton.setActivated(false);
                    imageResult.setText("Image: Deactivated");
                }
                else {
                    imageButton.setActivated(true);
                    imageResult.setText("Image: Activated");
                }
            }
        });



    }

    private void ShowCheckRes(TextView text) {
        text.setText(String.format("Checked: [%b, %b, %b]", checked1, checked2, checked3));
    }

}