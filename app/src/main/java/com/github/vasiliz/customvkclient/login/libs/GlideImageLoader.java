package com.github.vasiliz.customvkclient.login.libs;

import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.github.vasiliz.customvkclient.lib.base.ImageLoader;

public class GlideImageLoader implements ImageLoader {

    private RequestManager mRequestManager;

    public GlideImageLoader(RequestManager pRequestManager) {
        mRequestManager = pRequestManager;
    }

    @Override
    public void load(ImageView pImageView, String url) {
        RequestOptions requestOptions = new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(600, 400);

        mRequestManager
                .load(url)
                .apply(requestOptions)
                .into(pImageView);
    }
}
