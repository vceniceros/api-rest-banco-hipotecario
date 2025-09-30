package providers;

import dto.PostDto;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/posts")
@RegisterRestClient(configKey = "jsonplaceholder")
public interface JsonPlaceHolderPostClient {
    @GET
    @Path("/{id}")
    PostDto getPost(@PathParam("id") int id);

    @GET
    @Path("/")
    List<PostDto> getPosts();

    @DELETE
    @Path("/{id}")
    Response deletePost(@PathParam("id") Long id);
}
