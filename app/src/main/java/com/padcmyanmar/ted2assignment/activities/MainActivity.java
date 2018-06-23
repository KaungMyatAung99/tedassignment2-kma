package com.padcmyanmar.ted2assignment.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.padcmyanmar.ted2assignment.R;
import com.padcmyanmar.ted2assignment.adapters.TedTalkAdapter;
import com.padcmyanmar.ted2assignment.data.models.TedTalkModel;
import com.padcmyanmar.ted2assignment.data.vos.TedTalksVO;
import com.padcmyanmar.ted2assignment.delegates.TedDelegate;
import com.padcmyanmar.ted2assignment.events.SuccessGetTedTalksEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity implements TedDelegate {

    private TedTalkAdapter tedTalkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RecyclerView recyclerView = findViewById(R.id.rv_ted);
        tedTalkAdapter = new TedTalkAdapter(this);
        recyclerView.setAdapter(tedTalkAdapter);
        recyclerView.setLayoutManager((new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false)));


        TedTalkModel.getObjInstance().loadTedTalk();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onTapList(TedTalksVO talks) {
        Intent intent = new Intent(getApplicationContext(),TedTalksDetailActivity.class);
        intent.putExtra("newsId",talks.getTalkId());
        startActivity(intent);
    }

    @Override
    public void onSearch(TedTalksVO talks) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetTalks(SuccessGetTedTalksEvent event) {
        Log.d("onSuccessGetNews", "onSuccessGetNews : " + event.getTedTalksList());
        tedTalkAdapter.setTalksList(event.getTedTalksList());
    }







    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
