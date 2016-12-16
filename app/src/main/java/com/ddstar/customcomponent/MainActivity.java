package com.ddstar.customcomponent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.LoadingView).setOnClickListener(this);
        findViewById(R.id.Behavior).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    int offset = 10;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LoadingView:
                startActivity(new Intent(this, LoadingViewActivity1.class));
                break;
            case R.id.Behavior:
                startActivity(new Intent(this, BehaviorActivity.class));
                break;
            case R.id.button2:
            case R.id.button3:
                v.offsetTopAndBottom(offset);
                break;
        }
    }
}
