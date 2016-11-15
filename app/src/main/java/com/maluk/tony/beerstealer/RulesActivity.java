package com.maluk.tony.beerstealer;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tony on 29.08.2016.
 */
public class RulesActivity extends StartActivity implements View.OnClickListener{

    Button button;
    TextView tvOne;
    TextView tvTwo;
    TextView tvThree;
    TextView tvFour;
    ImageView ivLightOne;
    ImageView ivLightTwo;
    ImageView ivDark;
    ImageView ivRedArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        tvOne = (TextView)findViewById(R.id.text_rules_one);
        tvTwo = (TextView)findViewById(R.id.text_rules_two);
        tvThree = (TextView)findViewById(R.id.text_rules_three);
        tvFour = (TextView)findViewById(R.id.text_rules_four);
        ivLightOne = (ImageView)findViewById(R.id.image_view_light);
        ivLightTwo = (ImageView)findViewById(R.id.image_view_light_two);
        ivDark = (ImageView)findViewById(R.id.image_view_dark);
        ivRedArrow = (ImageView)findViewById(R.id.image_view_arrow);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "matreshka.ttf");
        tvOne.setTypeface(typeface);
        tvTwo.setTypeface(typeface);
        tvThree.setTypeface(typeface);
        tvFour.setTypeface(typeface);

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