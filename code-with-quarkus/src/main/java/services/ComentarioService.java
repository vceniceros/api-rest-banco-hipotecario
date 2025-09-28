package services;

import exceptions.ComentarioNoEncontradoException;
import models.Comentario;
import providers.ComentarioProvider;

public class ComentarioService {
    private ComentarioProvider comentarioProvider;

    public ComentarioService(ComentarioProvider comentarioProvider) {
        this.comentarioProvider = comentarioProvider;
    }

    public Comentario obtenerComentarioPorId(int idComentario) {
        Comentario comentario = comentarioProvider.obtenerComentarioPorId(idComentario);
        if (comentario == null) {
            throw new ComentarioNoEncontradoException();
        }
        return comentario;
    }
}