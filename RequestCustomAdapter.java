package com.example.shalin.donatetoday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shalin on 04-09-2018.
 */

public class RequestCustomAdapter extends BaseAdapter {

    public List<User> uname;
    private final Context context;
    private final String[] bgrp;
    private final String[] address;
    private final String[] number;

    public RequestCustomAdapter(Context context, List<User> lstusers, String[] bgrp, String[] address, String[] number) {
        // super(context, R.layout.hospital_list, maintitle);
        // TODO Auto-generated constructor stub

        this.context= context;
        this.uname=lstusers;
        this.bgrp=bgrp;
        this.address=address;
        this.number=number;

    }



    @Override
    public int getCount() {
        return uname.size();
    }

    @Override
    public Object getItem(int position) {
        return uname.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(R.layout.request_list, null,true);

        TextView name = rowView.findViewById(R.id.name);
        TextView bgrp = rowView.findViewById(R.id.bgrp);
        TextView address = rowView.findViewById(R.id.address);
        TextView number = rowView.findViewById(R.id.number);

        name.setText("Name: "+uname.get(position).getUname());
        bgrp.setText("BloodGroup Needed: "+uname.get(position).getBgrp());
        address.setText("Address: "+uname.get(position).getAddress());
        number.setText("Phone Number: "+uname.get(position).getNumber());

        return rowView;
    }
}
