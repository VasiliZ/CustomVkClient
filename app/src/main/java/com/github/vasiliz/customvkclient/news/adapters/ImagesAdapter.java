package com.github.vasiliz.customvkclient.news.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.vasiliz.customvkclient.R;
import com.github.vasiliz.customvkclient.entities.news.Attachment;
import com.github.vasiliz.customvkclient.entities.news.Photo;
import com.github.vasiliz.customvkclient.login.libs.GlideApp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageHolder> {

    private List<Attachment> mPhotoList;

    public ImagesAdapter(List<Attachment> pAttachments) {
        mPhotoList = pAttachments;

    }

    @NonNull
    @Override
    public ImagesAdapter.ImageHolder onCreateViewHolder(@NonNull ViewGroup pViewGroup, int pI) {
        View view = LayoutInflater.from(pViewGroup.getContext()).inflate(R.layout.images_item, pViewGroup, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder pImageHolder, int pI) {
        Photo photo;
        if (!mPhotoList.isEmpty()) {
            photo = (Photo) mPhotoList.get(pI);
            pImageHolder.mImageView.setVisibility(View.VISIBLE);
            GlideApp.with(pImageHolder.mImageView)
                    .load(photo.getPhoto604())
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .placeholder(R.drawable.no_image_available)
                    .into(pImageHolder.mImageView);
        }
    }


    @Override
    public int getItemCount() {
        Log.d("PHOTOADAPTER", String.valueOf(mPhotoList.size()));
        return mPhotoList.size();
    }

    public class ImageHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_in_post)
        ImageView mImageView;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
