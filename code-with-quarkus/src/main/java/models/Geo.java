package models;

public class Geo {
    private double latitud;
    private double longitud;
    public Geo(double latitud, double longitud) {
            this.latitud = latitud;
            this.longitud = longitud;
    }

    public Double getLatitud() {
        return this.latitud;
    }

    public Double getLogitud() {
        return this.longitud;
    }
}
