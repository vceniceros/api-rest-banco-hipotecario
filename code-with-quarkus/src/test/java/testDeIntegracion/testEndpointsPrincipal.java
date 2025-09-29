package testDeIntegracion;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class testEndpointsPrincipal {

    @Test
    public void test01SeobtienenTodosLosPostConUsuarioYComentariosMegeados(){
        given()
                .when().get("/posts")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$", is(not(empty())))
                .body("[0].id", is(1))
                .body("[0].title", not(emptyOrNullString()));
    }
    @Test
    public void test02SeObtieneUnPostCompletoConUsuarioYComentarios() {
        given()
                .when().get("/posts/1")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)

                .body("id", is(1))
                .body("title", not(emptyOrNullString()))
                .body("body", not(emptyOrNullString()))


                .body("autor", is(notNullValue()))
                .body("autor.id", is(1))
                .body("autor.name", is("Leanne Graham"))


                .body("comentarios", is(not(empty())))
                .body("comentarios.size()", is(5))
                .body("comentarios[0].email", is("Eliseo@gardner.biz"));
    }
    @Test
    public void test03AlSolicitarIdInexistenteRetorna404() {


        given()
                .when().get("/posts/9999")
                .then()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .body(is(not(emptyOrNullString())));
    }

    @Test
    public void test04SeBorraUnPostYSeEsperaUnStatus200() {
        Long postIdToDelete = 1L;

        given()
                .when()
                .delete("/posts/{id}", postIdToDelete)
                .then()
                .statusCode(200);
    }
}
