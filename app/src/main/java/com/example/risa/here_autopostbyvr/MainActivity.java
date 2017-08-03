package com.example.risa.here_autopostbyvr;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button button_segue;
    private MediaPlayer sound_first;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_segue = (Button)findViewById(R.id.button);
        button_segue.setOnClickListener(this);
        // 音声ファイルの準備
        sound_first = MediaPlayer.create(this, R.raw.decision2);
    }

    //スタートボタンクリック時のメソッド
    public void onClick(View v){
        if(v==button_segue){
            //音の再生
            sound_first.start();
            //インテントの作成
            Intent intent = new Intent(this,RunActivity.class);
            startActivityForResult(intent, 0);
        }
    }
}
