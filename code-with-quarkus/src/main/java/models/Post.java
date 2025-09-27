package models;

public class Post {
    private int idUsuario;
    private int idPost;
    private String titulo;
    private String cuerpo;

    public Post(int idUsuario, int idPost, String titulo, String cuerpo) {
            this.idUsuario = idUsuario;
            this.idPost = idPost;
            this.titulo = titulo;
            this.cuerpo = cuerpo;
    }
}
