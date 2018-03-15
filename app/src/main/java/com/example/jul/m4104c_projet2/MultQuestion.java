package com.example.jul.m4104c_projet2;

import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jul on 12/03/18.
 */

class MultQuestion extends QuestionMaths {
    //int table;
    //int val;
    int ans;
    TextView quest;
    EditText fieldAns;

    public MultQuestion(Context ctx, int table, int i) {
        super(ctx);
        this.setOrientation(HORIZONTAL);
        //this.table = table;
        //this.val = i;
        this.ans = table*i;

        this.quest = new TextView(ctx);
        quest.setText(table+" x "+i+" = ");

        this.fieldAns = new EditText(ctx);
        fieldAns.setInputType(InputType.TYPE_CLASS_NUMBER);

        this.addView(quest);
        this.addView(fieldAns);
    }

    public int getAnswer(){
        return ans;
    }

    @Override
    public boolean goodAns() {
        int answ = Integer.parseInt(fieldAns.getText().toString());
        return answ == this.ans;
    }
}
