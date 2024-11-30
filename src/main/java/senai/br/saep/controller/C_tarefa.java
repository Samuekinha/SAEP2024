package senai.br.saep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import senai.br.saep.repository.R_Usuario;
import senai.br.saep.service.S_Tarefa;
import senai.br.saep.service.S_Usuario;

@Controller
@RequestMapping("/tarefa")
public class C_tarefa {

    private static S_Tarefa s_tarefa;
    private static R_Tarefa r_tarefa;

    public C_tarefa(S_Tarefa s_tarefa) {
        this.s_tarefa = s_tarefa;
    }

    @GetMapping("/cadastrar")
    public String getCadastrarTarefa() {

        r

        return "cadastro-tarefa";
    }

    @PostMapping("/cadastrar")
    public String CadastrarTarefa(@RequestParam("nomeUsuario") String descricao,
                                   @RequestParam("emailUsuario") String setor,
                                   @RequestParam("") Long usuario,
                                   @RequestParam("") String prioridade,
                                   Model model) {


        if (s_tarefa.cadastraTarefa(descricao, setor, usuario, prioridade)) {
            model.addAttribute("message", "sucesso ao cadastrar tarefa");
        } else {
            model.addAttribute("message", "erro ao cadastrar tarefa");
        }

        return "cadastro-tarefa";
    }

}
