package com.example.jul.m4104c_projet2;

import android.content.Context;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jul on 17/03/18.
 */

public class QuestionFr extends Question {
    DBQuestionFr question;

    TextView tvPart1;
    TextView tvPart2;
    TextView editAns;
    RadioGroup group;
    RadioButton choice1;
    RadioButton choice2;
    RadioButton choice3;

    public QuestionFr(Context context) {
        super(context);

    }

    public QuestionFr(Context ctx, List<DBQuestionFr> qs) {
        super(ctx);
        int nbQDisp = qs.size() - 1;
        int idQ = (int) (Math.random()*(nbQDisp));
        question = qs.get(idQ);
        init(question);
    }

    private void init(DBQuestionFr question) {
        tvPart1 = new TextView(getContext());
        tvPart2 = new TextView(getContext());
        editAns = new TextView(getContext());
        group = new RadioGroup(getContext());
        choice1 = new RadioButton(getContext());
        choice2 = new RadioButton(getContext());
        choice3 = new RadioButton(getContext());

        tvPart1.setText(question.getPart1());
        tvPart2.setText(question.getPart2());
        editAns.setText(" ... ");
        group.addView(choice1);
        group.addView(choice2);
        group.addView(choice3);
        choice1.setText(question.getRep());
        choice2.setText(question.getRepF1());
        choice3.setText(question.getRepF2());

        addView(tvPart1);
        addView(editAns);
        addView(tvPart2);
        addView(group);
    }

    @Override
    public boolean goodAns() {
        return choice1.isChecked();
    }
}
