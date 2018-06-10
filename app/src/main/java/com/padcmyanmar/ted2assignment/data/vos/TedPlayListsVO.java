package com.padcmyanmar.ted2assignment.data.vos;

public class TedPlayListsVO {

    private int platListId;
    private String Title;
    private String imageURL;
    private int totalTalks;
    private String description;

    private TedTalksVO tedTalksVOs;

    public int getPlatListId() {
        return platListId;
    }

    public String getTitle() {
        return Title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getTotalTalks() {
        return totalTalks;
    }

    public String getDescription() {
        return description;
    }

    public TedTalksVO getTedTalksVOs() {
        return tedTalksVOs;
    }
}
