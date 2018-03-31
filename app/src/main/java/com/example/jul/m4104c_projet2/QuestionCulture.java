package com.example.jul.m4104c_projet2;

import android.content.Context;
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

    private void init(DBQuestionCulture question) {
        tvPart1 = new TextView(getContext());
        tvPart2 = new TextView(getContext());
        editAns = new TextView(getContext());
        group = new RadioGroup(getContext());
        choice1 = new RadioButton(getContext());
        choice2 = new RadioButton(getContext());
        choice3 = new RadioButton(getContext());
        RadioButton choices[] = {choice1, choice2, choice3};

        tvPart1.setText(question.getPart1());
        tvPart2.setText(question.getPart2());
        editAns.setText(" ... ");
        group.addView(choice1);
        group.addView(choice2);
        group.addView(choice3);

        ArrayList<String> list = new ArrayList<>(Arrays.asList(question.getRep(), question.getRepF1(), question.getRepF2()));
        int size = list.size();

        for(int i = 0; i < size; i++){
            int index = (int)Math.round(Math.random()*(list.size() - 1));
            choices[i].setText(list.get(index));
            list.remove(index);
        }

        addView(tvPart1);
        addView(editAns);
        addView(tvPart2);
        addView(group);
    }

    @Override
    public boolean goodAns() {
        return(choice1.isChecked()&&choice1.getText().toString().equals(question.getRep())
                ||choice2.isChecked()&&choice2.getText().toString().equals(question.getRep())
                ||choice3.isChecked()&&choice3.getText().toString().equals(question.getRep()));

    }
}
