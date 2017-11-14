package com.wt.SliderWT.data;

import android.util.SparseArray;

import com.wt.SliderWT.common.ConstVariable;

/**
 * Created by ting.wong on 2017/8/4.
 */

public class LANGUAGE {
    public static final String TAG = "LANGUAGE";

    private static int m_iMaxKey=0;
    public static SparseArray m_saLanguage=new SparseArray();

    public static int indexOf(String strLanguage)
    {
        int index=m_saLanguage.indexOfValue(strLanguage);
        if ( index<0 )
        {
            int i=0;
            int iCountLanguage=m_saLanguage.size();
            for ( i=0;i<iCountLanguage;i++ )
            {
                if ( strLanguage.equalsIgnoreCase((String)m_saLanguage.valueAt(i)) )
                {
                    return i;
                }
            }
        }
        return index;
    }
    public static boolean add(String strLanguage)
    {
        String strMSG="add-";
        ConstVariable.ShowLog(0,TAG,strMSG+"strLanguage = "+strLanguage);
        int index=indexOf(strLanguage);
        ConstVariable.ShowLog(0,TAG,strMSG+"index = "+index);
        ConstVariable.ShowLog(0,TAG,strMSG+"m_iMaxKey = "+m_iMaxKey);
        if ( index<0 )
        {
            m_saLanguage.put(m_iMaxKey,strLanguage);
            m_iMaxKey++;
            return true;
        }
        return false;
    }

    public static String toStringCSV()
    {
        String strLine="KEY";
        int i=0;
        int iCountLanguage=m_saLanguage.size();
        for ( i=0;i<iCountLanguage;i++ )
        {
            strLine=strLine+","+LANGUAGE.m_saLanguage.valueAt(i);
        }
        return strLine;
    }
    public static String toStringTXTTAB()
    {
        String strLine="KEY";
        int i=0;
        int iCountLanguage=m_saLanguage.size();
        for ( i=0;i<iCountLanguage;i++ )
        {
            strLine=strLine+"\t"+LANGUAGE.m_saLanguage.valueAt(i);
        }
        return strLine;
    }
}
