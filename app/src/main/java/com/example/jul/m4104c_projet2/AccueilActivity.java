package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AccueilActivity extends AppCompatActivity {
    public static final String EXTRA_ACCOUNT = "account";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        //Si une session est en cours, redirection vers la page home
        if (Account.currentAccount != null) {
            clickAccount(Account.currentAccount);
        }
        LinearLayout layoutAccounts = (LinearLayout) findViewById(R.id.accueilLayoutAccounts);
        List<Account> accounts = Account.listAll(Account.class);
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            LoginSelectAccount elt = new LoginSelectAccount(this, acc);
            layoutAccounts.addView(elt);
        }

    }


    public void clickCreateAccount(View view) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void clickAccount(Account acc) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(EXTRA_ACCOUNT, acc.getId());
        startActivity(intent);
        finish();
    }
}