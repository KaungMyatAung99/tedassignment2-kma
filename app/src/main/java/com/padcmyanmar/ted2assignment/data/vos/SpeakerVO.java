package com.padcmyanmar.ted2assignment.data.vos;

import com.google.gson.annotations.SerializedName;

public class SpeakerVO {

    @SerializedName("speaker_id")
    private String speakerId;

    @SerializedName("name")
    private String speakerName;

    public String getSpeakerId() {
        return speakerId;
    }

    public String getSpeakerName() {
        return speakerName;
    }
}
