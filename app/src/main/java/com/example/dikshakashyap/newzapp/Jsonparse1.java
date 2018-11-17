package com.example.dikshakashyap.newzapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Diksha kashyap on 07-04-2018.
 */

public class Jsonparse1 {

    String json;
   public static String[] author,title,description,url,publishedAt;
   public static String[] urltoimage;


    public Jsonparse1(String j){
        this.json=j;
    }


    public void jasonmethod()
    {

        try {
            JSONObject obj=new JSONObject(json);
            JSONArray array=obj.getJSONArray("articles");

            author=new String[array.length()];
            title=new String[array.length()];
            description=new String[array.length()];
            url=new String[array.length()];
            urltoimage=new String[array.length()];
            publishedAt=new String[array.length()];

            for(int i=0;i<array.length();i++)
            {
                JSONObject param=array.getJSONObject(i);
                author[i]=param.getString("author");
                title[i]=param.getString("title");
                description[i]=param.getString("description");
                url[i]=param.getString("url");
                publishedAt[i]=param.getString("publishedAt");
                urltoimage[i]=param.getString("urlToImage");
            }

       } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
