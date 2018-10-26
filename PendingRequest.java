package com.example.shalin.donatetoday;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shalin on 04-09-2018.
 */

public class PendingRequest extends AppCompatActivity {

    ListView lstview;
    TextView tv ;
    User userSelected = null;
    List<User> users = new ArrayList<User>();
    String[] bgrp ;
    String[] address;
    String[] number;

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pending_request);
        lstview=findViewById(R.id.lstview);

        new GetData().execute(Common.getAddressAPI1());

        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    class GetData  extends AsyncTask<String,Void,String> {

        ProgressDialog pd = new ProgressDialog(PendingRequest.this);


        protected void onPreExecute() {
            super.onPreExecute();

            pd.setTitle("please wait...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {

            String stream = null;
            String urlString = strings[0];

            HTTPDataHandler http = new HTTPDataHandler();
            stream = http.gethttpdata(urlString);
            return stream;
        }

        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Gson gson = new Gson();
            Type listType = new TypeToken<List<User>>(){}.getType();
            users = gson.fromJson(s,listType);
            RequestCustomAdapter adapter=new RequestCustomAdapter(getApplicationContext(),users,bgrp,address,number);
            lstview.setAdapter(adapter);

            //pd.dismiss();
        }

    }
}
