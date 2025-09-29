package services;

import exceptions.UsuarioNoEncontradoException;
import models.Usuario;
import providers.UserProvider;


public class UserService {
    private UserProvider userProvider;

    public UserService(UserProvider userProvider) {
        this.userProvider = userProvider ;
    }

    public Usuario obtenerUsuarioPorId(int idUsuario) {
        Usuario usuario = userProvider.obtenerUsuarioPorId(idUsuario);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException();
        }else{
            return usuario;
        }
    }
}
