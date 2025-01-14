package cn.jxufe.cn.myapplication4.Activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import cn.jxufe.cn.myapplication4.R;

public class Part1Activity extends Activity {
    private VideoView mVideoView;
    private Button playBtn, stopBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);
        mVideoView = new VideoView(this);
        mVideoView = (VideoView) findViewById(R.id.video);
        //mMediaController = new MediaController(this);
        playBtn = (Button) findViewById(R.id.playbutton);
        stopBtn = (Button) findViewById(R.id.stopbutton);
        playBtn.setOnClickListener(new mClick());
        stopBtn.setOnClickListener(new mClick());
    }

    class mClick implements OnClickListener {
        @Override
        public void onClick(View v) {
            String uri = "android.resource://" + getPackageName() + "/" + R.raw.chinatea;  //本地

            mVideoView.setVideoURI(Uri.parse(uri));  //本地

            //mMediaController.setMediaPlayer(mVideoView);
           // mVideoView.setMediaController(mMediaController);
            if (v == playBtn) {
                mVideoView.start();
            } else if (v == stopBtn) {
                mVideoView.stopPlayback();
            }
        }
    }
}





