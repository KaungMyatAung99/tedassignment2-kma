package com.padcmyanmar.ted2assignment.networks;

import com.padcmyanmar.ted2assignment.events.ApiErrorEvent;
import com.padcmyanmar.ted2assignment.events.SuccessGetTedTalksEvent;
import com.padcmyanmar.ted2assignment.networks.responses.GetTedTalksResponse;
import com.padcmyanmar.ted2assignment.utils.TedConstants;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements TedTalkDataAgents {

    private static RetrofitDataAgentImpl sObjInstance;

    private TedTalksApi mTheApi;

    private RetrofitDataAgentImpl() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder() //1.
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TedConstants.API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mTheApi = retrofit.create(TedTalksApi.class);
    }

    public static RetrofitDataAgentImpl getInstance() {
        if (sObjInstance == null) {
            sObjInstance = new RetrofitDataAgentImpl();
        }
        return sObjInstance;
    }

    @Override
    public void loadTedTalk(int page, String accessTaken) {
        Call<GetTedTalksResponse> loadNewsCall = mTheApi.loadTedTalksList(accessTaken, page);
        loadNewsCall.enqueue(new Callback<GetTedTalksResponse>() {
            @Override
            public void onResponse(Call<GetTedTalksResponse> call, Response<GetTedTalksResponse> response) {
                GetTedTalksResponse TalksResponse = response.body();
                if (TalksResponse != null & TalksResponse.isResponseOK()) {
                    SuccessGetTedTalksEvent event = new SuccessGetTedTalksEvent(TalksResponse.getTedTalksVOS());
                    EventBus.getDefault().post(event);
                } else {
                    if (TalksResponse == null) {
                        ApiErrorEvent apiErrorEvent = new ApiErrorEvent("Empty response or network call");
                        EventBus.getDefault().post(apiErrorEvent);
                    } else {
                        ApiErrorEvent apiErrorEvent = new ApiErrorEvent(TalksResponse.getMessage());
                        EventBus.getDefault().post(apiErrorEvent);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetTedTalksResponse> call, Throwable t) {
                ApiErrorEvent apiErrorEvent = new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(apiErrorEvent);
            }
        });
    }


}
