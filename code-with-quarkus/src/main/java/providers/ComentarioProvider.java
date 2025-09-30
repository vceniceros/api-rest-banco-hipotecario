package providers;

import models.Comentario;

import java.util.List;

public interface ComentarioProvider {
    List<Comentario> obtenerComentariosDePost(int postId);
}