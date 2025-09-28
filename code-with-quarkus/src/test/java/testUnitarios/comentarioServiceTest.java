package testUnitarios;

import exceptions.ComentarioNoEncontradoException;
import models.Comentario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import providers.ComentarioProvider;
import services.ComentarioService;

public class comentarioServiceTest {
    ComentarioProvider comentarioProvider;
    Comentario comentarioPrueba;

    @BeforeEach
    public void setUp() {
        comentarioProvider = Mockito.mock(ComentarioProvider.class);
        comentarioPrueba = new Comentario(1, 1, "Valen", "valen@mail.com", "Muy buen post!");

        Mockito.when(comentarioProvider.obtenerComentarioPorId(1)).thenReturn(comentarioPrueba);
        Mockito.when(comentarioProvider.obtenerComentarioPorId(999)).thenReturn(null);
    }

    @Test
    public void test01SeBuscaUnComentarioExistente() {
        ComentarioService comentarioService = new ComentarioService(comentarioProvider);
        Comentario comentario = comentarioService.obtenerComentarioPorId(1);
        Assertions.assertEquals(comentarioPrueba, comentario);
    }

    @Test
    public void test02SeBuscaUnComentarioInexistente() {
        ComentarioService comentarioService = new ComentarioService(comentarioProvider);

        Assertions.assertThrows(
                ComentarioNoEncontradoException.class,
                () -> comentarioService.obtenerComentarioPorId(999)
        );
    }
}