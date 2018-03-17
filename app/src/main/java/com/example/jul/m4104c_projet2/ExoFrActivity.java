package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.jul.m4104c_projet2.ChoiceExsFrActivity.EXTRA_TYPE_EXO;

public class ExoFrActivity extends AppCompatActivity {
    ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_fr);
        questions = new ArrayList<>();

        switch ((ChoiceExsFrActivity.TypeExo) getIntent().getExtras().get(EXTRA_TYPE_EXO)) {
            case Fr:
                initFr();
                break;
        }
    }

    private void initFr() {
        LinearLayout layoutQ = (LinearLayout) findViewById(R.id.exoFrLayoutQuest);
        DBQuestionFr.init();
        List<DBQuestionFr> qs = DBQuestionFr.listAll(DBQuestionFr.class);
        for (int i = 0; i < 10; i++){
            QuestionFr q = new QuestionFr(this, qs);
            questions.add(q);
            layoutQ.addView(q);
        }
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
