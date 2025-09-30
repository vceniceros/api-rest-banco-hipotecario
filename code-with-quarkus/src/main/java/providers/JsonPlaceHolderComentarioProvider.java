package providers;

import builders.ComentarioBuilder;
import dto.ComentarioDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import models.Comentario;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class JsonPlaceHolderComentarioProvider implements ComentarioProvider {
    @Inject
    @RestClient
    JsonPlaceHolderComentarioClient jsonPlaceHolderComentarioClient;

    @Override
    public List<Comentario> obtenerComentariosDePost(int postId) {
        List<ComentarioDTO> dtos = jsonPlaceHolderComentarioClient.getComentariosPorPostId(postId);
        return dtos.stream()
                .map(ComentarioBuilder::construirComentario)
                .collect(Collectors.toList());
    }


}
