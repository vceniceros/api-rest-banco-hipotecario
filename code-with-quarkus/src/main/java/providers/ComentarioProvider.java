package providers;

import models.Comentario;

public interface ComentarioProvider {
    Comentario obtenerComentarioPorId(int idComentario);
}