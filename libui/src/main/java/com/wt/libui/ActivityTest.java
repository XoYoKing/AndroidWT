package com.wt.libui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by ting.wong on 2017/11/14.
 */

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ActivityTest extends Activity {

    public static final String TAG = "ActivityTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);

        initButton();
    }

    private void initButton() {
        findViewById(R.id.buttonTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
