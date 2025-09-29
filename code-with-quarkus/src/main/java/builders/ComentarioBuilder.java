package builders;

import dto.ComentarioDTO;
import models.Comentario;

public class ComentarioBuilder {
    public static Comentario construirComentario(ComentarioDTO comentarioDTO) {
        return new Comentario(comentarioDTO.post_id, comentarioDTO.id, comentarioDTO.name, comentarioDTO.email,  comentarioDTO.body);
    }
}
