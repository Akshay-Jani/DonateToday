package com.example.shalin.donatetoday;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details extends Hospitals {

    Button call,map;
    String uname,hnumber;
    TextView name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        call = findViewById(R.id.call);
        name = findViewById(R.id.hospitalname);
        map = findViewById(R.id.map);

        uname = getIntent().getExtras().getString("name");
        hnumber = getIntent().getExtras().getString("hnumber");

        name.setText(getIntent().getExtras().getString("name"));
        call.setText("call  "+uname);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+hnumber));
                startActivity(c);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+uname+", Gujarat, India"));
                startActivity(m);
            }
        });

    }
}
