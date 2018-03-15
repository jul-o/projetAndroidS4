package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class ChoiceExsMaths extends AppCompatActivity {


    public enum TypeExo{
        MULTIPLICATION
    }
    public static final String EXTRA_TYPE = "type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_exs_maths);
    }

    public void clickMultiplication(View view) {
        Intent intent = new Intent(this, ExoMaths.class);
        intent.putExtra(EXTRA_TYPE, TypeExo.MULTIPLICATION);
        startActivity(intent);
    }
    public void clickChoiceMultBack(View view) {
    }
}
