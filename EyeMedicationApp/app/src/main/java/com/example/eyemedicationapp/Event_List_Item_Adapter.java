package com.example.eyemedicationapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.List;

public class Event_List_Item_Adapter extends ArrayAdapter<Event> {

    public Event_List_Item_Adapter(@NonNull Context context, @NonNull List<Event> objects) {
        super(context, R.layout.layout_event_list_item, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_event_list_item,parent,false);
        }
        Event e = getItem(position);
        TextView name = (TextView) convertView.findViewById(R.id.event_item_name);
        name.setText(e.prescription.name);

        TextView eye = (TextView) convertView.findViewById(R.id.eye_type);
        eye.setText(e.prescription.eye);

        TextView time = (TextView) convertView.findViewById(R.id.event_item_time);
        time.setText(e.dateTime.toString());

        return convertView;
    }
}
