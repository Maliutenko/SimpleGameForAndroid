package com.maluk.tony.beerstealer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tony on 09.09.2016.
 */
public class EndActivity extends StartActivity implements View.OnClickListener {

    TextView tvResult;
    TextView tvScreenshot;
    Button btnTryAgain;
    Button btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        tvResult = (TextView) findViewById(R.id.result_View);
        tvScreenshot = (TextView) findViewById(R.id.text_screenshot);
        btnTryAgain = (Button) findViewById(R.id.button_try_again);
        btnQuit = (Button) findViewById(R.id.button_quit);
        btnQuit.setOnClickListener(this);
        btnTryAgain.setOnClickListener(this);

        Intent intent = getIntent();
        String resultcore = intent.getStringExtra("resultscore");
        tvResult.setText(resultcore);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_try_again:
                startActivity(new Intent(this, GameActivity.class));
                finish();
                break;
            case R.id.button_quit:
                finish();
                break;
        }
    }
}
