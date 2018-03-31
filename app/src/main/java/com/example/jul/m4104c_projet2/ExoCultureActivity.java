package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.jul.m4104c_projet2.ChoiceExsCultureActivity.EXTRA_TYPE_EXO;

public class ExoCultureActivity extends AppCompatActivity {
    ArrayList<Question> questions;
    private static final int SCORE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_culture);
        questions = new ArrayList<>();

        /*switch ((ChoiceExsCultureActivity.TypeExo) getIntent().getExtras().get(EXTRA_TYPE_EXO)) {
            case FR:
                initFr();
                break;
            case HIST:
                initHist();
                break;
        }*/
        initExo((ChoiceExsCultureActivity.TypeExo) getIntent().getExtras().get(EXTRA_TYPE_EXO));
    }

    private void initExo(ChoiceExsCultureActivity.TypeExo type) {
        LinearLayout layoutQ = (LinearLayout) findViewById(R.id.exoFrLayoutQuest);
        DBQuestionCulture.init();
        List<DBQuestionCulture> qs = DBQuestionCulture.find(DBQuestionCulture.class, "tag = ?", type.toString());
        for (int i = 0; i < 10; i++){
            QuestionCulture q = new QuestionCulture(this, qs);
            questions.add(q);
            layoutQ.addView(q);
        }
    }

    private void initHist() {
        LinearLayout layoutQ = (LinearLayout) findViewById(R.id.exoFrLayoutQuest);
        DBQuestionCulture.init();
        List<DBQuestionCulture> qs = DBQuestionCulture.find(DBQuestionCulture.class, "tag = " + DBQuestionCulture.TAGS.FR);
        for (int i = 0; i < 10; i++){
            QuestionCulture q = new QuestionCulture(this, qs);
            questions.add(q);
            layoutQ.addView(q);
        }
    }

    private void initFr() {
        LinearLayout layoutQ = (LinearLayout) findViewById(R.id.exoFrLayoutQuest);
        DBQuestionCulture.init();
        List<DBQuestionCulture> qs = DBQuestionCulture.find(DBQuestionCulture.class, "tag = " + DBQuestionCulture.TAGS.FR);
        for (int i = 0; i < 10; i++){
            QuestionCulture q = new QuestionCulture(this, qs);
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
        DBAccount.currentAccount.setScore(DBAccount.currentAccount.getScore()+ SCORE);
        Intent intent = new Intent(this, SuccessActivityCulture.class);

        startActivity(intent);
    }

}
