package services;

import models.Post;
import providers.PostProvider;
import providers.UserProvider;

public class PostService {
    private PostProvider postProvider;


    public PostService(PostProvider postProvider ){
        this.postProvider = postProvider;
    }

    public Post obtenerPostPorId(int idPost) {
        return postProvider.obtenerPostPorId(idPost);
    }
}
