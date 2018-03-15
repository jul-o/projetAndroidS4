package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;

public class ExoMaths extends AppCompatActivity {
    public static final String EXTRA_MULT_TABLE = "table";
    private ArrayList<LinearLayout> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questions = new ArrayList<>();
        //if the exo type is multiplication
        if (getIntent().getExtras().get(ChoiceExsMaths.EXTRA_TYPE) == ChoiceExsMaths.TypeExo.MULTIPLICATION) {
            //if no table is picked
            if (getIntent().getExtras().get(EXTRA_MULT_TABLE) == null) {
                setContentView(R.layout.activity_choice_multiplication_table);
                NumberPicker pick = (NumberPicker) findViewById(R.id.choiceMultPick);
                pick.setMinValue(1);
                pick.setMaxValue(10);
            } else {
                setContentView(R.layout.activity_multiplication_table);
                setupMult((Integer) getIntent().getExtras().get(EXTRA_MULT_TABLE));
            }
        } else {
            setContentView(R.layout.activity_choice_exs_maths);
        }

    }

    private void setupMult(int table) {
        LinearLayout layout = (LinearLayout)findViewById(R.id.exoMultLayoutQuest);
        for (int i = 1; i <= 10; i++){
            //LinearLayout question = createMultQuestion(table, i);
            LinearLayout question = new MultQuestion(this, table, i);
            layout.addView(question);
            questions.add(question);
        }
    }

    /*private LinearLayout createMultQuestion(int table, int i) {
        LinearLayout quest = new LinearLayout(this);
        quest.setOrientation(LinearLayout.HORIZONTAL);

        //question field
        TextView tvQuestion = new TextView(this);
        tvQuestion.setText(""+table+" x "+i+" = ");
        quest.addView(tvQuestion);

        //answer field
        EditText ans = new EditText(this);

        ans.setInputType(InputType.TYPE_CLASS_NUMBER);
        quest.addView(ans);

        return quest;
    }*/

    public void clickChoiceMultSubmit(View view) {
        NumberPicker pick = (NumberPicker) findViewById(R.id.choiceMultPick);
        int table = pick.getValue();
        Intent intent = new Intent(this, ExoMaths.class);
        intent.putExtra(ChoiceExsMaths.EXTRA_TYPE, ChoiceExsMaths.TypeExo.MULTIPLICATION);
        intent.putExtra(EXTRA_MULT_TABLE, table);
        startActivity(intent);
    }

    public void clickMultSubmit(View view) {
        boolean ok = true;
        for(int i = 0; i < questions.size() && ok == true; i++){
            if(!questions.get(i).goodAns()){
                ok = false;
            }
        }
    }
}
