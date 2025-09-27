package models;

public class Comentario {
    private int idPost;
    private int idComentario;
    private String nombre;
    private String email;
    private String cuerpo;
    public Comentario(int idPost, int idComentario, String nombre, String email, String cuerpo) {
            this.idPost = idPost;
            this.idComentario = idComentario;
            this.nombre = nombre;
            this.email = email;
            this.cuerpo = cuerpo;
    }
}
