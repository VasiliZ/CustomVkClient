package com.github.vasiliz.customvkclient.login.libs;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.github.vasiliz.customvkclient.lib.base.ImageLoader;

import java.lang.annotation.Target;

public class GlideImageLoader implements ImageLoader {
    private AppCompatActivity mAppCompatActivity;

    public GlideImageLoader(AppCompatActivity pAppCompatActivity) {
        mAppCompatActivity = pAppCompatActivity;
    }

    @Override
    public void load(ImageView pImageView, String url) {
        RequestOptions requestOptions = new RequestOptions();
        GlideRequests glideRequests = GlideApp.with(mAppCompatActivity);
        GlideApp.with(mAppCompatActivity).clear(pImageView);
        glideRequests.load(url).apply(requestOptions).into(pImageView);
    }
}
