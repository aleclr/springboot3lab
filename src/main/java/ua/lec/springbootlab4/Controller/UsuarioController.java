package ua.lec.springbootlab4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ua.lec.springbootlab4.Entity.Usuario;
import ua.lec.springbootlab4.Service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {

    //apesar de ser classe, nao instanciar, se nao as notações spring não entrarão em efeito
    //alternativa: declarar o construtor da classe Controller passando como atributo o service
    @Autowired
    private UsuarioService service;

    //ResponseEntity para formatar respostas mais completas
    @GetMapping
    @JsonView(Usuario.class)
    public List<Usuario> buscarTodos() {
        return service.buscarTodos();
    };

    //PostMapping para cadastrar coisas
    //Identificar de onde vem o parametro (URL ou corpo da pagina) se o parametro é classe vem do corpo
    @PostMapping
    public Usuario novo(@RequestBody Usuario usuario) {
        return service.novo(usuario);
    };

    //diferenciar os GetMapping pela URL
    //como o parametro vem da URL, não é uma classe, usar PathVariable
    @GetMapping(value = "/{id}")
    public Usuario buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    };

}
