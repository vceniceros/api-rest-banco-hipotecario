package models;

import dto.CompañiaDTO;

public class Compañia {

    private String nombre;
    private String catchFrase;
    private String bussinesStrategy;

    public Compañia(String nombre, String catchFrase, String bussinesStrategy) {
        this.nombre = nombre;
        this.catchFrase = catchFrase;
        this.bussinesStrategy = bussinesStrategy;
    }

    public CompañiaDTO generarDTO() {
        CompañiaDTO compañiaDTO = new CompañiaDTO();
        compañiaDTO.setName(this.nombre);
        compañiaDTO.setBs(this.bussinesStrategy);
        compañiaDTO.setCatchPhrase(this.catchFrase);
        return compañiaDTO;
    }
}
