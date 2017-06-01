package com.zzingobomi.studyenglish;

/**
 * Created by JONGCHAN on 2017-05-25.
 */

public class GlobalData
{
    ///
    /// DB 테이블 이름
    ///
    public static final String szMidAngelTableName          = "midangel";           // 미드 천사
    public static final String szMovieCompTableName         = "moviecomp";          // 영화 영작
    public static final String szIrregularVerbTableName     = "irregularverb";      // 불규칙 동사
    public static final String szWord1004TableName          = "word1004";           // 1004 어휘



    ///
    /// 미드 천사 DB 컬럼 인덱스
    ///
    public static final int iMidAngel_IndexColumn            = 0;
    public static final int iMidAngel_KorSentenceColumn      = 1;
    public static final int iMidAngel_EngSentenceColumn      = 2;
    public static final int iMidAngel_PageColumn             = 3;
    public static final int iMidAngel_AudioColumn            = 4;



    ///
    /// 영화 영작 DB 컬럼 인덱스
    ///
    public static final int iMovieComp_IndexColumn            = 0;
    public static final int iMovieComp_KorSentenceColumn      = 1;
    public static final int iMovieComp_EngSentenceColumn      = 2;
    public static final int iMovieComp_PageColumn             = 3;
    public static final int iMovieComp_AudioColumn            = 4;



    ///
    /// 불규칙 동사 DB 컬럼 인덱스
    ///
    public static final int iIrregularVerb_IndexColumn        = 0;
    public static final int iIrregularVerb_KorVerbColumn      = 1;
    public static final int iIrregularVerb_EngBerbColumn      = 2;



    ///
    /// 1004 어휘 DB 컬럼 인덱스
    ///
    public static final int iWord1004_IndexColumn            = 0;
    public static final int iWord1004_KorWordColumn          = 1;
    public static final int iWord1004_EngWordColumn          = 2;
    public static final int iWord1004_WordKindColumn         = 3;




    ///
    /// Debug 관련
    ///
    public static final boolean debugMode       = true;
}
