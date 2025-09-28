package testUnitarios;

import io.smallrye.common.constraint.Assert;
import models.Comentario;
import models.Post;
import org.junit.jupiter.api.Test;

public class comentarioTest {
    @Test
    public void test01SeCrearUnComentario(){
        Comentario comentario = new Comentario(1, 1, "comentario de prueba", "email@email", "lorem ipsum");
        Assert.assertNotNull(comentario);
    }

    @Test
    public void test02SeVerificaQueUnComentarioPerteneceAUnPost(){


        Post post = new Post(1, 1, "post de prueba", "post de prueba");
        Comentario comentario = new Comentario(1, 1, "comentario de prueba", "email@email", "lorem ipsum");

        Assert.assertTrue(comentario.perteneceAUnPost(post));
    }
}
