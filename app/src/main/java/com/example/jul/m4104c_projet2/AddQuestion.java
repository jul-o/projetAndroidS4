package com.example.jul.m4104c_projet2;

import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by sangj on 16/03/18.
 */

class AddQuestion extends Question {
    static final int RANGE = 100;
    int memb1;
    int memb2;

    TextView tvQuest;
    EditText fieldAns;
    public AddQuestion(Context ctx) {
        super(ctx);

        memb1 = (int)(Math.random()*100);
        memb2 = (int)(Math.random()*100);

        tvQuest = new TextView(ctx);
        tvQuest.setText(memb1+ " + "+ memb2+ " = ");

        fieldAns = new EditText(ctx);
        fieldAns.setInputType(InputType.TYPE_CLASS_NUMBER);
        addView(tvQuest);
        addView(fieldAns);
    }

    @Override
    public boolean goodAns() {
        if(fieldAns.getText() == null || fieldAns.getText().toString().equals("")) return false;
        int answ = Integer.parseInt(fieldAns.getText().toString());
        return answ == memb1+memb2;
    }
}
