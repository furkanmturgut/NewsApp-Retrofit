package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {
    ArrayList<String> imageList;
    ArrayList<String> titleList;
    ArrayList<String> authorList;
    ArrayList<String> contentList;
    ArrayList<String> webUrlList;
    Context context;

    public RecyclerViewAdapter(ArrayList<String> imageList, ArrayList<String> titleList, ArrayList<String> authorList,ArrayList<String> contentList ,ArrayList<String> webUrlList ,Context context) {
        this.imageList = imageList;
        this.titleList = titleList;
        this.authorList = authorList;
        this.webUrlList = webUrlList;
        this.contentList = contentList;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_view,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyHolder holder, int position) {
        holder.textAuthor.setText(authorList.get(position));
        holder.textTitle.setText(titleList.get(position));
        Picasso.with(holder.imageNews.getContext()).load(imageList.get(position)).into(holder.imageNews);

    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageNews;
        TextView textTitle,textAuthor;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imageNews = itemView.findViewById(R.id.image_news);
            textTitle = itemView.findViewById(R.id.textTitle);
            textAuthor = itemView.findViewById(R.id.textAuthor);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context,NewsDetailActivity.class);
            intent.putExtra("image",imageList.get(position));
            intent.putExtra("content",contentList.get(position));
            intent.putExtra("url",webUrlList.get(position));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }
}
