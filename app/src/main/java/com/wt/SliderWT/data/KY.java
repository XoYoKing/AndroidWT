package com.wt.SliderWT.data;

import android.util.ArrayMap;
import android.util.SparseArray;

import com.wt.SliderWT.common.ConstVariable;

/**
 * Created by ting.wong on 2017/8/4.
 */

public class  KY{
    public static final String TAG = "KY";

    public static ArrayMap<String,KYVALUE> m_aKEY=new ArrayMap<String,KYVALUE>();
    private static int m_iMaxKey=0;
    public static SparseArray m_saKey=new SparseArray();

    public static KYVALUE getKEY(String strKEY,boolean bMerge)
    {
        String strMSG="getKEY-";
        if ( m_aKEY.containsKey(strKEY) )
        {
            return m_aKEY.get(strKEY);
        }
        if ( bMerge )
        {
            return null;
        }
        KYVALUE theKYVALUE=new KYVALUE();
        theKYVALUE.m_strKEY=strKEY;
        add(strKEY);
        m_aKEY.put(strKEY,theKYVALUE);
        ConstVariable.ShowLog(0,TAG,strMSG+"strKEY = "+strKEY);
        return theKYVALUE;
    }

    public static int indexOf(String strKey)
    {
        int index=m_saKey.indexOfValue(strKey);
        if ( index<0 )
        {
            int i=0;
            int iCountLanguage=m_saKey.size();
            for ( i=0;i<iCountLanguage;i++ )
            {
                if ( strKey.equalsIgnoreCase((String)m_saKey.valueAt(i)) )
                {
                    return i;
                }
            }
        }
        return index;
    }
    public static boolean add(String strKey)
    {
        String strMSG="add-";
        ConstVariable.ShowLog(0,TAG,strMSG+"strKey = "+strKey);
        int index=indexOf(strKey);
        ConstVariable.ShowLog(0,TAG,strMSG+"index = "+index);
        ConstVariable.ShowLog(0,TAG,strMSG+"m_iMaxKey = "+m_iMaxKey);
        if ( index<0 )
        {
            m_saKey.put(m_iMaxKey,strKey);
            m_iMaxKey++;
            return true;
        }
        return false;
    }
}
