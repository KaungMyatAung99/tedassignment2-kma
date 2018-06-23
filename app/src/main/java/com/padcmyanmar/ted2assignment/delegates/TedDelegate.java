package com.padcmyanmar.ted2assignment.delegates;

import com.padcmyanmar.ted2assignment.data.vos.TedTalksVO;

public interface TedDelegate {
    void onTapList(TedTalksVO talks);
    void onSearch(TedTalksVO talks);
}
