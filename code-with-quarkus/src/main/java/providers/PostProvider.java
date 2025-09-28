package providers;

import models.Post;

public interface PostProvider {
    Post obtenerPostPorId(int idPost);
}
