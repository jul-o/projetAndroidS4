package com.example.jul.m4104c_projet2;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by jul on 15/03/18.
 */

abstract class QuestionMaths extends LinearLayout {
    public QuestionMaths(Context context) {
        super(context);
    }

    public abstract boolean goodAns();
}
