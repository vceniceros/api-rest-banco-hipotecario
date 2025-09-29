package providers;

import models.Usuario;

public interface UserProvider {
    Usuario obtenerUsuarioPorId(int idUsuario);
}