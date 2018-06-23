package com.padcmyanmar.ted2assignment.events;

import com.padcmyanmar.ted2assignment.data.vos.TedTalksVO;

import java.util.List;

public class SuccessGetTedTalksEvent {

    private List<TedTalksVO> TedTalksList;

    public List<TedTalksVO> getTedTalksList() {
        return TedTalksList;
    }

    public SuccessGetTedTalksEvent(List<TedTalksVO> TedTalksList) {
        this.TedTalksList = TedTalksList;
    }

}
