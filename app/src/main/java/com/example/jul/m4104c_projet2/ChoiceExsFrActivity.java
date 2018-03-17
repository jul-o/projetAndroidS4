package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChoiceExsFrActivity extends AppCompatActivity {
    public static final String EXTRA_TYPE_EXO = "type";
    public enum TypeExo {
        Fr
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_exs_fr);
    }

    public void clickFr(View view) {
        Intent intent = new Intent(this, ExoFrActivity.class);
        intent.putExtra(EXTRA_TYPE_EXO, TypeExo.Fr);
        startActivity(intent);
    }


}
