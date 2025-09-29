package builders;

import dto.UsuarioDTO;
import models.Compañia;
import models.Direccion;
import models.Geo;
import models.Usuario;

public class UsuarioBuilder {
    public static Usuario construirUsuario(UsuarioDTO dto){
        Geo geo = new Geo(
                Double.parseDouble(dto.direccion.geo.lat),
                Double.parseDouble(dto.direccion.geo.lon)
        );
        Direccion direccion = new Direccion(
                dto.direccion.calle,
                dto.direccion.suite,
                dto.direccion.ciudad,
                dto.direccion.codPostal,
                geo
                );
        Compañia compañia = new Compañia(
                dto.compañia.nombre,
                dto.compañia.catchPhrase,
                dto.compañia.bs);

        return new Usuario(dto.id, dto.nombre, dto.usuario, dto.email, direccion, dto.telefono, dto.website, compañia);
    }
}
