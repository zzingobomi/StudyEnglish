package com.zzingobomi.studyenglish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import static com.zzingobomi.studyenglish.IrregularVerbActivity.STATE.KOR_STATE;

/**
 * Created by JONGCHAN on 2017-05-31.
 */

public class IrregularVerbActivity extends AppCompatActivity
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
    TextView                mKorVerbText;
    TextView                mEngVerbText;

    ///
    /// 현재 상태 모습
    ///
    enum STATE
    {
        KOR_STATE,
        ENG_STATE
    };
    STATE                   mCurState = KOR_STATE;
    int                     mCurIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irregularverb);

        mRandom = new Random();

        mKorVerbText = (TextView)findViewById(R.id.korverb);
        mEngVerbText = (TextView)findViewById(R.id.engverb);

        // DB 에서 정보 가져오기 (가장 첫번째)
        DBConnect();

        // 처음 화면 보여주기
        SettingKorEng();
        SetCurrentState( IrregularVerbActivity.STATE.KOR_STATE );
    }

    private void DBConnect()
    {
        mDbManager = new DBManager(getApplicationContext());
    }

    ///
    /// 랜덤으로 인덱스를 추출한 뒤 해당 문장들을 셋팅한다.
    ///
    private void SettingKorEng()
    {
        int curIndex = getRandomIndex();
        mCurIndex = curIndex;
        Log.d("TEST", String.valueOf(curIndex));

        mKorVerbText.setText( mDbManager.getKorIrregularVerb(curIndex) );
        mEngVerbText.setText( mDbManager.getEngIrregularVerb(curIndex) );
    }

    void SetCurrentState(IrregularVerbActivity.STATE curState)
    {
        if( curState == IrregularVerbActivity.STATE.KOR_STATE )
        {
            mKorVerbText.setVisibility(View.VISIBLE);

            mEngVerbText.setVisibility(View.GONE);
        }
        else
        {
            mKorVerbText.setVisibility(View.GONE);

            mEngVerbText.setVisibility(View.VISIBLE);
        }
    }

    int getRandomIndex()
    {
        return mRandom.nextInt(mDbManager.getTotalItemCountIrregularVerb() - 1) + 1;
    }

    ///
    /// 화면을 눌렀을 때 호출되는 함수
    ///
    public void ClickNextButton(View v)
    {
        //Log.d("TEST", "ClickNextButton");

        if( mCurState == IrregularVerbActivity.STATE.KOR_STATE )
        {
            SetCurrentState( IrregularVerbActivity.STATE.ENG_STATE );
            mCurState = IrregularVerbActivity.STATE.ENG_STATE;
        }
        else
        {
            SettingKorEng();
            SetCurrentState( IrregularVerbActivity.STATE.KOR_STATE );
            mCurState = IrregularVerbActivity.STATE.KOR_STATE;
        }
    }
}