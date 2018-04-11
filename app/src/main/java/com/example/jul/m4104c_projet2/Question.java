package com.example.jul.m4104c_projet2;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by jul on 15/03/18.
 */

abstract class Question extends LinearLayout {

    ImageView imgSucc;

    public Question(Context context) {
        super(context);
        imgSucc = new ImageView(context);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        p.gravity = Gravity.CENTER_HORIZONTAL;
        p.setMargins(0,0,0,200);
        imgSucc.setLayoutParams(p);
    }

    public abstract boolean goodAns();

    public boolean testAns() {
        boolean goodAns = goodAns();
        if(goodAns) {
            imgSucc.setImageResource(R.mipmap.ic_success);
        }else{
            imgSucc.setImageResource(R.mipmap.ic_failure);
        }
        this.removeView(imgSucc);
        this.addView(imgSucc);
        return goodAns;
    }
}
