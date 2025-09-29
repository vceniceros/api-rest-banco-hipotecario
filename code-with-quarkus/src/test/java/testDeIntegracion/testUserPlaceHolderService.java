package testDeIntegracion;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import models.Direccion;
import models.Geo;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import providers.JsonPlaceholderUserProvider;
import providers.UserProvider;
import services.UserService;
import models.Usuario;

@QuarkusTest
public class testUserPlaceHolderService {

    @Inject
    JsonPlaceholderUserProvider jsonPlaceholderUserProvider;

    @Test
    public void test01SeBuscaUnUsuarioRealEnJsonPlaceholder() {
        UserService userService = new UserService(jsonPlaceholderUserProvider);

        Usuario usuario = userService.obtenerUsuarioPorId(1);

        Assertions.assertNotNull(usuario);
        Assertions.assertTrue(usuario.comparteIdCon(1));
    }
    @Test
    public void test02SeBuscaUnUsuarioRealEnJsonPlaceholderYSeVerificaSuDireccion() {
        UserService userService = new UserService(jsonPlaceholderUserProvider);
        Geo geoPrueba = new Geo(-37.3159, 81.1496);
        Direccion direccionPrueba = new Direccion("Kulas Light", "Apt. 556", "Gwenborough", "92998-387", geoPrueba);

        Usuario usuario = userService.obtenerUsuarioPorId(1);

        Assertions.assertNotNull(usuario);
        Assertions.assertTrue(usuario.viveEn(direccionPrueba));
    }
}
