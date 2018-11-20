package com.github.vasiliz.customvkclient.api;

import com.github.vasiliz.customvkclient.entities.comments.ResponseComment;
import com.github.vasiliz.customvkclient.entities.comments.sendComment.ResponseSendComment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CommentService {

    @GET("method/wall.getComments")
    Call<ResponseComment> getPostComments(@Query("owner_id") int pOwnerId,
                                          @Query("post_id") int pPostId,
                                          @Query("access_token") String pAccessToken,
                                          @Query("v") String pVersionApi);

    @GET("method/wall.createComment")
    Call<ResponseSendComment> createComment(@Query("owner_id") int pOwnerId,
                                            @Query("post_id") int pPostId,
                                            @Query("message") String pMessage,
                                            @Query("access_token") String pAccessToken,
                                            @Query("v") String pVersionApi);

}
