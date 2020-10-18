package com.example.dz_1.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dz_1.R;
import java.util.ArrayList;
import java.util.List;

public class FragmentRecycler extends Fragment {
    public static final String SIZE = "size";
    private NumbersAdapter adapter;
    private Context context;
    private List<Integer> numbers;
    private onStartFragmentListener startListener;

    public interface onStartFragmentListener {
        void startFragment(int param);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        try {
            startListener = (onStartFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onStartFragmentListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int size = 100;
        if(savedInstanceState != null) {
            size = savedInstanceState.getInt(SIZE);
        }
        numbers = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }
        adapter = new NumbersAdapter(numbers, startListener);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        int colNum = 3;
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            colNum = 4;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(context, colNum));
        recyclerView.setAdapter(adapter);
        Button button = view.findViewById(R.id.btn);
        button.setOnClickListener(v -> adapter.addData(numbers.size() + 1));
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SIZE, numbers.size());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        adapter = null;
        context = null;
        numbers = null;
        startListener = null;
    }
}
