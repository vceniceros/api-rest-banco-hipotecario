package testIntegracion;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class UsuarioResourcesTest {

    @Test
    public void testBuscarUsuarioPorId() {
        given()
                .when().get("/usuarios/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", notNullValue())
                .body("email", notNullValue());
    }
}
