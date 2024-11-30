package senai.br.saep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import senai.br.saep.repository.R_Usuario;
import senai.br.saep.service.S_Usuario;

@Controller
@RequestMapping("/usuario")
public class C_Usuario {

    private static S_Usuario s_usuario;

    public C_Usuario(S_Usuario s_usuario) {
        this.s_usuario = s_usuario;
    }

    @GetMapping("/cadastrar")
    public String getCadastrarUsuario() {
        return "cadastro-usuario";
    }

    @PostMapping("/cadastrar")
    public String CadastrarUsuario(@RequestParam("nomeUsuario") String user,
                                   @RequestParam("emailUsuario") String email,
                                   Model model) {


        if (s_usuario.cadastraUsuario(user, email)) {
            model.addAttribute("message", "sucesso ao cadastrar usuario");
        } else {
            model.addAttribute("message", "erro ao cadastrar usuario");
        }

        return "cadastro-usuario";
    }

}
