package com.example.jul.m4104c_projet2;

import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jul on 12/03/18.
 */

class MultQuestion extends Question {
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
        fieldAns.setTextColor(getResources().getColor(R.color.colorButtonText));


        this.addView(quest);
        this.addView(fieldAns);
    }

    public int getAnswer(){
        return ans;
    }

    @Override
    public boolean testAns() {
        boolean goodAns = goodAns();
        if(goodAns) {
            imgSucc.setImageResource(R.mipmap.ic_success);

            LinearLayout layoutCont = (LinearLayout) getParent();
            layoutCont.removeView(this);

            ExoMathsActivity ctx = (ExoMathsActivity) getContext();
            ctx.removeQuestion(this);

        }else{
            imgSucc.setImageResource(R.mipmap.ic_failure);
        }
        this.removeView(imgSucc);
        this.addView(imgSucc);
        return goodAns;
    }

    @Override
    public boolean goodAns() {
        if(fieldAns.getText() == null || fieldAns.getText().toString().equals("")) return false;
        int answ = Integer.parseInt(fieldAns.getText().toString());
        return answ == this.ans;
    }


}
