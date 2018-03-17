package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class AccueilActivity extends AppCompatActivity {
    public static final String EXTRA_ACCOUNT = "account";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        //Si une session est en cours, redirection vers la page home
        if (DBAccount.currentAccount != null) {
            clickAccount(DBAccount.currentAccount);
        }
        LinearLayout layoutAccounts = (LinearLayout) findViewById(R.id.accueilLayoutAccounts);
        List<DBAccount> accounts = DBAccount.listAll(DBAccount.class);
        for (int i = 0; i < accounts.size(); i++) {
            DBAccount acc = accounts.get(i);
            LoginSelectAccount elt = new LoginSelectAccount(this, acc);
            layoutAccounts.addView(elt);
        }

    }


    public void clickCreateAccount(View view) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void clickAccount(DBAccount acc) {
        Intent intent = new Intent(this, HomeActivity.class);
        DBAccount.currentAccount = acc;
        startActivity(intent);
        finish();
    }
}