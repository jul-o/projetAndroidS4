package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class ExoMathsActivity extends AppCompatActivity {
    private static final String EXTRA_MULT_TABLE = "table";
    private ArrayList<Question> questions;

    private ChoiceExsMathsActivity.TypeExo type;

    private static final int SCORE_MULT = 5;
    private static final int SCORE_ADD = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch ((ChoiceExsMathsActivity.TypeExo) (getIntent().getExtras().get(ChoiceExsMathsActivity.EXTRA_TYPE))) {
            case CHOICE_MULTIPLICATION:
                initChoiceMult();
                break;
            case MULTIPLICATION:
                initMultExo((Integer) getIntent().getExtras().get(EXTRA_MULT_TABLE));
                type = ChoiceExsMathsActivity.TypeExo.MULTIPLICATION;
                break;
            case ADDITIONS:
                initAddExo();
                type = ChoiceExsMathsActivity.TypeExo.ADDITIONS;
            default:
        }
    }

    private void initAddExo() {
        setContentView(R.layout.activity_multiplication_table);
        questions = new ArrayList<>();
        LinearLayout layout = (LinearLayout) findViewById(R.id.exoMultLayoutQuest);
        for (int i = 1; i <= 5; i++) {
            AddQuestion quest = new AddQuestion(this);
            questions.add(quest);
            layout.addView(quest);
        }
    }

    private void initChoiceMult() {
        setContentView(R.layout.activity_choice_multiplication_table);
        NumberPicker picker = (NumberPicker) findViewById(R.id.choiceMultPick);
        picker.setMinValue(1);
        picker.setMaxValue(10);
    }

    private void initMultExo(int table) {
        setContentView(R.layout.activity_multiplication_table);
        questions = new ArrayList<>();
        LinearLayout layout = (LinearLayout) findViewById(R.id.exoMultLayoutQuest);
        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        for (int i = 1; i <= 10; i++) {
            int index = (int)(Math.random() * (values.size() - 1));
            MultQuestion quest = new MultQuestion(this, table, values.get(index));
            values.remove(index);
            questions.add(quest);
            layout.addView(quest);
        }
    }

    public void clickChoiceMultSubmit(View view) {
        NumberPicker pick = (NumberPicker) findViewById(R.id.choiceMultPick);
        int val = pick.getValue();

        Intent intent = new Intent(this, ExoMathsActivity.class);
        intent.putExtra(ChoiceExsMathsActivity.EXTRA_TYPE, ChoiceExsMathsActivity.TypeExo.MULTIPLICATION);
        intent.putExtra(EXTRA_MULT_TABLE, val);
        startActivity(intent);
    }

    public void clickBack(View view) {
        finish();
    }

    //common success test to all math exs
    public void clickExoSubmit(View view) {
        boolean ok = true;
        for (Question q : questions) {
            if (!q.testAns()) ok = false;
        }
        if (ok) success();
        else failure();
    }

    private void failure() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_add_score, (ViewGroup) findViewById(R.id.toast_add_score_root));
        Toast notify = new Toast(this);
        notify.setView(layout);
        notify.setDuration(Toast.LENGTH_LONG);
        TextView infoNotify = (TextView) layout.findViewById(R.id.toastAddScoreTVInfo);
        infoNotify.setText("Tu t'es trompé sur certaines questions, corrige-les");
        notify.show();
    }

    private void success() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_add_score, (ViewGroup) findViewById(R.id.toast_add_score_root));
        Toast notify = new Toast(this);
        notify.setView(layout);
        notify.setDuration(Toast.LENGTH_LONG);

        TextView infoNotify = (TextView) layout.findViewById(R.id.toastAddScoreTVInfo);
        switch (this.type) {
            case MULTIPLICATION:
                DBAccount.currentAccount.setScore(DBAccount.currentAccount.getScore() + SCORE_MULT);
                infoNotify.setText("Tu as gagné " + SCORE_MULT + " de score !");
                break;
            case ADDITIONS:
                DBAccount.currentAccount.setScore(DBAccount.currentAccount.getScore() + SCORE_ADD);
                DBAccount.currentAccount.save();
                infoNotify.setText("Tu as gagné " + SCORE_ADD + " de score !");
                break;
        }


        notify.show();

        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        DBAccount.currentAccount.save();
        Intent intent = new Intent(this, SuccessActivityMath.class);
        startActivity(intent);
        finish();
    }

}
