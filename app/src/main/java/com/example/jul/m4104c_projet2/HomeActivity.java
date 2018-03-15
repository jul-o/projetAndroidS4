package com.example.jul.m4104c_projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {
    Account account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        long idAcc = (Long) getIntent().getExtras().get(AccueilActivity.EXTRA_ACCOUNT);
        this.account = Account.findById(Account.class, idAcc);
        TextView tv = (TextView) findViewById(R.id.homeTVFirstName);
        tv.setText(account.getFirstName());
        tv = (TextView) findViewById(R.id.homeTVName);
        tv.setText(account.getName());
        tv = (TextView) findViewById(R.id.homeTVAvatar);
        tv.setText(account.getAvatar());
    }

    public void clickDisconnect(View view) {
        Intent intent = new Intent(this, AccueilActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Account.currentAccount = null;
        startActivity(intent);
        finish();
    }

    public void clickMaths(View view) {
        Intent intent = new Intent(this, ChoiceExsMaths.class);
        startActivity(intent);
    }
}
