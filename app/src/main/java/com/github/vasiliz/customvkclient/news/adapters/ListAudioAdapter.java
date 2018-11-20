package com.github.vasiliz.customvkclient.news.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.vasiliz.customvkclient.R;
import com.github.vasiliz.customvkclient.entities.news.Attachment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAudioAdapter extends RecyclerView.Adapter<ListAudioAdapter.AudioHolder> {

    private List<Attachment> mAttachments;

    public ListAudioAdapter(List<Attachment> pAttachments) {
        mAttachments = pAttachments;
    }

    @NonNull
    @Override
    public AudioHolder onCreateViewHolder(@NonNull ViewGroup pViewGroup, int pI) {
        View view = LayoutInflater.from(pViewGroup.getContext()).inflate(R.layout.audio_item, pViewGroup, false);

        return new AudioHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioHolder pAudioHolder, int pI) {
        pAudioHolder.mTextView.setText("audio item here");
    }

    @Override
    public int getItemCount() {
        return mAttachments.size();
    }

    class AudioHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_audio_item)
        TextView mTextView;

        public AudioHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
