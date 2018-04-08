package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChoiceExsCultureActivity extends AppCompatActivity {
    public static final String EXTRA_TYPE_EXO = "type";

    public void clickBack(View view) {
        finish();
    }

    public enum TypeExo {
        FR,
        HIST
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_exs_culture);
    }

    public void clickFr(View view) {
        Intent intent = new Intent(this, ExoCultureActivity.class);
        intent.putExtra(EXTRA_TYPE_EXO, TypeExo.FR);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void clickHist(View view) {
        Intent intent = new Intent(this, ExoCultureActivity.class);
        intent.putExtra(EXTRA_TYPE_EXO, TypeExo.HIST);
        startActivity(intent);
    }


}
