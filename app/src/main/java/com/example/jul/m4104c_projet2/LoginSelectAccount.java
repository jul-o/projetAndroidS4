package com.example.jul.m4104c_projet2;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jul on 10/03/18.
 */

public class LoginSelectAccount extends LinearLayout {
    private TextView name;
    private ImageView avatar;


    LoginSelectAccount(Context ctx) {
        super(ctx);
    }

    LoginSelectAccount(Context ctx, DBAccount acc) {
        super(ctx);
        this.setOrientation(VERTICAL);
        this.name = new TextView(ctx);
        this.addView(name);
        this.name.setText(acc.getFirstName() + " " + acc.getName()/* + "\n" + acc.getAvatar()*/);
        this.setBackgroundColor(getResources().getColor(R.color.colorButtonNormal));
        this.name.setBackgroundColor(getResources().getColor(R.color.colorButtonNormal));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 20, 20, 0);
        this.setLayoutParams(lp);

        this.avatar = new ImageView(ctx);
        switch (acc.getAvatar()){
            case LOUTRE:
                this.avatar.setImageResource(R.mipmap.ic_loutre);
                break;
            case ORNITHORYNQUE:
                this.avatar.setImageResource(R.mipmap.ic_ornithorynque);
                break;
            case VACHE:
                this.avatar.setImageResource(R.mipmap.ic_vache);
                break;
        }

        addView(avatar);

        this.setPadding(0, 0, 0, 50);
        this.setOnClickListener(new SelectAccountOnClickListener(ctx, acc));
    }

    public TextView getName() {
        return name;
    }
}

class SelectAccountOnClickListener implements View.OnClickListener {
    private AccueilActivity ctx;
    private DBAccount acc;

    public SelectAccountOnClickListener(Context ctx, DBAccount acc) {
        this.ctx = (AccueilActivity) ctx;
        this.acc = acc;
    }

    @Override
    public void onClick(View view) {
        ctx.clickAccount(acc);
    }
}