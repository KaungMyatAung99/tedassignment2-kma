package com.padcmyanmar.ted2assignment.networks.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.ted2assignment.data.vos.TedTalksVO;

import java.util.List;

public class GetTedTalksResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private  String message;

    @SerializedName("apiVersion")
    private  String apiVersion;

    @SerializedName("page")
    private  String page;

    @SerializedName("ted_talks")
    private List<TedTalksVO> tedTalksVOS;

    public boolean isResponseOK() {
        return (code == 200 && tedTalksVOS != null);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TedTalksVO> getTedTalksVOS() {
        return tedTalksVOS;
    }
}
