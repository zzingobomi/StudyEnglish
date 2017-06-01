package com.zzingobomi.studyenglish;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by JONGCHAN on 2017-05-31.
 */

public class Word1004Activity extends AppCompatActivity
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
    TextView                mKorWordText;
    TextView                mEngWordText;
    TextView                mWordKindText;

    ///
    /// 현재 상태 모습
    ///
    enum STATE
    {
        KOR_STATE,
        ENG_STATE
    };
    STATE                   mCurState = STATE.KOR_STATE;
    int                     mCurIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word1004);

        mRandom = new Random();

        mKorWordText = (TextView)findViewById(R.id.korword);
        mEngWordText = (TextView)findViewById(R.id.engword);
        mWordKindText = (TextView)findViewById(R.id.wordkind);

        // DB 에서 정보 가져오기
        DBConnect();

        // 처음 화면 보여주기
        SettingKorEngWordKind();
        SetCurrentState( Word1004Activity.STATE.KOR_STATE );
    }

    private void DBConnect()
    {
        mDbManager = new DBManager(getApplicationContext());
    }

    ///
    /// 랜덤으로 인덱스를 추출한 뒤 해당 문장들을 셋팅한다.
    ///
    private void SettingKorEngWordKind()
    {
        int curIndex = getRandomIndex();
        mCurIndex = curIndex;
        Log.d("TEST", String.valueOf(curIndex));

        mKorWordText.setText( mDbManager.getKorWord1004(curIndex) );
        mEngWordText.setText( mDbManager.getEngWord1004(curIndex) );
        mWordKindText.setText( mDbManager.getWordKindWord1004(curIndex) );
    }

    void SetCurrentState(Word1004Activity.STATE curState)
    {
        if( curState == Word1004Activity.STATE.KOR_STATE )
        {
            mKorWordText.setVisibility(View.VISIBLE);

            mEngWordText.setVisibility(View.GONE);
            mWordKindText.setVisibility(View.GONE);
        }
        else
        {
            mKorWordText.setVisibility(View.GONE);

            mEngWordText.setVisibility(View.VISIBLE);
            mWordKindText.setVisibility(View.VISIBLE);
        }
    }

    int getRandomIndex()
    {
        return mRandom.nextInt(mDbManager.getTotalItemCountWord1004() - 1) + 1;
    }

    ///
    /// 화면을 눌렀을 때 호출되는 함수
    ///
    public void ClickNextButton(View v)
    {
        //Log.d("TEST", "ClickNextButton");

        if( mCurState == Word1004Activity.STATE.KOR_STATE )
        {
            SetCurrentState( Word1004Activity.STATE.ENG_STATE );
            mCurState = Word1004Activity.STATE.ENG_STATE;
        }
        else
        {
            SettingKorEngWordKind();
            SetCurrentState( Word1004Activity.STATE.KOR_STATE );
            mCurState = Word1004Activity.STATE.KOR_STATE;
        }
    }
}