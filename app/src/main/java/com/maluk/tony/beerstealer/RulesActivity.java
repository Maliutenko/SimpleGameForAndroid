package com.maluk.tony.beerstealer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tony on 29.08.2016.
 */
public class RulesActivity extends StartActivity implements View.OnClickListener{

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        button = (Button)findViewById(R.id.back_button);
        button.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.back_button:
                startActivity(new Intent(this,StartActivity.class));finish();break;
        }
    }
}