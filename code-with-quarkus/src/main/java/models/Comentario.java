package models;

import dto.ComentarioDTO;

public class Comentario {
    private int idPost;
    private int idComentario;
    private String nombre;
    private String email;
    private String cuerpo;

    public Comentario() {}

    public Comentario(int idPost, int idComentario, String nombre, String email, String cuerpo) {
            this.idPost = idPost;
            this.idComentario = idComentario;
            this.nombre = nombre;
            this.email = email;
            this.cuerpo = cuerpo;
    }

    public boolean perteneceAUnPost(Post post) {
        return post.comparteIdCon(idPost);
    }

    public ComentarioDTO generarDto(){
        ComentarioDTO dto = new ComentarioDTO();
        dto.setId(this.idComentario);
        dto.setPost_id(this.idPost);
        dto.setName(this.nombre);
        dto.setEmail(this.email);
        dto.setBody(this.cuerpo);
        return dto;
    }
}
