package com.example.b10706.termproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

/**
 * Created by B10706 on 2016-12-01.
 */

public class MediaItem {
    final static int RAW=0;
    final static int SDCARD=1;
    final static int WEB=2;
    final static int AUDIO=3;
    final static int VIDEO=4;
    final static int IMAGE=5;

    int source;
    String name;
    Uri uri;
    int type;
    Bitmap bitmap;

    public MediaItem(int src, String name, Uri uri) {
        source = src;
        this.name = name;
        this.uri = uri;
        type = AUDIO;
    }

    public MediaItem(int src, String name, Uri uri, int type) {
        source = src;
        this.name = name;
        this.uri = uri;
        this.type = type;
        if (type == IMAGE)
            bitmap = BitmapFactory.decodeFile(uri.getPath());
        else bitmap = null;
    }
}

