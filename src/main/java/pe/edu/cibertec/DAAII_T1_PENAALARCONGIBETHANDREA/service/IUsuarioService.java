package pe.edu.cibertec.DAAII_T1_PENAALARCONGIBETHANDREA.service;

import pe.edu.cibertec.DAAII_T1_PENAALARCONGIBETHANDREA.model.bd.Usuario;


public interface IUsuarioService {
    Usuario buscarUsuarioXNomUsuario(String nomUsuario);
    Usuario guardarUsuario(Usuario usuario);
}
