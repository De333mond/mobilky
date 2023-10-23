package com.example.lab7;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    private String text;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Введите текст");

        final EditText input = new EditText(getActivity());
        builder.setView(input);

        builder.setNegativeButton("Закрыть", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.setPositiveButton("Отобразить текст", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                text = input.getText().toString();
                MyDialogFragmentListener activity =
                        (MyDialogFragmentListener) getActivity();

                activity.onReturnValue(String.valueOf(input.getText()));
            }
        });

        builder.setNeutralButton("Есть дела поважнее..", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getActivity().finish();
            }
        });

        return builder.create();
    }

    public interface MyDialogFragmentListener {
        void onReturnValue(String value);
    }
}


