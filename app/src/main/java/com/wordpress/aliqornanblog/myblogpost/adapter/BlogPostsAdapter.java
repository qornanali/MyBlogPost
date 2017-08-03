package com.wordpress.aliqornanblog.myblogpost.adapter;

/**
 * Created by qornanali on 8/2/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.wordpress.aliqornanblog.myblogpost.R;
import com.wordpress.aliqornanblog.myblogpost.holder.BlogPostHolder;
import com.wordpress.aliqornanblog.myblogpost.model.BlogPost;

import java.util.List;

public abstract class BlogPostsAdapter extends RecyclerView.Adapter<BlogPostHolder> {

    private List<BlogPost> dataList;
    private Context context;

    public BlogPostsAdapter(List<BlogPost> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public BlogPostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BlogPostHolder(
                LayoutInflater.from(
                        parent.getContext()).inflate(
                        R.layout.item_blog_post, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(final BlogPostHolder holder, final int position) {
        holder.setContent(dataList.get(position));
        Picasso.with(context)
                .load(holder.getItem().getFeaturedImage())
                .error(R.color.black_purple)
                .resize(200, 150).centerCrop()
                .into(holder.ivBlogPostThumbnail);
        holder.tvBlogPostReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onReadMoreClick(holder.getItem().getShortUrl());
            }
        });
    }

    public abstract void onReadMoreClick(String url);

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
