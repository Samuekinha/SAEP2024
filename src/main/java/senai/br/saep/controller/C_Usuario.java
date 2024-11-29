package senai.br.saep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class C_Usuario {

    @GetMapping("/cadastrar")
    public String getCadastrarUsuario(){
        return "cadastro-usuario";
    }

}
