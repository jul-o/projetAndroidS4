package com.example.jul.m4104c_projet2;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by jul on 17/03/18.
 */

public class QuestionCulture extends Question {
    DBQuestionCulture question;

    TextView tvPart1;
    TextView tvPart2;
    TextView editAns;
    RadioGroup group;
    RadioButton choice1;
    RadioButton choice2;
    RadioButton choice3;

    public QuestionCulture(Context context) {
        super(context);

    }

    public QuestionCulture(Context ctx, List<DBQuestionCulture> qs) {
        super(ctx);
        int nbQDisp = qs.size() - 1;
        int idQ = (int) (Math.random()*(nbQDisp));
        question = qs.get(idQ);
        qs.remove(idQ);
        init(question);
    }

    public QuestionCulture(Context ctx, DBQuestionCulture dbQuestionCulture) {
        super(ctx);
        question = dbQuestionCulture;
        init(question);
    }

    private void init(DBQuestionCulture question) {
        setOrientation(VERTICAL);
        LinearLayout layoutQ = new LinearLayout(getContext());
        layoutQ.setOrientation(HORIZONTAL);
        tvPart1 = new TextView(getContext());
        tvPart2 = new TextView(getContext());
        editAns = new TextView(getContext());
        layoutQ.addView(tvPart1);
        layoutQ.addView(editAns);
        layoutQ.addView(tvPart2);



        group = new RadioGroup(getContext());
        choice1 = new RadioButton(getContext());
        choice1.setTextColor(getResources().getColor(R.color.colorButtonText));
        choice2 = new RadioButton(getContext());
        choice2.setTextColor(getResources().getColor(R.color.colorButtonText));
        choice3 = new RadioButton(getContext());
        choice3.setTextColor(getResources().getColor(R.color.colorButtonText));
        RadioButton choices[] = {choice1, choice2, choice3};

        tvPart1.setText(question.getPart1());
        tvPart2.setText(question.getPart2());
        editAns.setText(" ... ");

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(100, 0, 0, 0);
        choice1.setLayoutParams(lp);
        choice2.setLayoutParams(lp);
        choice3.setLayoutParams(lp);

        group.addView(choice1);
        group.addView(choice2);
        group.addView(choice3);

        /*choice1.setPadding(100,0,0,0);
        choice2.setPadding(100,0,0,0);
        choice3.setPadding(100,0,0,0);*/

        ArrayList<String> list = new ArrayList<>(Arrays.asList(question.getRep(), question.getRepF1(), question.getRepF2()));
        int size = list.size();

        for(int i = 0; i < size; i++){
            int index = (int)Math.round(Math.random()*(list.size() - 1));
            choices[i].setText(list.get(index));
            list.remove(index);
        }

        /*addView(tvPart1);
        addView(editAns);
        addView(tvPart2);*/
        addView(layoutQ);
        addView(group);
    }

    @Override
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

    @Override
    public boolean goodAns() {
        boolean ok = choice1.isChecked()&&choice1.getText().toString().equals(question.getRep())
                ||choice2.isChecked()&&choice2.getText().toString().equals(question.getRep())
                ||choice3.isChecked()&&choice3.getText().toString().equals(question.getRep());
        if(ok) {
            LinearLayout layoutCont = (LinearLayout) getParent();
            layoutCont.removeView(this);

            ExoCultureActivity ctx = (ExoCultureActivity) getContext();
            ctx.removeQuestion(this);
        }

        return ok;

    }
}
