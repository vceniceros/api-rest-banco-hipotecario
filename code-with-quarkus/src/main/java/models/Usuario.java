package models;

public class Usuario {
    private int id;
    private String nombre;
    private String username;
    private String email;

    public Usuario(int id, String nombre, String username, String email) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
    }
}
