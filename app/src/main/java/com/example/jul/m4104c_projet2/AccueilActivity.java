package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class SelectAccountOnClickListener implements View.OnClickListener{
    private Account acc;
    public SelectAccountOnClickListener(Account acc){
        this.acc = acc;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText((AccueilActivity)view.getContext(), acc.getFirstName(), Toast.LENGTH_SHORT).show();
    }
}

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        LinearLayout layoutAccounts = (LinearLayout) findViewById(R.id.accueilLayoutAccounts);
        List<Account> accounts = Account.listAll(Account.class);
        for(int i = 0; i < accounts.size(); i++){
            Account acc = accounts.get(i);
            LoginSelectAccount elt = new LoginSelectAccount(this, acc);
            layoutAccounts.addView(elt);
            /*TextView tvAcc = new TextView(this);
            tvAcc.setText(acc.getFirstName());
            layoutAccounts.addView(tvAcc);*/
        }

    }



    public void clickConnect(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void clickCreateAccount(View view) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
}
