package com.maluk.tony.beerstealer;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.startad.lib.SADView;

/**
 * Created by Tony on 09.09.2016.
 */
public class EndActivity extends StartActivity implements View.OnClickListener {

    TextView tvResult;
    TextView tvScreenshot;
    Button btnTryAgain;
    Button btnQuit;
    protected SADView sadView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        //startAD banner

        this.sadView = new SADView(this, "57c37cb84222dc5c008b4567");
        LinearLayout layout = (LinearLayout)findViewById(R.id.banner_startad);
        layout.addView(this.sadView);
        String locale = java.util.Locale.getDefault().getLanguage();
        if(locale.equals("en")){
            this.sadView.loadAd(SADView.LANGUAGE_EN);
        }
        if(locale.equals("ru")){
            this.sadView.loadAd(SADView.LANGUAGE_RU);
        }

        tvResult = (TextView) findViewById(R.id.result_view);
        tvScreenshot = (TextView) findViewById(R.id.text_screenshot);
        btnTryAgain = (Button) findViewById(R.id.button_try_again);
        btnQuit = (Button) findViewById(R.id.button_quit);
        btnQuit.setOnClickListener(this);
        btnTryAgain.setOnClickListener(this);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/comicrazy.ttf");
        tvResult.setTypeface(typeface);

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

    @Override
    public void onDestroy() {
        if (this.sadView != null) {
            this.sadView.destroy();
        }
        super.onDestroy();
    }
}
