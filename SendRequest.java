package com.example.shalin.donatetoday;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SendRequest extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] bgroup = { "O+", "O-", "A+", "A-", "AB+", "AB-","B+","B-"};
    EditText uname,uaddress,unumber;
    TextView setname;
    Button submit;
    String name,address,number,bgrp;
    private final static int uniqueID = 45612;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_request);

        submit = findViewById(R.id.submit);
        uname = findViewById(R.id.uname);
        uaddress = findViewById(R.id.uaddress);
        unumber = findViewById(R.id.unumber);

        Spinner spin = (Spinner) findViewById(R.id.ubgrp);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bgroup);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        addOnClickListener();

    }

    private void addOnClickListener() {

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = uname.getText().toString();
                address = uaddress.getText().toString();
                number = unumber.getText().toString();
                new PostData().execute(Common.getAddressAPI1());

                NotificationCompat.Builder builder = new NotificationCompat.Builder(SendRequest.this);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                PendingIntent pendingIntent = PendingIntent.getActivity(SendRequest.this,01,intent,0);
                builder.setContentIntent(pendingIntent);
                builder.setDefaults(Notification.DEFAULT_ALL);
                builder.setContentTitle("Donate Today");
                builder.setContentText("Blood required");
                builder.setSmallIcon(R.drawable.blood_bank);
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(uniqueID, builder.build());
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        bgrp = bgroup[position];

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    class PostData extends AsyncTask<String, String, String> {


//        protected final String name;
        ProgressDialog pd = new ProgressDialog(SendRequest.this);

      //  private PostData(String name) {
        //    this.name = name;
        //}

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setTitle("Please Wait...");
            pd.show();
            pd.dismiss();
        }

        @TargetApi(Build.VERSION_CODES.KITKAT)
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(String... strings) {

            String urlString = strings[0];

            HTTPDataHandler hh = new HTTPDataHandler();

            String json = "{\"pname\":\"" + name + "\", \"bloodgroup\":\"" + bgrp + "\", \"address\":\"" + address + "\", \"number\":\"" + number + "\"}";
            hh.posthttpdata(urlString, json);
            return null;
        }
    }
}
