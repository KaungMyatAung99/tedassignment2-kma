package com.padcmyanmar.ted2assignment.data.vos;

public class TedPodcastsVO {

    private  int podcastId;
    private String title;
    private String imageURL;
    private String description;

    private SegmantsVO segmantsVOs;

    public int getPodcastId() {
        return podcastId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDescription() {
        return description;
    }

    public SegmantsVO getSegmantsVOs() {
        return segmantsVOs;
    }
}
