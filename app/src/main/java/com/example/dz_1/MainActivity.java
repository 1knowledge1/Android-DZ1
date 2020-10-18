package com.example.dz_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.example.dz_1.fragments.FragmentNumber;
import com.example.dz_1.fragments.FragmentRecycler;

public class MainActivity extends AppCompatActivity implements FragmentRecycler.onStartFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new FragmentRecycler())
                    .commitAllowingStateLoss();
        }
    }

    @Override
    public void startFragment(int param) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, FragmentNumber.newInstance(param));
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }
}