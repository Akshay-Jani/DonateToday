package com.example.shalin.donatetoday;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
 * Created by Shalin on 02-09-2018.
 */

public class Hospitals extends AppCompatActivity {

    ListView lstview;
    TextView tv ;
    User userSelected = null;
    List<User> users = new ArrayList<User>();
    String[] catagory ;
    String uname;
    String hnumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospitals);
        lstview=findViewById(R.id.lstview);
        tv = findViewById(R.id.name);

        new GetData().execute(Common.getAddressAPI());

        addItemClickListener();

    }

    private void addItemClickListener() {


        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                uname = users.get(position).getName();
                hnumber = users.get(position).getHnumber();

                //
                //  tv.setText(uname);
                Intent h = new Intent(Hospitals.this,Details.class);
                h.putExtra("name",uname);
                h.putExtra("hnumber",hnumber);
                startActivity(h);
            }
        });

    }

    class GetData  extends AsyncTask<String,Void,String> {

        ProgressDialog pd = new ProgressDialog(Hospitals.this);


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

            HospitalCustomAdapter adapter=new HospitalCustomAdapter(getApplicationContext(),users,catagory);
            lstview.setAdapter(adapter);

            pd.dismiss();
        }

    }
}
