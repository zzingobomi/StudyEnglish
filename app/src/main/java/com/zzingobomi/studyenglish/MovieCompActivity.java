package com.zzingobomi.studyenglish;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by JONGCHAN on 2017-05-31.
 */

public class MovieCompActivity extends AppCompatActivity
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviecomp);

        mRandom = new Random();

        mKorSentenceText = (TextView)findViewById(R.id.korsentencemoviecomp);
        mEngSentenceText = (TextView)findViewById(R.id.engsentencemoviecomp);
        mPageText = (TextView)findViewById(R.id.pagemoviecomp);
        mAudioButton = (Button)findViewById(R.id.audiobuttonmoviecomp);

        // DB 에서 정보 가져오기
        DBConnect();

        // 처음 화면 보여주기
        SettingKorEngPageAudio();
        SetCurrentState( MovieCompActivity.STATE.KOR_STATE );
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
        int curIndex = getRandomIndex();
        mCurIndex = curIndex;
        Log.d("TEST", String.valueOf(curIndex));

        mKorSentenceText.setText( mDbManager.getKorSentenceMovieComp(curIndex) );
        mEngSentenceText.setText( mDbManager.getEngSentenceMovieComp(curIndex) );
        mPageText.setText( mDbManager.getPageMovieComp(curIndex) );
        //mAudioButton.setText( mDbManager.getAudioMovieComp((curIndex) );
    }

    void SetCurrentState(MovieCompActivity.STATE curState)
    {
        if( curState == MovieCompActivity.STATE.KOR_STATE )
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
        return mRandom.nextInt(mDbManager.getTotalItemCountMovieComp() - 1) + 1;
    }

    ///
    /// 화면을 눌렀을 때 호출되는 함수
    ///
    public void ClickNextButton(View v)
    {
        //Log.d("TEST", "ClickNextButton");

        if( mCurState == MovieCompActivity.STATE.KOR_STATE )
        {
            SetCurrentState( MovieCompActivity.STATE.ENG_STATE );
            mCurState = MovieCompActivity.STATE.ENG_STATE;
        }
        else
        {
            SettingKorEngPageAudio();
            SetCurrentState( MovieCompActivity.STATE.KOR_STATE );
            mCurState = MovieCompActivity.STATE.KOR_STATE;
        }
    }

    public void ClickAudioButton(View v)
    {
        // Log.d("TEST", "ClickAudioButton");
        if( mDbManager.getAudioMovieComp(mCurIndex).length() <= 0 ) {
            return;
        }

        int resID = getResources().getIdentifier( mDbManager.getAudioMovieComp(mCurIndex), "raw", this.getPackageName() );
        mMediaPlayer = MediaPlayer.create(getApplicationContext(), resID);
        mMediaPlayer.start();
    }
}
