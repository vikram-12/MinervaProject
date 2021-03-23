package com.example.minervaproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.minervaproject.DocViewHolder;
import com.example.minervaproject.R;
import com.google.android.gms.common.util.Strings;

public class DocAdapter extends ArrayAdapter<String> {
    Context context;
    String[] programName;
    String [] urls;

    public DocAdapter(Context context, String [] programName, String [] urls) {
        super(context, R.layout.single_item,R.id.textView1,programName);
        this.context=context;
        this.programName=programName;
        this.urls=urls;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View singleItem = convertView;
        DocViewHolder holder = null;
        if(singleItem == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.single_item,parent,false);
            holder = new DocViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else{
            holder = (DocViewHolder) singleItem.getTag();
        }
        holder.programTitle.setText(programName[position]);
        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getContext(),"You clicked:"+programName[position],Toast.LENGTH_SHORT).show();
                Intent openLinksIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                context.startActivity(openLinksIntent);
            }
        });
        return singleItem;
    }
}
