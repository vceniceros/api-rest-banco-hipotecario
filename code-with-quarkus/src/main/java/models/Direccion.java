package models;

public class Direccion {
    private String calle;
    private String suite;
    private String ciudad;
    private String codPostal;
    private Geo geo;

    public Direccion(String calle, String suite, String ciudad, String codigoPostal, Geo geo) {
            this.calle = calle;
            this.suite = suite;
            this.ciudad = ciudad;
            this.codPostal = codigoPostal;
            this.geo = geo;
    }

    public Double obtenerLatitud() {
        return this.geo.getLatitud(); //rompe ley de demeter
    }

    public Double obtenerLogitud() {
        return this.geo.getLogitud(); //mismo aca
    }
}
