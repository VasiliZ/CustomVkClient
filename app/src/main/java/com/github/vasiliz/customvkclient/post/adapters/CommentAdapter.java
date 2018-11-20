package com.github.vasiliz.customvkclient.post.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.vasiliz.customvkclient.R;
import com.github.vasiliz.customvkclient.entities.comments.ItemComment;
import com.github.vasiliz.customvkclient.entities.news.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {

    private List<ItemComment> mResponseComment;

    public CommentAdapter(List<ItemComment> pResponseComment) {
        mResponseComment = pResponseComment;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup pViewGroup, int pI) {
        View view = LayoutInflater.from(pViewGroup.getContext()).inflate(R.layout.comment_item, pViewGroup, false);
        return new CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder pCommentHolder, int pI) {
        pCommentHolder.mTextComment.setText(mResponseComment.get(pI).getTextComment());

    }

    @Override
    public int getItemCount() {
        return mResponseComment.size();
    }

    public void addNewItem(String pS){
        ItemComment itemComment = new ItemComment();
        itemComment.setTextComment(pS);
        mResponseComment.add(itemComment);
        notifyDataSetChanged();
    }

    public void setComments(List<ItemComment> pComments){
        mResponseComment.clear();
        mResponseComment.addAll(pComments);
        notifyDataSetChanged();
    }

    class CommentHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_comment)
        TextView mTextComment;

        public CommentHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
