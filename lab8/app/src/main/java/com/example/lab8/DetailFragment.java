package com.example.lab8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
    public void setSelectedItem(String selectedItem) {
        TextView desc = getView().findViewById(R.id.detailsText);
        ImageView photo = getView().findViewById(R.id.photo);
        switch (selectedItem) {
            case "Ветреница дубравная (Anemone nemorosa)":
                desc.setText(R.string.Anemone_desc);
                photo.setImageResource(R.drawable.anemone);
                break;
            case "Горянка (Epimedium)":
                desc.setText(R.string.Epimedium_desc);
                photo.setImageResource(R.drawable.epimedium);
                break;
// ...
        }
    }
}