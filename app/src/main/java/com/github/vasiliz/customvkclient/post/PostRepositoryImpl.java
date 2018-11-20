package com.github.vasiliz.customvkclient.post;

import com.github.vasiliz.customvkclient.api.CommentsClient;
import com.github.vasiliz.customvkclient.entities.comments.ResponseComment;
import com.github.vasiliz.customvkclient.entities.comments.sendComment.ResponseSendComment;
import com.github.vasiliz.customvkclient.lib.base.EventBus;
import com.github.vasiliz.customvkclient.post.events.PostEvent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepositoryImpl implements PostRepository {

    private EventBus mEventBus;
    private CommentsClient mCommentsClient;
    private static final String VERSION = "5.69";

    public PostRepositoryImpl(EventBus pEventBus, CommentsClient pCommentsClient) {
        mEventBus = pEventBus;
        mCommentsClient = pCommentsClient;
    }

    @Override
    public void getComments(int pSourceId, int pPostId, String pToken) {
        mCommentsClient.getNews.getPostComments(pSourceId, pPostId, pToken, VERSION).enqueue(new Callback<ResponseComment>() {

            @Override
            public void onResponse(Call<ResponseComment> call, Response<ResponseComment> response) {
                post(response.body());
            }

            @Override
            public void onFailure(Call<ResponseComment> call, Throwable t) {
                post(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void sendComment(int pSourceId, int pPostId, String pToken, final String pMessage) {

        final String comment = pMessage;
        mCommentsClient.getNews.createComment(pSourceId, pPostId, pMessage, pToken, VERSION).enqueue(new Callback<ResponseSendComment>() {

            @Override
            public void onResponse(Call<ResponseSendComment> call, Response<ResponseSendComment> response) {
                response.body().getResponseAddComment();
                post(pMessage, response.body().getResponseAddComment().getLong());
            }

            @Override
            public void onFailure(Call<ResponseSendComment> call, Throwable t) {

            }
        });
    }

    private void post(String pError) {
        post(null, pError, null, 0);
    }

    private void post(ResponseComment pNews) {
        post(pNews, null, null, 0);
    }

    private void post(String pComment, long pComentId){
        post(null, null, pComment,pComentId);
    }

    private void post(ResponseComment pItems, String pError, String comment, long pCommentId) {
        PostEvent postEvent = new PostEvent();
        postEvent.setpError(pError);
        postEvent.setResponseComment(pItems);
        postEvent.setNewComment(comment);
        postEvent.setIdComment(pCommentId);
        mEventBus.post(postEvent);
    }
}
