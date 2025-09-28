package resources


import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response;
import models.Usuario;
import services.UserService



@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UserService userService;

    @GET
    @Path("/{id}")
    public Response obtenerUsuarioPorId(@PathParam("id") int id) {
        Usuario usuario = userService.obtenerUsuarioPorId(id);
        return Response.ok(usuario).build();
    }
}
