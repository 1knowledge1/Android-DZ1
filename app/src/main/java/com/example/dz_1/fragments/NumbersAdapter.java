package com.example.dz_1.fragments;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dz_1.R;
import java.util.List;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersViewHolder> {
    private List<Integer> mData;
    private FragmentRecycler.onStartFragmentListener startListener;

    public NumbersAdapter(List<Integer> data, FragmentRecycler.onStartFragmentListener listener) {
        mData = data;
        startListener = listener;
    }

    @NonNull
    @Override
    public NumbersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.numbers_layout, parent, false);
        return new NumbersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumbersViewHolder holder, int position) {
        int number = mData.get(position);
        if (number % 2 == 0) {
            holder.num.setTextColor(Color.RED);
        } else {
            holder.num.setTextColor(Color.BLUE);
        }
        holder.num.setText(String.valueOf(number));
        holder.itemView.setOnClickListener(v -> {
            int num = Integer.parseInt(((TextView) v.findViewById(R.id.recycler_number)).getText().toString());
            startListener.startFragment(num);
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addData(int number) {
        mData.add(number);
        notifyItemInserted(mData.size() - 1);
    }
}
