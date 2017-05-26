package com.zzingobomi.studyenglish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    ///
    /// DB 관련
    ///
    DBManager               mDbManager;

    ///
    ///
    ///
    Random                  mRandom;

    ///
    /// UI 관련
    ///
    TextView                mKorSentenceText;
    TextView                mEngSentenceText;
    TextView                mPageText;
    Button                  mAudioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRandom = new Random();

        mKorSentenceText = (TextView)findViewById(R.id.korsentence);
        mEngSentenceText = (TextView)findViewById(R.id.engsentence);
        mPageText = (TextView)findViewById(R.id.page);
        mAudioButton = (Button)findViewById(R.id.audiobutton);

        // DB 에서 정보 가져오기 (가장 첫번째)
        DBConnect();

        SettingKorEngPageAudio();
    }

    private void DBConnect()
    {
        mDbManager = new DBManager(getApplicationContext());

        //int totalCount = mDbManager.getTotalItemCount();
        //String test1 = mDbManager.getKorSentence(2);
        //String test2 = mDbManager.getEngSentence(3);
        //Log.d("TEST", test1);
        //Log.d("TEST", test2);
        //Log.d("TEST", String.valueOf(totalCount));
    }

    ///
    /// 랜덤으로 인덱스를 추출한 뒤 해당 문장들을 셋팅한다.
    ///
    private void SettingKorEngPageAudio()
    {
        // Audio 버튼 호출 안됨 순서 바꾸면..?
        int curIndex = getRandomIndex();
        Log.d("TEST", String.valueOf(curIndex));

        mKorSentenceText.setText( mDbManager.getKorSentence(curIndex) );
        mEngSentenceText.setText( mDbManager.getEngSentence(curIndex) );
        mPageText.setText( String.valueOf(mDbManager.getPage(curIndex)) );
        mAudioButton.setText( mDbManager.getAudio(curIndex) );
    }

    int getRandomIndex()
    {
        return mRandom.nextInt(mDbManager.getTotalItemCount() - 1) + 1;
    }


    public void ClickNextButton(View v)
    {
        Log.d("TEST", "ClickNextButton");
    }

    public void ClickAudioButton(View v)
    {
        Log.d("TEST", "ClickAudioButton");
    }
}
