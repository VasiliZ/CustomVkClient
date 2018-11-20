package com.github.vasiliz.customvkclient.news.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vasiliz.customvkclient.R;
import com.github.vasiliz.customvkclient.entities.news.Attachment;
import com.github.vasiliz.customvkclient.entities.news.Audio;
import com.github.vasiliz.customvkclient.entities.news.Photo;
import com.github.vasiliz.customvkclient.login.libs.GlideApp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttachmentsAdapter extends RecyclerView.Adapter {

    private List<List<Attachment>> mAttachments;
    private static final String TYPE_PHOTO = "photo";
    private static final String TYPE_AUDIO = "audio";

    public AttachmentsAdapter() {
        mAttachments = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup pViewGroup, final int pViewType) {
        switch (pViewType) {
            case 1:
                View view = LayoutInflater.from(pViewGroup.getContext()).inflate(R.layout.contents_attach, pViewGroup, false);
                return new AttachmentsHolder(view, pViewGroup.getContext());
            case 2:
                View view1 = LayoutInflater.from(pViewGroup.getContext()).inflate(R.layout.audio_attachment, pViewGroup, false);
                return new AudioAttachment(view1, pViewGroup.getContext());

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder pViewHolder, final int pI) {
        if (mAttachments.get(pI).get(0) instanceof Photo) {
            GlideApp.with(((AttachmentsHolder) pViewHolder).mImageView).clear(((AttachmentsHolder) pViewHolder).mImageView);
            ((AttachmentsHolder) pViewHolder).setPhoto(mAttachments.get(pI));
        }
        if (mAttachments.get(pI).get(0) instanceof Audio) {
            ((AudioAttachment) pViewHolder).setAudio(mAttachments.get(pI));
        }

    }

    public void setItems(List<List<Attachment>> pItems) {
        mAttachments.clear();
        mAttachments.addAll(pItems);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mAttachments.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mAttachments.get(position).get(0) instanceof Photo) {
            System.out.println(TYPE_PHOTO);
            return 1;
        }
        if (mAttachments.get(position).get(0) instanceof Audio) {
            System.out.println(TYPE_AUDIO);
            return 2;
        } else {
            System.out.println(mAttachments.get(position).get(0).getTypeAttachments());
        }
        return -1;
    }

    class AttachmentsHolder extends RecyclerView.ViewHolder {

        private List<Attachment> mPhotos;
        private Context mContext;

        @BindView(R.id.type_attach)
        RecyclerView mAttachContent;
        @BindView(R.id.fuck)
        TextView mTextView;
        @BindView(R.id.image_ska)
        ImageView mImageView;
        private ImagesAdapter mImagesAdapter;

        public AttachmentsHolder(@NonNull final View itemView, final Context pContext) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = pContext;
            mPhotos = new ArrayList<>();

            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mImagesAdapter = new ImagesAdapter(mPhotos);
            mAttachContent.setLayoutManager(linearLayoutManager);
            mAttachContent.setAdapter(mImagesAdapter);

        }

        public void setPhoto(final List<Attachment> pPhoto) {
            mPhotos.clear();
            mPhotos.addAll(pPhoto);
        }
    }

    class AudioAttachment extends RecyclerView.ViewHolder {

        @BindView(R.id.list_audio)
        RecyclerView mRecyclerView;
        private List<Attachment> mAttachments;

        AudioAttachment(@NonNull final View itemView, Context pContext) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mAttachments = new ArrayList<>();
            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(pContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ListAudioAdapter listAudioAdapter = new ListAudioAdapter(mAttachments);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.setAdapter(listAudioAdapter);

        }

        public void setAudio(List<Attachment> pAudio) {
            mAttachments.clear();
            mAttachments.addAll(pAudio);

        }
    }

    class VideoAttachment extends RecyclerView.ViewHolder {

        @BindView(R.id.video_text_view)
        TextView mTextView;

        VideoAttachment(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class DocAttachment extends RecyclerView.ViewHolder {

        @BindView(R.id.doc_text_view)
        TextView mTextView;

        DocAttachment(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class LinkAttachment extends RecyclerView.ViewHolder {

        @BindView(R.id.link_text_view)
        TextView mTextView;

        LinkAttachment(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
