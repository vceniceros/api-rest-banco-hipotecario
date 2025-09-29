package testUnitarios;

import io.smallrye.common.constraint.Assert;
import models.*;
import org.junit.jupiter.api.Test;

public class postTest {
    @Test
    public void test01SeCreaUnPost(){
        Post post = new Post(1, 1, "post de prueba", "post de prueba");
        Assert.assertNotNull(post);
    }

    @Test
    public void test02SeVerificaQueUnUsuarioCreoUnPost(){
        Geo geo = new Geo(1, 1);
        Direccion direccion =  new Direccion("calle", "suite", "ciudad", "codigoPostal", geo);
        Compañia compañia = new Compañia("nombre", "catchFrase", "bussinesStrategy");
        Usuario usuario = new Usuario(1,"usuario de prueba", "usuario", "usuario@usuario", direccion, "0800-888-5465", "hipotecario.com.ar", compañia);
        Post post = new Post(1, 1, "post de prueba", "post de prueba");

        Assert.assertTrue(post.fuePublicadoPor(usuario));
    }
}
