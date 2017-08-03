package com.wordpress.aliqornanblog.myblogpost.model;

/**
 * Created by qornanali on 8/3/17.
 */

import java.util.List;


public class Result {

    private String found;
    private List<BlogPost> posts;

    public String getFound() {
        return found;
    }

    public void setFound(String found) {
        this.found = found;
    }

    public List<BlogPost> getPosts() {
        return posts;
    }

    public void setPosts(List<BlogPost> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Result{" +
                "found='" + found + '\'' +
                ", posts=" + posts +
                '}';
    }
}
