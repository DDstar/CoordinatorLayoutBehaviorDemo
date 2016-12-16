package com.ddstar.customcomponent;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fenjuly.library.ArrowDownloadButton;

public class LoadingViewActivity1 extends AppCompatActivity {

    private ArrowDownloadButton downLoadView;
    int clickTimes;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_view1);
        downLoadView = (ArrowDownloadButton) findViewById(R.id.downloadBtn);
        downLoadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickTimes++;
                if (clickTimes % 2 != 0) {
                    progress = 0;
                    downLoadView.startAnimating();
                    downLoadView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progress += 1;
                            downLoadView.setProgress(progress);
                            downLoadView.postDelayed(this, 500);
                        }
                    }, 500);
                } else {
                    downLoadView.reset();
                }
            }
        });
    }
}
