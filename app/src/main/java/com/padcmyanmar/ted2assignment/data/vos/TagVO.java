package com.padcmyanmar.ted2assignment.data.vos;

import com.google.gson.annotations.SerializedName;

public class TagVO {

    @SerializedName("tag_id")
    private int tagId;

    @SerializedName("tag")
    private String tag;

    @SerializedName("description")
    private String tagDescription;

    public int getTagId() {
        return tagId;
    }

    public String getTag() {
        return tag;
    }

    public String getTagDescription() {
        return tagDescription;
    }
}
