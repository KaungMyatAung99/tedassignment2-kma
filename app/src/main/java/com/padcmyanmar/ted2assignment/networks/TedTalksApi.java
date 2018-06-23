package com.padcmyanmar.ted2assignment.networks;

import com.padcmyanmar.ted2assignment.networks.responses.GetTedTalksResponse;
import com.padcmyanmar.ted2assignment.utils.TedConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TedTalksApi {

    @FormUrlEncoded
    @POST(TedConstants.GET_NEWS)
    Call<GetTedTalksResponse> loadTedTalksList(
            @Field(TedConstants.PARAM_ACCESS_TOKEN) String accessToken,
            @Field(TedConstants.PARAM_PAGE) int page);
}
