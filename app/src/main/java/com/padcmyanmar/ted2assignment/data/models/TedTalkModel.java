package com.padcmyanmar.ted2assignment.data.models;

import com.padcmyanmar.ted2assignment.networks.HttpUrlConnectionDataAgentImpl;
import com.padcmyanmar.ted2assignment.networks.TedTalkDataAgents;

public class TedTalkModel {

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private static TedTalkModel objInstance;

    private TedTalkDataAgents ttDataAgent;

    private TedTalkModel() {
        ttDataAgent = HttpUrlConnectionDataAgentImpl.getObiInstance();
    }

    public static TedTalkModel getObjInstance() {
        if (objInstance == null)
            objInstance = new TedTalkModel();
        return objInstance;
    }

    public void loadTedTalk() {
        ttDataAgent.loadTedTalk(1, DUMMY_ACCESS_TOKEN);
    }
}
