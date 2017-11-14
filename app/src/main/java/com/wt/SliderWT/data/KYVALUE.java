package com.wt.SliderWT.data;

import android.util.ArrayMap;
import android.util.SparseArray;

/**
 * Created by ting.wong on 2017/8/4.
 */

public class KYVALUE {
    public static final String TAG = "KYVALUE";

    public String m_strKEY="";
    public ArrayMap<String,String> m_aValue=new ArrayMap<String,String>();

    public void putValue(String strLanguage,String strValue)
    {
        m_aValue.put(strLanguage,strValue);
    }

    public String toStringCSV()
    {
        String strLine=m_strKEY;
        int i=0;
        int iCountLanguage=LANGUAGE.m_saLanguage.size();
        for ( i=0;i<iCountLanguage;i++ )
        {
            String strValue=m_aValue.get(LANGUAGE.m_saLanguage.valueAt(i));
            if ( strValue==null )
            {
                strValue="";
            }
            strLine=strLine+","+strValue;
        }
        return strLine;
    }
    public String toStringTXTTAB()
    {
        String strLine=m_strKEY;
        int i=0;
        int iCountLanguage=LANGUAGE.m_saLanguage.size();
        for ( i=0;i<iCountLanguage;i++ )
        {
            String strValue=m_aValue.get(LANGUAGE.m_saLanguage.valueAt(i));
            if ( strValue==null )
            {
                strValue="";
            }
            strLine=strLine+"\t"+strValue;
        }
        return strLine;
    }
}
