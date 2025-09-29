package services;

import exceptions.PostNoEncontradoException;
import models.Post;
import providers.PostProvider;
import providers.UserProvider;

public class PostService {
    private PostProvider postProvider;


    public PostService(PostProvider postProvider ){
        this.postProvider = postProvider;
    }

    public Post obtenerPostPorId(int idPost) {
        if (postProvider.obtenerPostPorId(idPost) == null) {
            throw new PostNoEncontradoException();
        } else {
            return postProvider.obtenerPostPorId(idPost);
        }
    }
}
