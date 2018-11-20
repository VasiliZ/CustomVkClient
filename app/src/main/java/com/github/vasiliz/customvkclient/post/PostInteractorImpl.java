package com.github.vasiliz.customvkclient.post;

public class PostInteractorImpl implements PostInteractor {
    private PostRepository mPostRepository;

    public PostInteractorImpl(PostRepository pPostRepository) {
        mPostRepository = pPostRepository;
    }

    @Override
    public void execute(int pSourceId, int pPostId, String pToken) {
        mPostRepository.getComments(pSourceId, pPostId, pToken);
    }

    @Override
    public void sendComment(int pSourceId, int pPostId, String pToken, String pMessage) {
        mPostRepository.sendComment(pSourceId, pPostId, pToken, pMessage);
    }
}
