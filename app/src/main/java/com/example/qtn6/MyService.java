package com.example.qtn6;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import androidx.annotation.Nullable;

public class MyService extends Service {
    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Start playing the ringtone or music
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();

        // Return START_STICKY to keep the service running in the background
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Stop the ringtone or music when the service is destroyed
        player.stop();
        player.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
