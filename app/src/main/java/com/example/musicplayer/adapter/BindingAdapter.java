package com.example.musicplayer.adapter;

import android.graphics.Typeface;
import android.widget.TextView;

public class BindingAdapter {
    public static void setBold(TextView view, boolean isBold) {
        if (isBold) {
            view.setTypeface(null, Typeface.BOLD);
        } else {
            view.setTypeface(null, Typeface.NORMAL);
        }
    }
}
