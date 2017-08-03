package com.example.risa.here_autopostbyvr;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FinishActivity extends AppCompatActivity {

    private MediaPlayer sound_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        // 音声ファイルの準備
        sound_finish = MediaPlayer.create(this, R.raw.decision);
        // 再生
        sound_finish.start();
    }
}
