package providers;

import dto.UsuarioDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;



@Path("/users")
@RegisterRestClient(configKey = "jsonplaceholder-api")
@Produces(MediaType.APPLICATION_JSON)
public interface JsonPlaceholderUserClient {

    @GET
    @Path("/{id}")
    UsuarioDTO obtenerUsuarioPorId(@PathParam("id") int idUsuario);
}