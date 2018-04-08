package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SignupActivity extends AppCompatActivity {
    DBAccount.AVATARS lastclicked = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        RadioGroup group = (RadioGroup) findViewById(R.id.signupRGAvatar);
        for (int i = 0; i < group.getChildCount(); i++) {
            group.getChildAt(i).setBackgroundColor(Color.argb(0, 0, 0, 0));
        }
    }

    public void clickSubmit(View view) {
        TextView tvName = (TextView) findViewById(R.id.signupEditName);
        TextView tvFirstName = (TextView) findViewById(R.id.signupEditFirstName);
        int avatarChecked = 0;

        ArrayList<RadioButton> avatars = new ArrayList<>();
        RadioGroup RGAvatars = (RadioGroup) findViewById(R.id.signupRGAvatar);

        String name = new String(tvName.getText().toString());
        String firstName = new String(tvFirstName.getText().toString());

        if (testerValid(firstName, name, lastclicked)) {

            DBAccount account = new DBAccount(name, firstName, lastclicked);
            account.save();

            Intent intent = new Intent(this, AccueilActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    private boolean testerValid(String firstName, String name, DBAccount.AVATARS lastclicked) {
        List<DBAccount> accounts = DBAccount.listAll(DBAccount.class);
        for(DBAccount a: accounts){
            if((a.getFirstName().equals(firstName) && a.getName().equals(name))){
                //name and first name exist
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_add_score, (ViewGroup) findViewById(R.id.toast_add_score_root));
                Toast notify = new Toast(this);
                notify.setView(layout);
                notify.setDuration(Toast.LENGTH_LONG);
                TextView infoNotify = layout.findViewById(R.id.toastAddScoreTVInfo);
                infoNotify.setText("Tu dois changer ton nom ou ton prénom");
                notify.show();
                return false;
            }
        }
        if(firstName.equals("")||name.equals("")){
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast_add_score, (ViewGroup) findViewById(R.id.toast_add_score_root));
            Toast notify = new Toast(this);
            notify.setView(layout);
            notify.setDuration(Toast.LENGTH_LONG);
            TextView infoNotify = layout.findViewById(R.id.toastAddScoreTVInfo);
            infoNotify.setText("Tu dois entrer un nom et un prénom");
            notify.show();
            return false;
        }
        if(lastclicked == null){
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast_add_score, (ViewGroup) findViewById(R.id.toast_add_score_root));
            Toast notify = new Toast(this);
            notify.setView(layout);
            notify.setDuration(Toast.LENGTH_LONG);
            TextView infoNotify = layout.findViewById(R.id.toastAddScoreTVInfo);
            infoNotify.setText("Tu dois sélectionner un avatar");
            notify.show();
            return false;
        }
        return true;
    }

    public void clickBack(View view) {
        finish();
    }

    public void clickLoutre(View view) {
        RadioGroup group = (RadioGroup) findViewById(R.id.signupRGAvatar);
        for (int i = 0; i < group.getChildCount(); i++) {
            group.getChildAt(i).setBackgroundColor(Color.argb(0, 0, 0, 0));
        }
        group.getChildAt(0).setBackgroundColor(Color.argb(255, 53, 45, 191));

        lastclicked = DBAccount.AVATARS.LOUTRE;
    }

    public void clickOrni(View view) {
        RadioGroup group = (RadioGroup) findViewById(R.id.signupRGAvatar);
        for (int i = 0; i < group.getChildCount(); i++) {
            group.getChildAt(i).setBackgroundColor(Color.argb(0, 0, 0, 0));
        }
        group.getChildAt(1).setBackgroundColor(Color.argb(255, 53, 45, 191));

        lastclicked = DBAccount.AVATARS.ORNITHORYNQUE;
    }

    public void clickVache(View view) {
        RadioGroup group = (RadioGroup) findViewById(R.id.signupRGAvatar);
        for (int i = 0; i < group.getChildCount(); i++) {
            group.getChildAt(i).setBackgroundColor(Color.argb(0, 0, 0, 0));
        }
        group.getChildAt(2).setBackgroundColor(Color.argb(255, 53, 45, 191));

        lastclicked = DBAccount.AVATARS.VACHE;
    }

    enum ERR_SUBMIT {
        NO_FIRST_NAME,
        NO_NAME,
        NO_AVATAR,
        NAME_AND_FIRST_NAME_TAKEN
    }
}
