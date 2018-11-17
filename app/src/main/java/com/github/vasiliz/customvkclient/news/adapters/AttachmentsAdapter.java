package com.github.vasiliz.customvkclient.news.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.vasiliz.customvkclient.R;
import com.github.vasiliz.customvkclient.entities.Attachment;
import com.github.vasiliz.customvkclient.lib.base.ImageLoader;
import com.github.vasiliz.customvkclient.login.libs.GlideApp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttachmentsAdapter extends RecyclerView.Adapter {

    private List<Attachment> mAttachments;
    private static final String TYPE_PHOTO = "photo";
    private static final String TYPE_AUDIO = "audio";
    private static final String TYPE_VIDEO = "video";
    private static final String TYPE_DOC = "doc";
    private static final String TYPE_LINK = "link";
    private static final String TYPE_GIF = "gif";

    public AttachmentsAdapter(final List<Attachment> pAttachments, final ImageLoader pImageLoader) {
        mAttachments = pAttachments;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup pViewGroup, final int pI) {
        switch (pI) {
            case 0:
                final View view = LayoutInflater.from(pViewGroup.getContext()).inflate(R.layout.image_attachment, pViewGroup, false);
                return new ViewHolder(view);
            default:
                final View view1 = LayoutInflater.from(pViewGroup.getContext()).inflate(R.layout.another_attachment, pViewGroup, false);
                return new AnotherAttachment(view1);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder pViewHolder, int pI) {
        Log.d("TAG", mAttachments.get(pI).getTypeAttachments());
        switch (mAttachments.get(pI).getTypeAttachments()) {
            case TYPE_PHOTO:
                ViewHolder viewHolder = (ViewHolder) pViewHolder;
                if (!mAttachments.isEmpty()) {
                    viewHolder.mImageView.setVisibility(View.VISIBLE);
                    GlideApp.with(viewHolder.mImageView)
                            .load(mAttachments.get(pI).getPhotoType().getPhoto604())
                            .fitCenter()
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .placeholder(R.drawable.no_image_available)
                            .into(viewHolder.mImageView);
                } else {
                    GlideApp.with(((ViewHolder) pViewHolder).mImageView).clear(((ViewHolder) pViewHolder).mImageView);
                }
                break;
            case TYPE_AUDIO:
                AnotherAttachment attach = (AnotherAttachment) pViewHolder;
                break;
            case TYPE_DOC:
                AnotherAttachment attach1 = (AnotherAttachment) pViewHolder;
                break;
            case TYPE_GIF:
                AnotherAttachment attach2 = (AnotherAttachment) pViewHolder;
                break;
            case TYPE_LINK:
                AnotherAttachment attach3 = (AnotherAttachment) pViewHolder;
                break;
            case TYPE_VIDEO:
                AnotherAttachment attach4 = (AnotherAttachment) pViewHolder;
                break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (mAttachments.get(position).getTypeAttachments()) {
            case TYPE_PHOTO:
                return 0;
            case TYPE_AUDIO:
                return 2;
            case TYPE_DOC:
                return 3;
            case TYPE_LINK:
                return 4;
            case TYPE_VIDEO:
                return 5;
            case TYPE_GIF:
                return 6;
        }
        return 1;
    }

    @Override
    public int getItemCount() {
        return mAttachments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_content)
        ImageView mImageView;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class AnotherAttachment extends RecyclerView.ViewHolder {

        AnotherAttachment(@NonNull View itemView) {
            super(itemView);
        }
    }

}
