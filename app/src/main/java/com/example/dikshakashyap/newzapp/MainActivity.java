package com.example.dikshakashyap.newzapp;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import android.widget.Button;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.jar.JarEntry;

   public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
  String url="https://newsapi.org/v2/everything?q=bitcoin&from=2018-10-17&sortBy=publishedAt&apiKey=947898e158af4db887fdd535e2f8fa24";

    RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
       NetworkInfo networkInfo= connectivityManager.getActiveNetworkInfo();
       if(networkInfo!=null && networkInfo.isConnected()){

           Toast.makeText(this, "Network is available", Toast.LENGTH_SHORT).show();
       }else{

           Toast.makeText(this, "Network is not available.", Toast.LENGTH_SHORT).show();
       }


        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadData();


    }

    private void loadData() {

    StringRequest stringRequest=new StringRequest(url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

          Jsonparse1 jsonparse1=new Jsonparse1(response);
          jsonparse1.jasonmethod();

          MyAdapter myAdapter=new MyAdapter(MainActivity.this,Jsonparse1.author,Jsonparse1.title,Jsonparse1.description,Jsonparse1.url, Jsonparse1.urltoimage,Jsonparse1.publishedAt);
          recyclerView.setAdapter(myAdapter);
          Log.e("Json Data Show",response);

            //Toast.makeText(NameActivity.this, response, Toast.LENGTH_SHORT).show();


        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

        }
    });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}

