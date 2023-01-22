package com.example.eyemedicationapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class EventListItemAdapter extends ArrayAdapter<EventPrescription> {

    public EventListItemAdapter(@NonNull Context context, @NonNull List<EventPrescription> objects) {
        super(context, R.layout.layout_event_list_item, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_event_list_item,parent,false);
        }
        EventPrescription e = getItem(position);
        TextView name = (TextView) convertView.findViewById(R.id.event_item_name);
        name.setText(e.prescriptionName);

        TextView eye = (TextView) convertView.findViewById(R.id.eye_type);
        eye.setText(e.targetEye);

        TextView time = (TextView) convertView.findViewById(R.id.event_item_time);
        time.setText(e.dateTime.toString());

        return convertView;
    }
}
