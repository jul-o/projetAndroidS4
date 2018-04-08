package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    DBAccount account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.account = DBAccount.currentAccount;
        TextView tv = (TextView) findViewById(R.id.homeTVFirstName);
        tv.setText(account.getFirstName() + " ");

        tv = (TextView) findViewById(R.id.homeTVName);
        tv.setText(account.getName());

        tv = (TextView) findViewById(R.id.homeTVScore);
        tv.setText("Score : " + account.getScore());

        /*tv = (TextView) findViewById(R.id.homeTVAvatar);
        tv.setText(account.getAvatar());*/
        ImageView imgAvatar = (ImageView) findViewById(R.id.homeIVAvatar);
        switch (account.getAvatar()){
            case LOUTRE:
                imgAvatar.setImageResource(R.mipmap.ic_loutre);
                break;
            case ORNITHORYNQUE:
                imgAvatar.setImageResource(R.mipmap.ic_ornithorynque);
                break;
            case VACHE:
                imgAvatar.setImageResource(R.mipmap.ic_vache);
                break;

        }
        //imgAvatar.setImageResource(R.drawable.);
    }

    public void clickDisconnect(View view) {
        Intent intent = new Intent(this, AccueilActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        DBAccount.currentAccount = null;
        startActivity(intent);
        finish();
    }

    public void clickMaths(View view) {
        Intent intent = new Intent(this, ChoiceExsMathsActivity.class);
        startActivity(intent);
    }

    public void clickFr(View view) {
        Intent intent = new Intent(this, ChoiceExsCultureActivity.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {

    }
}
