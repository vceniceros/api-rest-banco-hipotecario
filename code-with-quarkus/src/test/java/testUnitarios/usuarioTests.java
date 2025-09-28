package testUnitarios;
import models.Compañia;
import models.Direccion;
import models.Geo;
import models.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

public class usuarioTests {
    Geo geo;
    Direccion direccion;
    Compañia compañia;

    @BeforeEach
    public void setUp(){
         geo = new Geo(11.46, 35.48);
         direccion = new Direccion("calle", "suite", "ciudad", "codigoPostal", geo);
         compañia =  new Compañia("nombre", "catchFrase", "bussinesStrategy");
    }

    @Test
    public void test01SeCreaUnUsuario(){
        Usuario usuario;
        usuario = new Usuario(1,"usuario de prueba", "usuario", "usuario@usuario", direccion, "0800-888-5465", "hipotecario.com.ar", compañia);
        Assert.assertNotNull(usuario);
    }

    @Test
    public void test02CreaUnUsuarioConUnaDireccion(){
        Usuario usuario;
        usuario = new Usuario(1,"usuario de prueba", "usuario", "usuario@usuario", direccion, "0800-888-5465", "hipotecario.com.ar", compañia);
        Assert.assertTrue(usuario.compararDireccion(direccion));
    }

    @Test
    public void test03CreaUnUsuarioYSeVerificaQuePertenezcaAUnaCompañia(){
        Usuario usuario;
        usuario = new Usuario(1,"usuario de prueba", "usuario", "usuario@usuario", direccion, "0800-888-5465", "hipotecario.com.ar", compañia);

        Assert.assertTrue(usuario.perteneceACompañia(compañia));

    }


}
