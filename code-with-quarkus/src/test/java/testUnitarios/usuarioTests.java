package testUnitarios;
import io.quarkus.test.junit.QuarkusTest;
import models.Usuario;
import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

public class usuarioTests {


    @Test
    public void test01SeCreaUnUsuario(){
        Usuario usuario;
        usuario = new Usuario(1,"usuario de prueba", "usuario", "usuario@usuario");
        Assert.assertNotNull(usuario);
    }


}
