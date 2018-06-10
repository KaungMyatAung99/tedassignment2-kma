package com.padcmyanmar.ted2assignment.data.vos;

import java.util.List;

public class TedTalksVO {
    private int talkId;
    private String title;

    private SpeakerVO speakerVOs;

    private String imageUrl;
    private int durationInSec;
    private String description;

    private List<TagVO> tagVos;

    public int getTalkId() {
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

    public int getDurationInSec() {
        return durationInSec;
    }

    public String getDescription() {
        return description;
    }

    public List<TagVO> getTagVos() {
        return tagVos;
    }
}
