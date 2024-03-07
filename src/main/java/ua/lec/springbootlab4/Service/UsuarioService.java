package ua.lec.springbootlab4.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ua.lec.springbootlab4.Entity.Autorizacao;
import ua.lec.springbootlab4.Entity.Usuario;
import ua.lec.springbootlab4.Repository.AutorizacaoRepository;
import ua.lec.springbootlab4.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private AutorizacaoRepository autRepo;

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
        };
        if ((usuario.getAutorizacoes() != null) && (!usuario.getAutorizacoes().isEmpty())) {
            Set<Autorizacao> autorizacoes = new HashSet<Autorizacao>();
            for (Autorizacao aut : usuario.getAutorizacoes()) {
                autorizacoes.add(buscarAutorizacaoPorId(aut.getId()));
            }
            usuario.setAutorizacoes(autorizacoes);
        };
        return usuarioRepo.save(usuario);
    };

    public Autorizacao buscarAutorizacaoPorId(Long id) {
        Optional<Autorizacao> autOp = autRepo.findById(id);
        if (autOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autorização não encontrada.");
        }
        return autOp.get();
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
