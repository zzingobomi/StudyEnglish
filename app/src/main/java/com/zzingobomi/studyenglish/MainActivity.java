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


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnMidAngel        = (Button)findViewById(R.id.midangelbutton);
        mBtnMovieComp       = (Button)findViewById(R.id.moviecompbutton);
        mBtnIrregularVerb   = (Button)findViewById(R.id.irregularverbbutton);
        mBtnWord1004        = (Button)findViewById(R.id.word1004button);
    }

    ///
    /// 공부할 과목을 선택한다.
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
        Intent i = new Intent(this, MovieCompActivity.class);
        startActivity(i);
    }

    private void openIrregularVerbActivity()
    {
        Intent i = new Intent(this, IrregularVerbActivity.class);
        startActivity(i);
    }

    private void openWord1004Activity()
    {
        Intent i = new Intent(this, Word1004Activity.class);
        startActivity(i);
    }
}