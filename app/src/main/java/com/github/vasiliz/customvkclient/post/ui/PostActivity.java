package com.github.vasiliz.customvkclient.post.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.vasiliz.customvkclient.CustomVkClient;
import com.github.vasiliz.customvkclient.R;
import com.github.vasiliz.customvkclient.commons.Strings;
import com.github.vasiliz.customvkclient.entities.comments.ResponseComment;
import com.github.vasiliz.customvkclient.post.PostPresenter;
import com.github.vasiliz.customvkclient.post.adapters.CommentAdapter;
import com.github.vasiliz.customvkclient.post.di.PostComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PostActivity extends AppCompatActivity implements PostView {

    private SharedPreferences mSharedPreferences;
    @BindView(R.id.load_comment_progress)
    ProgressBar mProgressBar;
    @BindView(R.id.users_comment)
    RecyclerView mRecyclerView;
    @BindView(R.id.btnSendMessage)
    ImageButton mImageButton;
    @BindView(R.id.editTxtMessage)
    EditText mText;
    @Inject
    PostPresenter mPostPresenter;
    @Inject
    CommentAdapter mCommentAdapter;
    private int sourseId;
    private int postId;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.some_post);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        sourseId = bundle.getInt(Strings.SOURSE_ID);
        postId = bundle.getInt(Strings.POST_ID);
        setUpInjection();
        setUpRecyclerView();
        mSharedPreferences = getSharedPreferences(Strings.APP_PREFERENCES, MODE_PRIVATE);
        mPostPresenter.toWork(sourseId, postId);

    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mCommentAdapter);
    }

    private void setUpInjection(){
        CustomVkClient customVkClient = (CustomVkClient) getApplication();
        PostComponent postComponent = customVkClient.getPostComponent(this);
        postComponent.inject(this);
    }

    @Override
    public void showComments() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideComments() {
        mRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public String getToken() {
        return mSharedPreferences.getString(Strings.APP_TOKEN_NAME, "");
    }

    @Override
    public void setNewComment(String pNewComment) {
        mCommentAdapter.addNewItem(pNewComment);
    }

    @Override
    @OnClick(R.id.btnSendMessage)
    public void sendComment() {
            mPostPresenter.sendComment(sourseId, postId, getToken(), mText.getText().toString());
            mText.setText("");
    }

    @Override
    public void onError(String pError) {
        Toast.makeText(this, pError, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setContent(ResponseComment pResponse) {
        mCommentAdapter.setComments(pResponse.getContainerComment().getItemComments());
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPostPresenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPostPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPostPresenter.onDestroy();
    }
}
