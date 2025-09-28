package testUnitarios;

import exceptions.UsuarioNoEncontradoException;
import io.smallrye.common.constraint.Assert;
import models.Compañia;
import models.Direccion;
import models.Geo;
import models.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import providers.UserProvider;
import services.UserService;




public class userServiceTest {
    UserProvider provider;
    Geo geo;
    Direccion direccion;
    Compañia compañia;
    Usuario usuario;
    @BeforeEach
    public void setUp() {
        provider = Mockito.mock(UserProvider.class);
        geo = new Geo(11.46, 35.48);
        direccion = new Direccion("calle", "suite", "ciudad", "codigoPostal", geo);
        compañia = new Compañia("nombre", "catchFrase", "bussinesStrategy");
        usuario = new Usuario(1, "usuario de prueba", "usuario", "usuario@usuario", direccion, "0800-888-5465", "hipotecario.com.ar", compañia);
        Mockito.when(provider.obtenerUsuarioPorId(1)).thenReturn(usuario);
        Mockito.when(provider.obtenerUsuarioPorId(999)).thenReturn(null);
    }

    @Test
    public void test01SeCreaUnUserService(){
        UserService userService = new UserService(provider);
        Assert.assertNotNull(userService);

    }

    @Test
    public void test02SeBuscaUnUsuarioEnElProveedor(){
        UserService userService = new UserService(provider);

        Usuario usuarioDelServicio = userService.obtenerUsuarioPorId(1);

        Assertions.assertEquals(usuarioDelServicio, usuario);
    }
    @Test
    public void test03SeBuscaUnUsuarioInexistente(){
        UserService userService = new UserService(provider);

        Assertions.assertThrows(
                UsuarioNoEncontradoException.class,
                () -> userService.obtenerUsuarioPorId(999)
        );
    }
}
