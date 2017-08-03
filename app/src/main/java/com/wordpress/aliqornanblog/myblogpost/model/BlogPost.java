package com.wordpress.aliqornanblog.myblogpost.model;

/**
 * Created by qornanali on 8/2/17.
 */

import com.google.gson.annotations.SerializedName;

public class BlogPost {

    @SerializedName("ID")
    private String id;
    @SerializedName("site_ID")
    private String siteId;
    private String date;
    private String modified;
    private String title;
    @SerializedName("short_URL")
    private String shortUrl;
    private String content;
    private String excerpt;
    @SerializedName("like_count")
    private String likeCount;
    @SerializedName("featured_image")
    private String featuredImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(String featuredImage) {
        this.featuredImage = featuredImage;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id='" + id + '\'' +
                ", siteId='" + siteId + '\'' +
                ", date='" + date + '\'' +
                ", modified='" + modified + '\'' +
                ", title='" + title + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", content='" + content + '\'' +
                ", excerpt='" + excerpt + '\'' +
                ", likeCount='" + likeCount + '\'' +
                ", featuredImage='" + featuredImage + '\'' +
                '}';
    }
}
