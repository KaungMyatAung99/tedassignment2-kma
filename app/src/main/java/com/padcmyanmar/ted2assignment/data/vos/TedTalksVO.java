package com.padcmyanmar.ted2assignment.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TedTalksVO {

    @SerializedName("talk_id")
    private String talkId;

    @SerializedName("title")
    private String title;

    @SerializedName("speaker")
    private SpeakerVO speakerVOs;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("durationInSec")
    private String durationInSec;

    @SerializedName("description")
    private String description;

    @SerializedName("tag")
    private List<TagVO> tagVos;

    public String getTalkId() {
        return talkId;
    }

    public String getTitle() {
        return title;
    }

    public SpeakerVO getSpeakerVOs() {
        return speakerVOs;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDurationInSec() {
        return durationInSec;
    }

    public String getDescription() {
        return description;
    }

    public List<TagVO> getTagVos() {
        return tagVos;
    }
}
