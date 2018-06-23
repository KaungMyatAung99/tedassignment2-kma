package com.padcmyanmar.ted2assignment.networks;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.padcmyanmar.ted2assignment.events.ApiErrorEvent;
import com.padcmyanmar.ted2assignment.events.SuccessGetTedTalksEvent;
import com.padcmyanmar.ted2assignment.networks.responses.GetTedTalksResponse;
import com.padcmyanmar.ted2assignment.utils.TedConstants;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpDataAgentImpl implements TedTalkDataAgents {

    public static OKHttpDataAgentImpl sObjInstance;

    public static OKHttpDataAgentImpl getInstance() {
        if (sObjInstance == null) {
            sObjInstance = new OKHttpDataAgentImpl();
        }
        return sObjInstance;
    }

    private OkHttpClient mHttpClient;

    private OKHttpDataAgentImpl() {
        mHttpClient = new OkHttpClient.Builder() //1.
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }


    @Override
    public void loadTedTalk(final int page, final String accessTaken) {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... voids) {
                RequestBody formBody = new FormBody.Builder() //2.
                        .add(TedConstants.PARAM_ACCESS_TOKEN, accessTaken)
                        .add((TedConstants.PARAM_PAGE), String.valueOf(page))
                        .build();

                Request request = new Request.Builder() //3
                        .url(TedConstants.API_BASE + TedConstants.GET_NEWS)
                        .post(formBody)
                        .build();

                try {
                    Response response = mHttpClient.newCall(request).execute(); //4.
                    if (response.isSuccessful()) {
                        String responseString = response.body().string();

                        return responseString;
                    } else {
                        //AttractionModel.getInstance().notifyErrorInLoadingAttractions(response.message());
                    }
                } catch (IOException e) {
                    Log.e("", e.getMessage());
                }

                return null;
            }

            @Override
            protected void onPostExecute(String responseString) {
                super.onPostExecute(responseString);
                Gson gson = new Gson();
                GetTedTalksResponse TalksResponse = gson.fromJson(responseString, GetTedTalksResponse.class);
                Log.d("OnPostExecute", "NewsListSize : " + TalksResponse.getTedTalksVOS().size());

                if (TalksResponse.isResponseOK()) {

                    SuccessGetTedTalksEvent successGetTalksEvent = new SuccessGetTedTalksEvent(TalksResponse.getTedTalksVOS());
                    EventBus.getDefault().post(successGetTalksEvent);
                } else {
                    ApiErrorEvent apiErrorEvent = new ApiErrorEvent(TalksResponse.getMessage());
                    EventBus.getDefault().post(apiErrorEvent);
                }
            }
        }.execute();
    }
}
