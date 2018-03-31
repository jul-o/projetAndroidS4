package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class ChoiceExsMathsActivity extends AppCompatActivity {
    public enum TypeExo{
        CHOICE_MULTIPLICATION,
        MULTIPLICATION,
        ADDITIONS
    }

    public static final String EXTRA_TYPE = "type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_exs_maths);
    }

    public void clickMultiplication(View view) {
        Intent intent = new Intent(this, ExoMathsActivity.class);
        intent.putExtra(EXTRA_TYPE, TypeExo.CHOICE_MULTIPLICATION);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void clickAdditions(View view) {
        Intent intent = new Intent(this, ExoMathsActivity.class);
        intent.putExtra(EXTRA_TYPE, TypeExo.ADDITIONS);
        startActivity(intent);
    }
}
