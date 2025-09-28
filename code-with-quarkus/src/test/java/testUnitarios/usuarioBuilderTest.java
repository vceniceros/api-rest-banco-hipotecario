package testUnitarios;

import builders.UsuarioBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.UsuarioDTO;
import models.Compañia;
import models.Direccion;
import models.Geo;
import models.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class usuarioBuilderTest {
    String json;
    ObjectMapper mapper;
    Geo geo;
    Direccion direccion;
    Compañia compañia;
    Usuario usuarioEsperado;

    @BeforeEach
    public void setUp() {
         json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"nombre\": \"Leanne Graham\",\n" +
                "  \"usuario\": \"Bret\",\n" +
                "  \"email\": \"Sincere@april.biz\",\n" +
                "  \"direccion\": {\n" +
                "    \"calle\": \"Kulas Light\",\n" +
                "    \"suite\": \"Apt. 556\",\n" +
                "    \"ciudad\": \"Gwenborough\",\n" +
                "    \"codPostal\": \"92998-3874\",\n" +
                "    \"geo\": {\n" +
                "      \"lat\": \"-37.3159\",\n" +
                "      \"lon\": \"81.1496\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"telefono\": \"1-770-736-8031 x56442\",\n" +
                "  \"website\": \"hildegard.org\",\n" +
                "  \"compañia\": {\n" +
                "    \"nombre\": \"Romaguera-Crona\",\n" +
                "    \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                "    \"bs\": \"harness real-time e-markets\"\n" +
                "  }\n" +
                "}";
        mapper = new ObjectMapper();

        geo = new Geo(-37.3159, 81.1496);
        direccion = new Direccion("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", geo);
        compañia = new Compañia("Romaguera-Crona",
                "Multi-layered client-server neural-net",
                "harness real-time e-markets");

        usuarioEsperado = new Usuario(
                1, "Leanne Graham", "Bret", "Sincere@april.biz",
                direccion, "1-770-736-8031 x56442", "hildegard.org", compañia
        );
    }


    @Test
    public void test01SeVerificaQueAlPasarleUnJsonSeCreaUnUsuario() throws JsonProcessingException {

        UsuarioDTO dto = mapper.readValue(json, UsuarioDTO.class);

        Usuario usuario = UsuarioBuilder.construirUsuario(dto);

        Assertions.assertTrue(usuario.esElMismoUsuario(usuario));
    }


}
