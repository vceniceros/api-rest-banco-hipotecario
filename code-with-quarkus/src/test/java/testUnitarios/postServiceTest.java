package testUnitarios;

import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import providers.PostProvider;
import providers.UserProvider;
import services.PostService;
import services.UserService;

public class postServiceTest{
    PostProvider postProvider;
    UserProvider userProvider;
    Post postPrueba;



    @BeforeEach
    public void setUp(){
       postProvider = Mockito.mock(PostProvider.class);
        postPrueba = new Post(1,1,"post de prueba", "loren ipsum");
    }

    @Test
    public void test01SeBuscaUnPostExistente(){
        PostService postService = new PostService(postProvider, userProvider);
        Post post = postService.obtenerPostPorId(1);
        Assertions.assertEquals(postPrueba, post);
    }
}
