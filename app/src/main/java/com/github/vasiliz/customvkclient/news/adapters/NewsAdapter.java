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

import com.bumptech.glide.Glide;
import com.github.vasiliz.customvkclient.R;
import com.github.vasiliz.customvkclient.entities.news.ArraysItems;
import com.github.vasiliz.customvkclient.entities.news.Attachment;
import com.github.vasiliz.customvkclient.entities.news.Group;
import com.github.vasiliz.customvkclient.entities.news.Item;
import com.github.vasiliz.customvkclient.entities.news.Profile;
import com.github.vasiliz.customvkclient.entities.news.ResponseNews;
import com.github.vasiliz.customvkclient.login.libs.GlideApp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<Item> mNewItems;
    private static final String TAG = NewsAdapter.class.getSimpleName();
    private OnItemClickListener mOnItemClickListener;
    private ResponseNews mResponseNews;
    private Context mContext;
    private ArraysItems mArraysItems;

    public NewsAdapter(final List<Item> pNewItems, final OnItemClickListener pOnItemClickListener) {
        mNewItems = pNewItems;
        mOnItemClickListener = pOnItemClickListener;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull final ViewGroup pViewGroup, final int pI) {
        mContext = pViewGroup.getContext();
        final View view = LayoutInflater.from(pViewGroup.getContext()).inflate(R.layout.item_news, pViewGroup, false);
        return new NewsHolder(view, pViewGroup.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsHolder pNewsHolder, final int pI) {
        final Item item = mNewItems.get(pI);
        try {
            mArraysItems = new ArraysItems();
            Log.d(TAG, item.getType());
            final Group group;
            final Profile profile;

            if (findGroupSender(mResponseNews, pI) != null) {

                group = findGroupSender(mResponseNews, pI);
                pNewsHolder.mProfileName.setText(group.getNameGroup());
                Log.d(TAG, group.getNameGroup());
                GlideApp.with(mContext)
                        .load(group.getUrlGroupPhoto100())
                        .into(pNewsHolder.mProfilePhoto);
            } else {
                profile = findUserSender(mResponseNews, pI);
                pNewsHolder.mProfileName.setText(profile.getFirstName() + " " + profile.getLastName());
                Log.d(TAG, profile.getFirstName() + " " + profile.getLastName());
                GlideApp.with(mContext)
                        .load(profile.getUrlPhoto100())
                        .into(pNewsHolder.mProfilePhoto);
            }
            //like
            if (item.getLikes().getUserLike() == 1) {
                pNewsHolder.mLikeImage.setImageResource(R.drawable.liked_image);
            }
            pNewsHolder.mCountLike.setText(String.valueOf(item.getLikes().getCountLike()));

            //text news
            Log.d(TAG, item.getText());
            if (!item.getText().isEmpty()) {
                pNewsHolder.mTextNews.setVisibility(View.VISIBLE);
                pNewsHolder.mTextNews.setText(String.valueOf(item.getText()));
            } else {
                pNewsHolder.mTextNews.setVisibility(View.GONE);
            }


            //comments
            Log.d(TAG, String.valueOf(item.getComments().getCanPost()));
            if (item.getComments().getCanPost() == 0) {
                pNewsHolder.mCommentsContainer.setVisibility(View.GONE);
            }
            pNewsHolder.mCountComments.setText(String.valueOf(item.getComments().getCountComments()));

            //repost
            pNewsHolder.mCountRepost.setText(String.valueOf(item.getReposts().getCountReposts()));
            pNewsHolder.setOnClickListener(item);
            //attachment content

            if (!item.getAttachments().isEmpty()) {
                for (int i = 0; i < item.getAttachments().size(); i++) {
                    mArraysItems.setItem(item.getAttachments().get(i));
                }
                Log.d(TAG + "1", String.valueOf(mArraysItems.getAttach().size()));
                if (!isVisible(pNewsHolder.mAttachmentsContainer)){
                    pNewsHolder.mAttachmentsContainer.setVisibility(View.VISIBLE);
                }
                mArraysItems.endOnStruct();
                pNewsHolder.setItems(mArraysItems.getAttach());

            } else {
                if (isVisible(pNewsHolder.mAttachmentsContainer)){
                    pNewsHolder.mAttachmentsContainer.setAdapter(null);
                    pNewsHolder.mAttachmentsContainer.setVisibility(View.GONE);
                }
            }
        } catch (final NullPointerException pE) {
            pE.getLocalizedMessage();
        }
    }

    @Override
    public int getItemCount() {
        return mNewItems.size();
    }

    public void setItems(final ResponseNews pResponseNews) {
        mResponseNews = pResponseNews;
        mNewItems.clear();
        mNewItems.addAll(pResponseNews.getItemList());
        notifyDataSetChanged();
    }

    private Group findGroupSender(final ResponseNews pNews, final int pPosition) {
        for (final Group groups : pNews.getGroupList()) {

            if (groups.getId() == mNewItems.get(pPosition).getSourseId() * -1) {
                Log.d(TAG, String.valueOf(groups.getId()));
                return groups;
            }
        }
        return null;
    }

    private Profile findUserSender(final ResponseNews pNews, final int pPosition) {
        for (final Profile profile : pNews.getProfileList()) {
            if (profile.getId() == mNewItems.get(pPosition).getSourseId()) {
                Log.d(TAG, String.valueOf(profile.getId()));
                return profile;
            }
        }
        return null;
    }
    private boolean isVisible(View view){
        return view.getVisibility()==View.VISIBLE;
    }

    class NewsHolder extends RecyclerView.ViewHolder {

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
        private AttachmentsAdapter mAttachmentsAdapter;

        public NewsHolder(@NonNull final View itemView, final Context pContext) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mView = itemView;
            mAttachmentsAdapter = new AttachmentsAdapter();
            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(pContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mAttachmentsContainer.setLayoutManager(linearLayoutManager);
            mAttachmentsContainer.setAdapter(mAttachmentsAdapter);

        }

        public void setItems(final List<List<Attachment>> pItems) {
            if (pItems != null) {

                mAttachmentsAdapter.setItems(pItems);
            }
        }

        public void setOnClickListener(final Item pItem) {
            mCommentsContainer.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(final View v) {
                    mOnItemClickListener.onItemClick(pItem);
                }
            });

        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull NewsHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.mAttachmentsContainer.setVisibility(View.GONE);

    }


}
