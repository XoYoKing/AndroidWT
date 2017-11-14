package com.wt.SliderWT.common;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

/**
 * Created by WT on 2017/8/3.
 */

public class ConstVariable {

    public static final String TAG = "ConstVariable";

    public static final int REQUEST_PERMISSIONS                                 = 3001;
    public static final int REQUEST_ACTION_APPLICATION_DETAILS_SETTINGS         = 3002;

    public static void ShowLog(int iType, String sTag, String sLog) {
        //if ( iType==0 ) return ;
        Log.i(TAG + "-" + sTag, sLog);
        //Log.i(TAG,sTag + "-" + sLog);
        //Log.i(sTag, sLog);
    }
    public static void ShowToast(Context theContext, String sToast)
    {
        Toast.makeText(theContext,sToast, Toast.LENGTH_SHORT).show();
    }

    //return： "/storage/emulated/0/"
    public static String getPathSD()
    {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equalsIgnoreCase(android.os.Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
        if (sdCardExist)
        {
            sdDir = Environment.getExternalStorageDirectory();// 获取根目录
        }
        String strPathSD=sdDir.toString()+"/";
        ShowLog(0,TAG,"getPathSD-strPathSD="+strPathSD);
        return strPathSD;
    }

    public static boolean dirAdd(String strFolderPath,boolean bAddXC)
    {
        ShowLog(0,TAG,"dirAdd-strFolderPath="+strFolderPath);
        File file = new File(strFolderPath);
        if ( !file.exists() )
        {
            boolean bMkDirs=file.mkdirs();
            return bMkDirs;
        }
        return true;
    }

    //return： "/storage/emulated/0/App/"
    public static String getPathAppData()
    {
        String strPathSD=getPathSD();
        //建立测试用目录
        String strPathAppData=strPathSD+"SliderWT/";
        if ( dirAdd(strPathAppData,false) )
        {
        }
        else
        {
            strPathAppData=strPathSD;
        }
        ShowLog(0,TAG,"getPathAppData-strPathAppData="+strPathAppData);
        return strPathAppData;
    }

    public static String getPath(String strPathAdd)
    {
        String strPath = getPathAppData()+strPathAdd+"/";
        if ( pathIsExists(strPath,true) )
        {
            return strPath;
        }
        return "";
    }

    public static boolean isExistFile(String strFile)
    {
        boolean bExistFile=false;
        File file = new File(strFile);
        if ( file.isFile() )
        {
            bExistFile=file.exists();
        }
        return bExistFile;
    }

    public static boolean pathIsExists(String strPath,boolean bCreateNoExist)
    {
        String strMSG = "pathIsExists-";
        ShowLog(0,TAG,strMSG+"strPath="+strPath);
        ShowLog(0,TAG,strMSG+"bCreateNoExist="+bCreateNoExist);
        try
        {
            File f=new File(strPath);
            if(!f.exists())
            {
                if ( bCreateNoExist )
                {
//                    if ( f.mkdir() )
                    if ( f.mkdirs() )
                    {
                        ShowLog(0,TAG,strMSG+"mkdir true="+strPath);
                    }
                    else
                    {
                        ShowLog(0,TAG,strMSG+"mkdir false="+strPath);
                    }
                    return pathIsExists(strPath,false);
                }
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public static boolean isExistFolder(String strFolder)
    {
        File file = new File(strFolder);
        if ( file.isDirectory() )
        {
            return file.exists();
        }
        return false;
    }
}
