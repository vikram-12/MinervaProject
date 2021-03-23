package com.example.minervaproject;

import android.view.View;
import android.widget.TextView;

public class DocViewHolder {
    TextView programTitle;
    DocViewHolder(View v)
    {
        programTitle = v.findViewById(R.id.textView1);
    }
}
