package pe.edu.cibertec.DAAII_T1_PENAALARCONGIBETHANDREA.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAAII_T1_PENAALARCONGIBETHANDREA.model.bd.Rol;
import pe.edu.cibertec.DAAII_T1_PENAALARCONGIBETHANDREA.model.bd.Usuario;
import pe.edu.cibertec.DAAII_T1_PENAALARCONGIBETHANDREA.repository.RolRepository;
import pe.edu.cibertec.DAAII_T1_PENAALARCONGIBETHANDREA.repository.UsuarioRepository;


import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;


    @Override
    public Usuario buscarUsuarioXNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setActivo(true);
        Rol usuariorol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuariorol)));
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }
}