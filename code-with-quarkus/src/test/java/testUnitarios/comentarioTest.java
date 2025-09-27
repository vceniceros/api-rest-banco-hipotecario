package testUnitarios;

import io.smallrye.common.constraint.Assert;
import models.Comentario;
import org.junit.jupiter.api.Test;

public class comentarioTest {
    @Test
    public void test01SeCrearUnComentario(){
        Comentario comentario = new Comentario(1, 1, "comentario de prueba", "email@email", "lorem ipsum");
        Assert.assertNotNull(comentario);
    }
}
