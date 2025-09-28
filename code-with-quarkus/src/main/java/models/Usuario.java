package models;

public class Usuario {
    private int id;
    private String nombre;
    private String username;
    private String email;
    private Direccion direccion;
    private String telefono;
    private String website;
    private Compañia compañia;


    public Usuario(int id, String nombre, String username, String email, Direccion direccion, String telefono, String website, Compañia compañia) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.website = website;
        this.compañia = compañia;
    }

    public boolean compararDireccion(Direccion direccion) {
        return this.direccion.equals(direccion);
    }

    public boolean perteneceACompañia(Compañia compañia) {
        return this.compañia.equals(compañia);
    }

    public boolean comparteIdCon(int idUsuario) {
        return this.id == idUsuario;
    }

    public boolean esElMismoUsuario(Usuario usuario) {
        return this.id == usuario.id;
    }
}
