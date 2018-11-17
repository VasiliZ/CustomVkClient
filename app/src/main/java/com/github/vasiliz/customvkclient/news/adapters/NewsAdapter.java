package com.github.vasiliz.customvkclient.news.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.vasiliz.customvkclient.R;
import com.github.vasiliz.customvkclient.entities.Attachment;
import com.github.vasiliz.customvkclient.entities.Group;
import com.github.vasiliz.customvkclient.entities.Items;
import com.github.vasiliz.customvkclient.entities.Profile;
import com.github.vasiliz.customvkclient.entities.ResponseNews;
import com.github.vasiliz.customvkclient.lib.base.ImageLoader;
import com.github.vasiliz.customvkclient.login.libs.GlideApp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<Items> newItems;
    private static final String TAG = NewsAdapter.class.getSimpleName();
    private OnItemClickListener mOnItemClickListener;
    private ImageLoader mImageLoader;
    private ResponseNews mResponseNews;
    private Context mContext;
    private static final String TYPE_NEWS = "post";

    public NewsAdapter(final List<Items> pNewItems, final OnItemClickListener pOnItemClickListener) {
        newItems = pNewItems;
        mOnItemClickListener = pOnItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup pViewGroup, final int pI) {
        mContext = pViewGroup.getContext();
        final View view = LayoutInflater.from(pViewGroup.getContext()).inflate(R.layout.item_news, pViewGroup, false);
        return new ViewHolder(view, pViewGroup.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder pViewHolder, final int pI) {
        switch (getItemViewType(pI)) {
            case 0:
                try {
                    Log.d(TAG, newItems.get(pI).getType());
                    final Group group;
                    final Profile profile;
                    if (findGroupSender(mResponseNews, pI) != null) {

                        group = findGroupSender(mResponseNews, pI);
                        pViewHolder.mProfileName.setText(group.getNameGroup());
                        Log.d(TAG, group.getNameGroup());
                        GlideApp.with(mContext)
                                .load(group.getUrlGroupPhoto100())
                                .into(pViewHolder.mProfilePhoto);
                    } else {
                        profile = findUserSender(mResponseNews, pI);
                        pViewHolder.mProfileName.setText(profile.getFirstName() + " " + profile.getLastName());
                        Log.d(TAG, profile.getFirstName() + " " + profile.getLastName());
                        GlideApp.with(mContext)
                                .load(profile.getUrlPhoto100())
                                .into(pViewHolder.mProfilePhoto);
                    }

                    //attachment content
                    if (!newItems.get(pI).getAttachments().isEmpty()) {
                        pViewHolder.mAttachmentsContainer.setVisibility(View.VISIBLE);
                        pViewHolder.setItems(newItems.get(pI).getAttachments());
                    } else {
                        pViewHolder.mAttachmentsContainer.setVisibility(View.GONE);
                    }

                    //like
                    if (newItems.get(pI).getLikes().getUserLike() == 1) {
                        pViewHolder.mLikeImage.setImageResource(R.drawable.liked_image);
                    }
                    Log.d(TAG, newItems.get(pI).getText());
                    if (!newItems.get(pI).getText().isEmpty()) {
                        pViewHolder.mTextNews.setVisibility(View.VISIBLE);
                        pViewHolder.mTextNews.setText(String.valueOf(newItems.get(pI).getText()));
                    } else {
                        pViewHolder.mTextNews.setVisibility(View.GONE);
                    }

                    pViewHolder.mCountLike.setText(String.valueOf(newItems.get(pI).getLikes().getCountLike()));

                    //comments
                    if (newItems.get(pI).getComments().getCanPost() == 0) {
                        pViewHolder.mCommentsContainer.setVisibility(View.GONE);
                    }
                    pViewHolder.mCountComments.setText(String.valueOf(newItems.get(pI).getComments().getCountComments()));

                    //repost
                    pViewHolder.mCountRepost.setText(String.valueOf(newItems.get(pI).getReposts().getCountReposts()));
                    pViewHolder.setOnClickListener(newItems.get(pI).getSourseId(), newItems.get(pI).getPostId());

                } catch (NullPointerException pE) {
                    pE.getLocalizedMessage();
                }
                default:
                   break;

        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (newItems.get(position).getType()) {
            case TYPE_NEWS:
                return 0;
            default:
                return 1;
        }
    }

    @Override
    public int getItemCount() {
        return newItems.size();
    }

    public void setItems(final ResponseNews pResponseNews) {
        mResponseNews = pResponseNews;
        newItems.clear();
        newItems.addAll(pResponseNews.getItemsList());
        notifyDataSetChanged();
    }

    private Group findGroupSender(final ResponseNews pNews, final int pPosition) {
        for (final Group groups : pNews.getGroupList()) {

            if (groups.getId() == newItems.get(pPosition).getSourseId() * -1) {
                Log.d(TAG, String.valueOf(groups.getId()));
                return groups;
            }
        }
        return null;
    }

    private Profile findUserSender(final ResponseNews pNews, final int pPosition) {
        for (final Profile profile : pNews.getProfileList()) {
            if (profile.getId() == newItems.get(pPosition).getSourseId()) {
                Log.d(TAG, String.valueOf(profile.getId()));
                return profile;
            }
        }
        return null;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.profile_photo)
        CircleImageView mProfilePhoto;
        @BindView(R.id.profile_name)
        TextView mProfileName;
        @BindView(R.id.time_post)
        TextView mTimePost;
        @BindView(R.id.text_news)
        TextView mTextNews;
        @BindView(R.id.likes_count_text_view)
        TextView mCountLike;
        @BindView(R.id.like_image_view)
        AppCompatImageView mLikeImage;
        @BindView(R.id.image_count_comment)
        AppCompatImageView mImageComment;
        @BindView(R.id.comments_count_text_view)
        TextView mCountComments;
        @BindView(R.id.comments_linear_layout)
        LinearLayout mCommentsContainer;
        @BindView(R.id.repost_count_text_view)
        TextView mCountRepost;
        @BindView(R.id.attachments_container)
        RecyclerView mAttachmentsContainer;
        private View mView;
        private List<Attachment> mAttachments;
        private AttachmentsAdapter mAttachmentsAdapter;

        public ViewHolder(@NonNull final View itemView, final Context pContext) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mView = itemView;
            mAttachmentsContainer.setHasFixedSize(true);
            mAttachments = new ArrayList<>();
            mAttachmentsAdapter = new AttachmentsAdapter(mAttachments, mImageLoader);
            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(pContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mAttachmentsContainer.setLayoutManager(linearLayoutManager);
            mAttachmentsContainer.setAdapter(mAttachmentsAdapter);

        }

        public void setItems(final List<Attachment> pItems) {
            mAttachments.clear();
            if (pItems != null) {
                mAttachments.addAll(pItems);
                mAttachmentsAdapter.notifyDataSetChanged();
            }
        }

        public void setOnClickListener(final int pIdOwner, final int pPostId) {
            mCommentsContainer.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(pIdOwner, pPostId);
                }
            });

        }
    }

    @Override
    public void onViewRecycled(@NonNull ViewHolder holder) {
        super.onViewRecycled(holder);
    }
}
