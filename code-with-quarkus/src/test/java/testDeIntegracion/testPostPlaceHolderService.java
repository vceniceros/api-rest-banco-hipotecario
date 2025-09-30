package testDeIntegracion;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import models.Post;
import models.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import providers.JsonPlaceholderPostProvider;
import providers.JsonPlaceholderUserProvider;
import services.PostService;
import services.UserService;

import java.util.List;

@QuarkusTest
public class testPostPlaceHolderService {

    @Inject
    JsonPlaceholderPostProvider jsonPlaceholderPostProvider;


    @Test
    public void test01SeBuscaUnPostRealEnJsonPlaceholder() {
        PostService postService = new PostService(jsonPlaceholderPostProvider);
        Post post = postService.obtenerPostPorId(1);

        Assertions.assertNotNull(post);
        Assertions.assertTrue(post.comparteIdCon(1));
    }

    @Test
    public void test02SeBuscaTodosLosPostEnJsonPlaceHolder(){
        PostService postService = new PostService(jsonPlaceholderPostProvider);
        List<Post> posts = postService.obtenerTodosLosPost();

        Assertions.assertNotNull(posts);
        Assertions.assertEquals(100, posts.size());
    }

}
