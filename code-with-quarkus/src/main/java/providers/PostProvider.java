package providers;

import models.Post;

import java.util.List;

public interface PostProvider {
    Post obtenerPostPorId(int idPost);

    List<Post> obtenerTodosLosPost();

    void borrarPostPorId(long idPost);
}
