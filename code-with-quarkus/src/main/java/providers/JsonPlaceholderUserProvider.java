package providers;

import builders.UsuarioBuilder;
import dto.UsuarioDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import models.Usuario;

@ApplicationScoped
public class JsonPlaceholderUserProvider implements UserProvider {

    @Inject
    @RestClient
    JsonPlaceholderUserClient client;

    @Override
    public Usuario obtenerUsuarioPorId(int idUsuario) {
        UsuarioDTO dto = client.getUsuario(idUsuario);
        return UsuarioBuilder.construirUsuario(dto);
    }
}
