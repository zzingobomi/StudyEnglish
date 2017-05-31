package com.zzingobomi.studyenglish;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    ///
    /// Main UI 관련
    ///
    Button      mBtnMidAngel;               // 미드 천사
    Button      mBtnMovieComp;              // 영화 영작
    Button      mBtnIrregularVerb;          // 불규칙 동사
    Button      mBtnWord1004;               // 1004 어휘


    /*
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

    ///
    /// Media Player
    ///
    MediaPlayer             mMediaPlayer;
    */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnMidAngel        = (Button)findViewById(R.id.midangelbutton);
        mBtnMovieComp       = (Button)findViewById(R.id.moviecompbutton);
        mBtnIrregularVerb   = (Button)findViewById(R.id.irregularverbbutton);
        mBtnWord1004        = (Button)findViewById(R.id.word1004button);




        //mRandom = new Random();

        //mKorSentenceText = (TextView)findViewById(R.id.korsentence);
        //mEngSentenceText = (TextView)findViewById(R.id.engsentence);
        //mPageText = (TextView)findViewById(R.id.page);
        //mAudioButton = (Button)findViewById(R.id.audiobutton);

        // DB 에서 정보 가져오기 (가장 첫번째)
        //DBConnect();

        // 처음 화면 보여주기
        //SettingKorEngPageAudio();
        //SetCurrentState( STATE.KOR_STATE );
    }

    ///
    /// 랜덤으로 인덱스를 추출한 뒤 해당 문장들을 셋팅한다.
    ///
    void ClickStudySelect(View v)
    {
        switch (v.getId())
        {
            case R.id.midangelbutton:
                openMidAngelActivity();
                break;

            case R.id.moviecompbutton:
                openMovieCompActivity();
                break;

            case R.id.irregularverbbutton:
                openIrregularVerbActivity();
                break;

            case R.id.word1004button:
                openWord1004Activity();
                break;
        }
    }

    private void openMidAngelActivity()
    {
        Intent i = new Intent(this, MidAngelActivity.class);
        startActivity(i);
    }

    private void openMovieCompActivity()
    {
        //Intent i = new Intent(this, MidAngelActivity.class);
        //startActivity(i);
    }

    private void openIrregularVerbActivity()
    {
        //Intent i = new Intent(this, MidAngelActivity.class);
        //startActivity(i);
    }

    private void openWord1004Activity()
    {
        Intent i = new Intent(this, Word1004.class);
        startActivity(i);
    }

    /*
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
        int curIndex = getRandomIndex();
        mCurIndex = curIndex;
        Log.d("TEST", String.valueOf(curIndex));

        mKorSentenceText.setText( mDbManager.getKorSentence(curIndex) );
        mEngSentenceText.setText( mDbManager.getEngSentence(curIndex) );
        mPageText.setText( mDbManager.getPage(curIndex) );
        //mAudioButton.setText( mDbManager.getAudio(curIndex) );
    }

    void SetCurrentState(STATE curState)
    {
        if( curState == STATE.KOR_STATE )
        {
            mKorSentenceText.setVisibility(View.VISIBLE);

            mEngSentenceText.setVisibility(View.GONE);
            mPageText.setVisibility(View.GONE);
            mAudioButton.setVisibility(View.GONE);
        }
        else
        {
            mKorSentenceText.setVisibility(View.GONE);

            mEngSentenceText.setVisibility(View.VISIBLE);
            mPageText.setVisibility(View.VISIBLE);
            mAudioButton.setVisibility(View.VISIBLE);
        }
    }

    int getRandomIndex()
    {
        return mRandom.nextInt(mDbManager.getTotalItemCount() - 1) + 1;
    }

    ///
    /// 화면을 눌렀을 때 호출되는 함수
    ///
    public void ClickNextButton(View v)
    {
        //Log.d("TEST", "ClickNextButton");

        if( mCurState == STATE.KOR_STATE )
        {
            SetCurrentState( STATE.ENG_STATE );
            mCurState = STATE.ENG_STATE;
        }
        else
        {
            SettingKorEngPageAudio();
            SetCurrentState( STATE.KOR_STATE );
            mCurState = STATE.KOR_STATE;
        }
    }

    public void ClickAudioButton(View v)
    {
        // Log.d("TEST", "ClickAudioButton");
        if( mDbManager.getAudio(mCurIndex).length() <= 0 ) {
            return;
        }

        int resID = getResources().getIdentifier( mDbManager.getAudio(mCurIndex), "raw", this.getPackageName() );
        mMediaPlayer = MediaPlayer.create(getApplicationContext(), resID);
        mMediaPlayer.start();
    }
    */
}
