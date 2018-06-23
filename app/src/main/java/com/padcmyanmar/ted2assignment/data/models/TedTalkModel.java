package com.padcmyanmar.ted2assignment.data.models;

import com.padcmyanmar.ted2assignment.data.vos.TedTalksVO;
import com.padcmyanmar.ted2assignment.events.SuccessGetTedTalksEvent;
import com.padcmyanmar.ted2assignment.networks.HttpUrlConnectionDataAgentImpl;
import com.padcmyanmar.ted2assignment.networks.OKHttpDataAgentImpl;
import com.padcmyanmar.ted2assignment.networks.RetrofitDataAgentImpl;
import com.padcmyanmar.ted2assignment.networks.TedTalkDataAgents;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class TedTalkModel {

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private static TedTalkModel objInstance;

    private TedTalkDataAgents ttDataAgent;

    private Map<String, TedTalksVO> mTedTalksMap;

    private TedTalkModel() {
        //ttDataAgent = HttpUrlConnectionDataAgentImpl.getObiInstance();
        //ttDataAgent = OKHttpDataAgentImpl.getInstance();
        ttDataAgent = RetrofitDataAgentImpl.getInstance();
        mTedTalksMap = new HashMap<>();
    }

    public static TedTalkModel getObjInstance() {
        if (objInstance == null)
            objInstance = new TedTalkModel();
        return objInstance;
    }

    public void loadTedTalk() {
        ttDataAgent.loadTedTalk(1, DUMMY_ACCESS_TOKEN);
    }


    public TedTalksVO getNewsById(String newsId) {
        return mTedTalksMap.get(newsId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetTedTalks(SuccessGetTedTalksEvent event) {
        for (TedTalksVO talks : event.getTedTalksList())
            mTedTalksMap.put(talks.getTalkId(), talks);

    }
}
