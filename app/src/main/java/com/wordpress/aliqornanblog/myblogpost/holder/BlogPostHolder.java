package com.wordpress.aliqornanblog.myblogpost.holder;

/**
 * Created by qornanali on 8/2/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wordpress.aliqornanblog.myblogpost.R;
import com.wordpress.aliqornanblog.myblogpost.model.BlogPost;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BlogPostHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_blog_post_like_count)
    public TextView tvBlogPostLikeCount;
    @BindView(R.id.tv_blog_post_content)
    public TextView tvBlogPostContent;
    @BindView(R.id.tv_blog_post_title)
    public TextView tvBlogPostTitle;
    @BindView(R.id.tv_blog_post_read_more)
    public TextView tvBlogPostReadMore;
    @BindView(R.id.iv_blog_post_thumbnail)
    public ImageView ivBlogPostThumbnail;

    private View itemView;
    private BlogPost item;

    public BlogPostHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.itemView = itemView;
    }

    public void setContent(final BlogPost blogPost) {
        item = blogPost;
        tvBlogPostContent.setText(blogPost.getContent());
        tvBlogPostTitle.setText(blogPost.getTitle());
        tvBlogPostLikeCount.setText(blogPost.getLikeCount());
    }

    public View getItemView() {
        return itemView;
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
    }

    public BlogPost getItem() {
        return item;
    }

    public void setItem(BlogPost item) {
        this.item = item;
    }
}