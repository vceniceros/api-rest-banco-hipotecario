package providers;

import dto.ComentarioDTO;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/posts")
@RegisterRestClient(configKey = "jsonplaceholder")
public interface JsonPlaceHolderComentarioClient {

    @GET
    @Path("/{postId}/comments")
    List<ComentarioDTO> getComentariosPorPostId(@PathParam("postId") int postId);
}