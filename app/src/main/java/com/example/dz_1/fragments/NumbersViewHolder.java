package com.example.dz_1.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dz_1.R;

public class NumbersViewHolder extends RecyclerView.ViewHolder {
    public final TextView num;

    public NumbersViewHolder(@NonNull View itemView) {
        super(itemView);
        num = itemView.findViewById(R.id.recycler_number);
    }
}
