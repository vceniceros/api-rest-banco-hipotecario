package providers;

import builders.UsuarioBuilder;
import dto.UsuarioDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import models.Usuario;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@ApplicationScoped
public class JsonPlaceholderUserProvider implements UserProvider {

    @Inject
    @RestClient
    JsonPlaceholderUserClient client;

    @Override
    public Usuario obtenerUsuarioPorId(int idUsuario) {
        UsuarioDTO dto = client.obtenerUsuarioPorId(idUsuario);
        return dto == null ? null : UsuarioBuilder.construirUsuario(dto);
    }
}