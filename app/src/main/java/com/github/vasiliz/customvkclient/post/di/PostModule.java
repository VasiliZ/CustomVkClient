package com.github.vasiliz.customvkclient.post.di;

import com.github.vasiliz.customvkclient.api.CommentsClient;
import com.github.vasiliz.customvkclient.entities.comments.ItemComment;
import com.github.vasiliz.customvkclient.lib.base.EventBus;
import com.github.vasiliz.customvkclient.post.PostInteractor;
import com.github.vasiliz.customvkclient.post.PostInteractorImpl;
import com.github.vasiliz.customvkclient.post.PostPresenter;
import com.github.vasiliz.customvkclient.post.PostPresenterImpl;
import com.github.vasiliz.customvkclient.post.PostRepository;
import com.github.vasiliz.customvkclient.post.PostRepositoryImpl;
import com.github.vasiliz.customvkclient.post.adapters.CommentAdapter;
import com.github.vasiliz.customvkclient.post.ui.PostView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PostModule {

    PostView mPostView;

    public PostModule(PostView pPostView) {
        mPostView = pPostView;
    }

    @Provides
    @Singleton
    PostView providesPostView() {
        return mPostView;
    }

    @Singleton
    @Provides
    PostPresenter providesPostPresenter(PostInteractor pPostInteractor, EventBus pEventBus, PostView pPostView) {
        return new PostPresenterImpl(pPostInteractor, pPostView, pEventBus);
    }

    @Singleton
    @Provides
    PostInteractor providesPostIntersctor(PostRepository pPostRepository) {
        return new PostInteractorImpl(pPostRepository);
    }

    @Provides
    @Singleton
    PostRepository providesPostRepository(EventBus pEventBus, CommentsClient pCommentsClient){
        return new PostRepositoryImpl(pEventBus, pCommentsClient);
    }

    @Provides
    @Singleton
    CommentsClient providesCommentsClient(){
        return new CommentsClient();
    }

    @Singleton
    @Provides
    CommentAdapter providesCommentAdapter(List<ItemComment> pItemComments){
        return new CommentAdapter(pItemComments);
    }

    @Provides
    @Singleton
    List<ItemComment> providesListComents(){
        return new ArrayList<>();
    }
}
