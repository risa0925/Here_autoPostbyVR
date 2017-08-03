package com.example.risa.here_autopostbyvr;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;

public class RunActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private Handler handler = new Handler();
    private MediaPlayer sound_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        chronometer = (Chronometer)findViewById(R.id.chronometer);
        Button startButton = (Button)findViewById(R.id.button_start);

        //インテントの作成
        final Intent intent_finishActivity = new Intent(this,FinishActivity.class);
        // 音声ファイルの準備
        sound_start = MediaPlayer.create(this, R.raw.decision1);
        //スタートボタンの設定
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 再生
                sound_start.start();
                // set the base to the current time just before calling start()
                chronometer.setBase(SystemClock.elapsedRealtime());
                //スタート
                chronometer.start();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //10分後に画面遷移
                        startActivityForResult(intent_finishActivity, 0);
                    }
                }, 5000);
            }
        });



    }
}
