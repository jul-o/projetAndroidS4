package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SignupActivity extends AppCompatActivity {
    DBAccount.AVATARS lastclicked = DBAccount.AVATARS.LOUTRE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void clickSubmit(View view) {
        TextView tvName = (TextView) findViewById(R.id.signupEditName);
        TextView tvFirstName = (TextView) findViewById(R.id.signupEditFirstName);
        int avatarChecked = 0;

        ArrayList<RadioButton> avatars = new ArrayList<>();
        RadioGroup RGAvatars = (RadioGroup) findViewById(R.id.signupRGAvatar);

        String name = new String(tvName.getText().toString());
        String firstName = new String(tvFirstName.getText().toString());

        DBAccount account = new DBAccount(name, firstName, lastclicked);
        account.save();

        Intent intent = new Intent(this, AccueilActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void clickBack(View view) {
        finish();
    }

    public void clickLoutre(View view) {
        lastclicked = DBAccount.AVATARS.LOUTRE;
    }

    public void clickOrni(View view) {
        lastclicked = DBAccount.AVATARS.ORNITHORYNQUE;
    }

    public void clickVache(View view) {
        lastclicked = DBAccount.AVATARS.VACHE;
    }
}
