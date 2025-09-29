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

public class postServiceTest{
    PostProvider postProvider;
    Post postPrueba;



    @BeforeEach
    public void setUp(){
       postProvider = Mockito.mock(PostProvider.class);
        postPrueba = new Post(1,1,"post de prueba", "loren ipsum");
        Mockito.when(postProvider.obtenerPostPorId(1)).thenReturn(postPrueba);
        Mockito.when(postProvider.obtenerPostPorId(999)).thenReturn(null);
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
}
