package services;

import exceptions.PostSinComentariosException;
import jakarta.enterprise.context.ApplicationScoped;
import models.Comentario;
import providers.ComentarioProvider;

import java.util.List;

@ApplicationScoped
public class ComentarioService {
    private ComentarioProvider comentarioProvider;

    public ComentarioService(ComentarioProvider comentarioProvider) {
        this.comentarioProvider = comentarioProvider;
    }

    public List<Comentario> obtenerComentariosDePostPorId(int idPost) {
        List<Comentario> comentarios = comentarioProvider.obtenerComentariosDePost(idPost);
        if (comentarios.isEmpty()) {
            throw new PostSinComentariosException();
        }
        return comentarios;
    }
}