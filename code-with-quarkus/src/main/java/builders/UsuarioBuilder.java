package builders;

import dto.UsuarioDTO;
import models.Compañia;
import models.Direccion;
import models.Geo;
import models.Usuario;

public class UsuarioBuilder {
    public static Usuario construirUsuario(UsuarioDTO dto){
        Geo geo = new Geo(
                Double.parseDouble(dto.address.geo.lat),
                Double.parseDouble(dto.address.geo.lng)
        );
        Direccion direccion = new Direccion(
                dto.address.street,
                dto.address.suite,
                dto.address.city,
                dto.address.zipcode,
                geo
                );
        Compañia compañia = new Compañia(
                dto.company.name,
                dto.company.catchPhrase,
                dto.company.bs);

        return new Usuario(dto.id, dto.name, dto.username, dto.email, direccion, dto.phone, dto.website, compañia);
    }
}
