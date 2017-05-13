package com.example.korinel.onair_03;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import net.majorkernelpanic.streaming.SessionBuilder;
import net.majorkernelpanic.streaming.audio.AudioQuality;
import net.majorkernelpanic.streaming.gl.SurfaceView;
import net.majorkernelpanic.streaming.rtsp.RtspServer;
import net.majorkernelpanic.streaming.video.VideoQuality;

public class Main2Activity extends AppCompatActivity {
    private final static String TAG = "Main2Activity";
    private SurfaceView mSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Sets the port of the RTSP server to 1234
        mSurfaceView = (SurfaceView) findViewById(R.id.surface);
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        editor.putString(RtspServer.KEY_PORT, String.valueOf(1234));
        editor.commit();
        // Configures the SessionBuilder
        SessionBuilder.getInstance()
                .setSurfaceView(mSurfaceView)
                .setPreviewOrientation(90)
                .setContext(getApplicationContext())
                .setAudioEncoder(SessionBuilder.AUDIO_AAC)
                .setVideoEncoder(SessionBuilder.VIDEO_H264)
                //.setCamera(Camera.CameraInfo.CAMERA_FACING_FRONT)
                //.setVideoQuality(new VideoQuality(640, 480, 25, 500000))
                .setAudioQuality(new AudioQuality(8000, 16000));



        Main2Activity.this.startService(new Intent(this,RtspServer.class));

    }

    /**/

    public void rtspStop(View view){
        Main2Activity.this.stopService(new Intent(Main2Activity.this,RtspServer.class));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //rtsp://192.168.0.101:1234?h264=2000000-30-1280-720
        //rtsp://192.168.0.108:1234?h264=500000-25-640-480

    }
}
