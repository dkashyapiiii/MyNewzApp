package com.example.dikshakashyap.newzapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by Diksha kashyap on 07-04-2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{

    String[] author,title,description,url,published;
    String[] urlimage;
    Context context;

    public MyAdapter(Context context,String[] author,String[] title,String[] description,String[] url,String[] urlimage,String[] published){
    this.author=author;
    this.context=context;
    this.title=title;
    this.url=url;
    this.description=description;
    this.urlimage=urlimage;
    this.published=published;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listview,parent,false);

        MyHolder myHolder=new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        holder.tv_author.setText(author[position]);
        holder.tv_title.setText(title[position]);
//        holder.tv_url.setText(url[position]);
        holder.tv_description.setText(description[position]);
        holder.tv_published.setText(published[position]);

        Picasso.with(context)
                .load(urlimage[position])
                .placeholder(R.drawable.aa)
                .into(holder.tv_imageurl);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(context, author[position], Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,WebviewActivity.class);
                intent.putExtra("url",url[position]);
                context.startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return author.length;
    }
    class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_author,tv_url,tv_description,tv_published,tv_title;
        ImageView tv_imageurl;
        LinearLayout linearLayout;

        public MyHolder(View itemView) {
            super(itemView);

            tv_author=itemView.findViewById(R.id.author);
            tv_title=itemView.findViewById(R.id.tv_title);
          //  tv_url=itemView.findViewById(R.id.url);
            tv_imageurl=itemView.findViewById(R.id.newzimage);
            linearLayout=itemView.findViewById(R.id.linear);
            tv_description=itemView.findViewById(R.id.description);
            tv_published=itemView.findViewById(R.id.published);


        }
    }
}
