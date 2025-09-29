package services;

import exceptions.PostNoEncontradoException;
import jakarta.enterprise.context.ApplicationScoped;
import models.Post;
import providers.PostProvider;
import providers.UserProvider;

import java.util.List;
@ApplicationScoped
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

    public List<Post> obtenerTodosLosPost() {
        return postProvider.obtenerTodosLosPost();
    }

    public void deletePost(Long id) {
        this.postProvider.borrarPostPorId(id);
    }
}
