package testDeIntegracion;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import models.Comentario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import providers.JsonPlaceHolderComentarioProvider;
import services.ComentarioService;

import java.util.List;

@QuarkusTest
public class testComentarioPlaceHolderService {
    @Inject
    JsonPlaceHolderComentarioProvider jsonPlaceHolderComentarioProvider;


    @Test
    public void test01SeBuscanLosComentariosDeUnPostReal() {
        ComentarioService comentarioService = new ComentarioService(jsonPlaceHolderComentarioProvider);

        List<Comentario> comentarios = comentarioService.obtenerComentariosDePostPorId(1);

        Assertions.assertNotNull(comentarios);
        Assertions.assertEquals(5, comentarios.size());
    }

}
