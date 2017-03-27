package com.sample.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sample.mvp.views.AccountDetailsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.rlContainer,new AccountDetailsFragment()).commit();
        }
    }
}
