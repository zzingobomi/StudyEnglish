package com.zzingobomi.studyenglish;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by JONGCHAN on 2017-05-25.
 */

public class DBManager
{
    private final String    DB_NAME             = "studyenglish.db";
    private final String    DB_TABLE_NAME       = "midangel";
    private final int       DB_VERSION          = 1;

    private Context         mContext            = null;
    private OpenHelper      mOpener             = null;
    private SQLiteDatabase  mDbController       = null;

    private class OpenHelper extends SQLiteOpenHelper
    {
        public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
        {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase aDb)
        {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
        }
    }

    public DBManager(Context aContext)
    {
        this.mContext = aContext;
        this.mOpener = new OpenHelper(mContext, DB_NAME, null, DB_VERSION);

        try
        {
            boolean bResult = isCheckDB(mContext);
            if(!bResult)
            {
                copyDB(mContext);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        // 읽기 전용 DB 얻기
        mDbController = mOpener.getReadableDatabase();
    }

    public int getTotalItemCount()
    {
        int totalCount = 0;

        String querySQL = "SELECT count(*) FROM " + DB_TABLE_NAME;
        Cursor result = mDbController.rawQuery(querySQL, null);
        result.moveToFirst();
        totalCount = result.getInt(0);

        return totalCount;
    }

    public String getKorSentence( int iIndex )
    {
        String korSentence = "";

        String querySQL = "SELECT * FROM " + DB_TABLE_NAME + " WHERE autoindex='" + iIndex + "'";
        Cursor result = mDbController.rawQuery(querySQL, null);
        result.moveToFirst();
        korSentence = result.getString(GlobalData.iKorSentenceColumn);

        return korSentence;
    }

    public String getEngSentence( int iIndex )
    {
        String engSentence = "";

        String querySQL = "SELECT * FROM " + DB_TABLE_NAME + " WHERE autoindex='" + iIndex + "'";
        Cursor result = mDbController.rawQuery(querySQL, null);
        result.moveToFirst();
        engSentence = result.getString(GlobalData.iEngSentenceColumn);

        return engSentence;
    }

    public int getPage( int iIndex )
    {
        int page = 0;

        String querySQL = "SELECT * FROM " + DB_TABLE_NAME + " WHERE autoindex='" + iIndex + "'";
        Cursor result = mDbController.rawQuery(querySQL, null);
        result.moveToFirst();
        page = result.getInt(GlobalData.iPageColumn);

        return page;
    }

    public String getAudio( int iIndex )
    {
        String audio = "";

        String querySQL = "SELECT * FROM " + DB_TABLE_NAME + " WHERE autoindex='" + iIndex + "'";
        Cursor result = mDbController.rawQuery(querySQL, null);
        result.moveToFirst();
        audio = result.getString(GlobalData.iAudioColumn);

        return audio;
    }

    /*
    public void getResult()
    {
        mDbController = mOpener.getReadableDatabase();

        // 만약 해당 컬럼에 값이 없다면 null 리턴
        // test
        String nextfile = "";
        String nextfile2 = "";
        Cursor result = mDbController.rawQuery("SELECT * FROM moviegame_item WHERE filename='Chapter_01'", null);
        result.moveToFirst();
        nextfile = result.getString(3);
        nextfile2 = result.getString(5);

        result.islastfile?
    }
    */

    // DB 가 있나 체크하기
    private boolean isCheckDB(Context context)
    {
        String filePath = "/data/data/" + context.getPackageName() + "/databases/" + DB_NAME;
        File file = new File(filePath);
        if(file.exists())
        {
            return true;
        }

        return false;
    }

    // DB 복사하기
    private void copyDB(Context context)
    {
        AssetManager manager = context.getAssets();
        String folderPath = "/data/data/" + context.getPackageName() + "/databases/";
        String filePath = "/data/data/" + context.getPackageName() + "/databases/" + DB_NAME;
        File folder = new File(folderPath);
        File file = new File(filePath);

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try
        {
            InputStream is = manager.open("db/" + DB_NAME, AssetManager.ACCESS_BUFFER);
            BufferedInputStream bis = new BufferedInputStream(is);
            if (folder.exists()) {
            } else
                folder.mkdirs();

            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }

            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            int read = -1;
            byte[] buffer = new byte[1024];
            while ((read = bis.read(buffer, 0, 1024)) != -1) {
                bos.write(buffer, 0, read);
            }

            bos.flush();

            bos.close();
            fos.close();
            bis.close();
            is.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}