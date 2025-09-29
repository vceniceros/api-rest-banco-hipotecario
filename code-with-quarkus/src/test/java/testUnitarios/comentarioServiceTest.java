package testUnitarios;

import exceptions.PostSinComentariosException;
import models.Comentario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import providers.ComentarioProvider;
import services.ComentarioService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class comentarioServiceTest {
    ComentarioProvider comentarioProvider;
    Comentario comentarioPrueba1;
    Comentario comentarioPrueba2;
    Comentario comentarioPrueba3;
    List<Comentario> comentariosDePrueba;
    List<Comentario> listaVacia;
    @BeforeEach
    public void setUp() {
        comentarioProvider = Mockito.mock(ComentarioProvider.class);

        comentarioPrueba1 = new Comentario(1, 1, "Valen", "valen@mail.com", "Muy buen post!");
        comentarioPrueba2 = new Comentario(1, 2, "Valen", "valen@mail.com", "Malisimo!");
        comentarioPrueba3 = new Comentario(1, 3, "Valen", "valen@mail.com", "probando ando!");
        comentariosDePrueba = new ArrayList<>();
        comentariosDePrueba.add(comentarioPrueba1);
        comentariosDePrueba.add(comentarioPrueba2);
        comentariosDePrueba.add(comentarioPrueba3);

        listaVacia = Collections.emptyList();

        Mockito.when(comentarioProvider.obtenerComentariosDePost(1)).thenReturn(comentariosDePrueba);
        Mockito.when(comentarioProvider.obtenerComentariosDePost(999)).thenReturn(listaVacia);


    }

    @Test
    public void test01SeBuscaUnComentarioExistente() {
        ComentarioService comentarioService = new ComentarioService(comentarioProvider);

        List<Comentario> comentarios = comentarioService.obtenerComentariosDePostPorId(1);
        Assertions.assertFalse(comentarios.isEmpty(), "La lista de comentarios no debería estar vacía.");
        Assertions.assertEquals(3, comentarios.size(), "Debería haber 2 comentarios.");
        Assertions.assertEquals(comentariosDePrueba, comentarios, "La lista debe coincidir con la de prueba.");
    }

    @Test
    public void test02SeBuscaUnComentarioInexistente() {
        ComentarioService comentarioService = new ComentarioService(comentarioProvider);

        Assertions.assertThrows(
                PostSinComentariosException.class,
                () -> comentarioService.obtenerComentariosDePostPorId(999)
        );
    }
}