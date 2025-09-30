package testUnitarios;

import exceptions.PostNoEncontradoException;
import exceptions.UsuarioNoEncontradoException;
import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import providers.PostProvider;
import providers.UserProvider;
import services.PostService;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

public class postServiceTest{
    PostProvider postProvider;
    Post postPrueba;
    Post postPrueba1;
    Post postPrueba2;
    Post postPrueba3;

    List<Post> listaDePrueba;

    @BeforeEach
    public void setUp(){
       postProvider = Mockito.mock(PostProvider.class);
        postPrueba = new Post(1,1,"post de prueba", "loren ipsum");
        postPrueba1 = new Post(1,0,"post de prueba", "loren ipsum");
        postPrueba2 = new Post(1,1,"post de prueba", "loren ipsum");
        postPrueba3 = new Post(1,2,"post de prueba", "loren ipsum");
        listaDePrueba = new ArrayList<>();

        listaDePrueba.add(postPrueba1);
        listaDePrueba.add(postPrueba2);
        listaDePrueba.add(postPrueba3);

        Mockito.when(postProvider.obtenerPostPorId(1)).thenReturn(postPrueba);
        Mockito.when(postProvider.obtenerPostPorId(999)).thenReturn(null);
        Mockito.when(postProvider.obtenerTodosLosPost()).thenReturn(listaDePrueba);
    }

    @Test
    public void test01SeBuscaUnPostExistente(){
        PostService postService = new PostService(postProvider);
        Post post = postService.obtenerPostPorId(1);
        Assertions.assertEquals(postPrueba, post);
    }

    @Test
    public void test02SeBuscaUnPostQueNoExiste(){
        PostService postService = new PostService(postProvider);

        Assertions.assertThrows(
                PostNoEncontradoException.class,
                () -> postService.obtenerPostPorId(999)
        );
    }

    @Test
    public void test03SeBuscanTodosLosPost(){
        PostService postService = new PostService(postProvider);

        List<Post> posts = postService.obtenerTodosLosPost();

        Assertions.assertEquals(listaDePrueba, posts);
    }
}
