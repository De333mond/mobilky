package com.example.lab3;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    // Constants for element IDs
    private static final int ID_BUTTON_B = 100;
    private static final int ID_BUTTON_I = 101;
    private static final int ID_TEXT_SIZE = 102;
    private static final int ID_BUTTON_PLUS = 103;
    private static final int ID_BUTTON_MINUS = 104;
    private static final int ID_BUTTON_SANS = 105;
    private static final int ID_BUTTON_SERIF = 106;
    private static final int ID_BUTTON_MONOSPACE = 107;
    private static final int ID_EDIT_TEXT = 108;

    private float mTextSize = 20;
    private EditText mEdit;
    private TextView tSize;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

        LinearLayout buttonLayout = new LinearLayout(this);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        Button buttonB = createButton("B", ID_BUTTON_B);
        Button buttonI = createButton("I", ID_BUTTON_I);
        TextView textSize = createTextView("size: 16", ID_TEXT_SIZE);
        Button buttonPlus = createButton("+", ID_BUTTON_PLUS);
        Button buttonMinus = createButton("-", ID_BUTTON_MINUS);

        buttonLayout.addView(buttonB);
        buttonLayout.addView(buttonI);
        buttonLayout.addView(textSize);
        buttonLayout.addView(buttonPlus);
        buttonLayout.addView(buttonMinus);

        LinearLayout typefaceLayout = new LinearLayout(this);
        typefaceLayout.setOrientation(LinearLayout.HORIZONTAL);
        typefaceLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        Button buttonSans = createButton("SANSSERIF", ID_BUTTON_SANS);
        Button buttonSerif = createButton("SERIF", ID_BUTTON_SERIF);
        Button buttonMonospace = createButton("MONOSPACE", ID_BUTTON_MONOSPACE);

        typefaceLayout.addView(buttonSans);
        typefaceLayout.addView(buttonSerif);
        typefaceLayout.addView(buttonMonospace);

        EditText editText = new EditText(this);
        editText.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        editText.setId(ID_EDIT_TEXT);
        editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        editText.setText("Форматируемый текст");
        editText.setTextSize(16);

        mainLayout.addView(buttonLayout);
        mainLayout.addView(typefaceLayout);
        mainLayout.addView(editText);

        this.addContentView(mainLayout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));



//        setContentView(R.layout.activity_main);
        tSize = textSize;

        mEdit = editText;

        buttonB.setOnClickListener(this);
        buttonI.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonSans.setOnClickListener(this);
        buttonSerif.setOnClickListener(this);
        buttonMonospace.setOnClickListener(this);
    }

    private Button createButton(String text, int id) {
        Button button = new Button(this);
        button.setText(text);
        button.setLayoutParams(new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        button.setId(id);
        button.setOnClickListener(this);
        return button;
    }

    private TextView createTextView(String text, int id) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 2));
        textView.setId(id);
        return textView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case ID_BUTTON_PLUS:
                if (mTextSize < 72) {
                    mTextSize += 2;
                    mEdit.setTextSize(mTextSize);
                    tSize.setText(String.format("%.0f", mTextSize));
                }
                break;
            case ID_BUTTON_MINUS:
                if (mTextSize > 18) {
                    mTextSize-=2;
                    mEdit.setTextSize(mTextSize);
                    tSize.setText(String.format("%.0f",mTextSize));
                }
                break;
            case ID_BUTTON_B:
                if (mEdit.getTypeface().getStyle()== Typeface.ITALIC)
                    mEdit.setTypeface(mEdit.getTypeface(),
                            Typeface.BOLD_ITALIC);
                else if (mEdit.getTypeface().getStyle()==
                        Typeface.BOLD_ITALIC)
                    mEdit.setTypeface(mEdit.getTypeface(),
                            Typeface.ITALIC);
                else if (mEdit.getTypeface().getStyle()== Typeface.BOLD)
                    mEdit.setTypeface(Typeface.create(mEdit.getTypeface(),
                            Typeface.NORMAL));
                else mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD);
                break;
            case ID_BUTTON_I:
                if (mEdit.getTypeface().getStyle()== Typeface.BOLD)
                    mEdit.setTypeface(mEdit.getTypeface(),
                            Typeface.BOLD_ITALIC);
                else if (mEdit.getTypeface().getStyle()== Typeface.BOLD_ITALIC)
                    mEdit.setTypeface(mEdit.getTypeface(),
                            Typeface.BOLD);
                else if (mEdit.getTypeface().getStyle()== Typeface.ITALIC)
                    mEdit.setTypeface(Typeface.create(mEdit.getTypeface(),
                            Typeface.NORMAL));
                else mEdit.setTypeface(mEdit.getTypeface(), Typeface.ITALIC);
            case ID_BUTTON_SANS:
                if (mEdit.getTypeface().getStyle()== Typeface.ITALIC)
                    mEdit.setTypeface(Typeface.SANS_SERIF,
                            Typeface.ITALIC);
                else if (mEdit.getTypeface().getStyle()==
                        Typeface.BOLD_ITALIC)
                    mEdit.setTypeface(Typeface.SANS_SERIF,
                            Typeface.BOLD_ITALIC);
                else if (mEdit.getTypeface().getStyle()== Typeface.BOLD)
                    mEdit.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                else mEdit.setTypeface(Typeface.SANS_SERIF,
                            Typeface.NORMAL);
                break;
            case ID_BUTTON_SERIF:
                if (mEdit.getTypeface().getStyle()== Typeface.ITALIC)
                    mEdit.setTypeface(Typeface.SERIF, Typeface.ITALIC);
                else if (mEdit.getTypeface().getStyle()== Typeface.BOLD_ITALIC)
                    mEdit.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
                else if (mEdit.getTypeface().getStyle()== Typeface.BOLD)
                    mEdit.setTypeface(Typeface.SERIF, Typeface.BOLD);
                else
                    mEdit.setTypeface(Typeface.SERIF, Typeface.NORMAL);
                break;
            case ID_BUTTON_MONOSPACE:
                if (mEdit.getTypeface().getStyle()== Typeface.ITALIC)
                    mEdit.setTypeface(Typeface.MONOSPACE, Typeface.ITALIC);
                else if (mEdit.getTypeface().getStyle()== Typeface.BOLD_ITALIC)
                    mEdit.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
                else if (mEdit.getTypeface().getStyle()== Typeface.BOLD)
                    mEdit.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
                else
                    mEdit.setTypeface(Typeface.MONOSPACE, Typeface.NORMAL);
                break;
        }
    }
}