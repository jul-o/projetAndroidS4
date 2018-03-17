package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import java.util.ArrayList;


public class ExoMathsActivity extends AppCompatActivity {
    private static final String EXTRA_MULT_TABLE = "table";
    private ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch ((ChoiceExsMathsActivity.TypeExo)(getIntent().getExtras().get(ChoiceExsMathsActivity.EXTRA_TYPE))){
            case CHOICE_MULTIPLICATION:
                initChoiceMult();
                break;
            case MULTIPLICATION:
                initMultExo((Integer) getIntent().getExtras().get(EXTRA_MULT_TABLE));
                break;
            case ADDITIONS:
                initAddExo();
            default:
         }
    }

    private void initAddExo() {
        setContentView(R.layout.activity_multiplication_table);
        questions = new ArrayList<>();
        LinearLayout layout = (LinearLayout) findViewById(R.id.exoMultLayoutQuest);
        for(int i = 1; i <= 10; i++){
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
        for(int i = 1; i <= 10; i++){
            MultQuestion quest = new MultQuestion(this, table, i);
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
        for(Question q : questions){
            if(!q.testAns()) ok = false;
        }
        if(ok) success();
    }

    private void success() {
        Intent intent = new Intent(this, SuccessActivity.class);
        startActivity(intent);
    }

}
