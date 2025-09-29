package models;

import dto.DireccionDTO;

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

    public Boolean sonLaMismaDireccion(Direccion direccion) {
        return direccion.geo.getLatitud().equals(this.geo.getLatitud()) && this.geo.getLogitud().equals(direccion.geo.getLogitud());// esto anida condicionales y rompe encapsulamiento
    }

    public DireccionDTO generarDTO() {
        DireccionDTO dto = new DireccionDTO();
        dto.setStreet(this.calle);
        dto.setCity(this.ciudad);
        dto.setSuite(this.suite);
        dto.setGeo(this.geo.generarDTO());
        dto.setZipcode(this.codPostal);
        return dto;
    }
}
