package providers;


import builders.PostBuilder;
import builders.UsuarioBuilder;
import dto.PostDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import models.Post;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class JsonPlaceholderPostProvider implements PostProvider {
    @Inject
    @RestClient
    JsonPlaceHolderPostClient jsonPlaceHolderPostClient;


    @Override
    public Post obtenerPostPorId(int idPost) {
        PostDto dto = jsonPlaceHolderPostClient.getPost(idPost);
        return PostBuilder.construirPost(dto);
    }

    @Override
    public List<Post> obtenerTodosLosPost() {
        List<PostDto>  dtos = jsonPlaceHolderPostClient.getPosts();
        return dtos.stream().map(PostBuilder::construirPost).collect(Collectors.toList());
    }

    @Override
    public void borrarPostPorId(long idPost) {
        Response response = jsonPlaceHolderPostClient.deletePost(idPost);
        response.close();
    }

}
