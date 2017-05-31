package com.zzingobomi.studyenglish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by JONGCHAN on 2017-05-31.
 */

public class MovieCompActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviecomp);

        //mRandom = new Random();

        //mKorSentenceText = (TextView)findViewById(R.id.korsentence);
        //mEngSentenceText = (TextView)findViewById(R.id.engsentence);
        //mPageText = (TextView)findViewById(R.id.page);
        //mAudioButton = (Button)findViewById(R.id.audiobutton);

        // DB 에서 정보 가져오기 (가장 첫번째)
        //DBConnect();

        // 처음 화면 보여주기
        //SettingKorEngPageAudio();
        //SetCurrentState( MainActivity.STATE.KOR_STATE );
    }
}
