package com.example.dz_1.fragments;

import android.graphics.Color;

public class TextColorDelegate {
    public static int getTextColor(int number) {
        return number % 2 == 0 ? Color.RED : Color.BLUE;
    }
}
