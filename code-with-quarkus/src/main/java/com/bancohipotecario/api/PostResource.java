package com.bancohipotecario.api;

import dto.PostDto;
import dto.PostDetalleDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import models.Comentario;
import models.Post;
import models.Usuario;
import services.ComentarioService;
import services.PostService;
import services.UserService;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

import static io.quarkus.arc.ComponentsProvider.LOG;

@ApplicationScoped
@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {
    @Inject
    PostService postService;

    @Inject
    ComentarioService comentarioService;

    @Inject
    UserService userService;

    @GET
    public List<PostDto> obtenerPostCompletos(){
        List<Post> posts = postService.obtenerTodosLosPost();

        return posts.stream().map(
                post ->{
                    PostDto dto = new PostDto();
                    dto.setUserId(post.getUserId());
                    dto.setId(post.getId());
                    dto.setTitle(post.getTitle());
                    dto.setBody(post.getBody());
                    return dto;
                }).collect(Collectors.toList());
    }
    @GET
    @Path("/{id}")
    public PostDetalleDTO obtenerPostPorId(@PathParam("id") int id) {
        try {
            Post post = postService.obtenerPostPorId(id);
        }catch (Exception e){
            throw new WebApplicationException(
                    Response
                            .status(Response.Status.NOT_FOUND)
                            .entity("Recurso no encontrado: El Post solicitado no existe.")
                            .build());
        }
        Post post = postService.obtenerPostPorId(id);
        Usuario usuario = userService.obtenerUsuarioPorId(post.getUserId());
        List<Comentario> comentarios = comentarioService.obtenerComentariosDePostPorId(id);


        PostDetalleDTO dto = new PostDetalleDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());

        dto.setAutor(usuario.generararDto());

        dto.setComentarios(comentarios.stream().map(Comentario::generarDto).collect(Collectors.toList()));

        return dto;
    }

    @DELETE
    @Path("/{id}")
    public Response deletePost(@PathParam("id") Long id) {
        LOG.infof("Recibida solicitud DELETE para el post con ID: %d", id);
        postService.deletePost(id);
        return Response.ok().build();
    }
}