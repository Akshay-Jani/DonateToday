package com.example.shalin.donatetoday;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Shalin on 23-07-2018.
 */

public class HospitalCustomAdapter extends BaseAdapter {

    public List<User> name;

    private final Context context;
    private final String[] catagory;
    public HospitalCustomAdapter(Context context, List<User> lstusers, String[] catagory) {
       // super(context, R.layout.hospital_list, maintitle);
        // TODO Auto-generated constructor stub

        this.context= context;
        this.name=lstusers;
        this.catagory=catagory;

    }

    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int position) {
        return name.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(R.layout.hospital_list, null,true);

        String mediator = name.get(position).getHimage().substring(name.get(position).getHimage().indexOf(",")+1);

        byte[] decodeString = Base64.decode(mediator,Base64.DEFAULT);
        Bitmap decoded = BitmapFactory.decodeByteArray(decodeString,0,decodeString.length);

        TextView titleText = rowView.findViewById(R.id.hospital);
        TextView subtitleText = rowView.findViewById(R.id.catagory);
        ImageView imageView = rowView.findViewById(R.id.icon);

        imageView.setImageBitmap(decoded);
        titleText.setText((CharSequence) name.get(position).getName());
        subtitleText.setText(name.get(position).getCatagory());


        return rowView;

    }
}
