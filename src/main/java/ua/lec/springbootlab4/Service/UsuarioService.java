package ua.lec.springbootlab4.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ua.lec.springbootlab4.Entity.Usuario;
import ua.lec.springbootlab4.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public List<Usuario> buscarTodos() {
        return usuarioRepo.findAll();
    };
    
    public Usuario novo(Usuario usuario) {
        if ((usuario == null) || 
        (usuario.getNome() == null) || 
        (usuario.getNome().isBlank()) ||
        (usuario.getSenha() == null) ||
        (usuario.getSenha().isBlank())) {
            //nunca continuar depois de não passar na validação -> throw exception
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados de usuario invalidos");
        } else {
            return usuarioRepo.save(usuario);
        }
    };

    public Usuario buscarPorId(Long id) {
        @SuppressWarnings("null")
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if (usuarioOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado.");
        }
        return usuarioOp.get();
    };
}
