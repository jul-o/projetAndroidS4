package com.example.jul.m4104c_projet2;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jul on 10/03/18.
 */

public class LoginSelectAccount extends LinearLayout{
    private TextView name;

    LoginSelectAccount(Context ctx){
        super(ctx);
    }

    LoginSelectAccount(Context ctx, Account acc){
        super(ctx);
        this.setOrientation(VERTICAL);
        this.name = new TextView(ctx);
        this.addView(name);
        this.name.setText(acc.getFirstName() + " " + acc.getName()+"\n"+acc.getAvatar());
        this.setPadding(0,0,0,50);
    }


}
