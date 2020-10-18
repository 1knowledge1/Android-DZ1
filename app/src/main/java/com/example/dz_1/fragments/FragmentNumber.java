package com.example.dz_1.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.dz_1.R;

public class FragmentNumber extends Fragment {
    private static final String PARAM = "param";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_number, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String text = getString(R.string.no_value);
        int color = Color.BLUE;
        Bundle arg = getArguments();
        if (arg != null) {
            text = arg.getString(PARAM);
            try {
                int number = Integer.parseInt(text);
                if (number % 2 == 0) {
                    color = Color.RED;
                }
            } catch (NumberFormatException | NullPointerException e) {
                text = getString(R.string.no_value);
            }
        }
        ((TextView)view.findViewById(R.id.number)).setTextColor(color);
        ((TextView)view.findViewById(R.id.number)).setText(text);
    }

    public static FragmentNumber newInstance(int param) {
        FragmentNumber fragment = new FragmentNumber();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM, String.valueOf(param));
        fragment.setArguments(bundle);
        return fragment;
    }
}
