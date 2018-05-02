package com.example.bishoy.apt_lab1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bishoy on 5/2/18.
 */

class CustomAdapter extends ArrayAdapter<Reminder> {
    public CustomAdapter(@NonNull Context context, List<Reminder> reminders) {
        super(context,R.layout.reminders_row ,reminders);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View view=inflater.inflate(R.layout.reminders_row,parent,false);

        Reminder singlereminder=getItem(position);
        TextView text=(TextView) view.findViewById(R.id.rowtext);
        ImageView important=(ImageView) view.findViewById(R.id.rowimportant);

        text.setText(singlereminder.text);
        if(singlereminder.important)
            important.setVisibility(View.VISIBLE);
        else
            important.setVisibility(View.INVISIBLE);
        return view;
    }
}
