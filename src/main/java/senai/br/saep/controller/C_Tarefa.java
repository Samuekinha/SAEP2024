package senai.br.saep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import senai.br.saep.model.M_Usuario;
import senai.br.saep.repository.R_Usuario;
import senai.br.saep.service.S_Tarefa;

import java.util.List;

@Controller
@RequestMapping("/tarefa")
public class C_Tarefa {

    private static S_Tarefa s_tarefa;
    private static R_Usuario r_usuario;

    public C_Tarefa(S_Tarefa s_tarefa, R_Usuario r_usuario) {
        this.s_tarefa = s_tarefa;
        this.r_usuario = r_usuario;
    }

    @GetMapping("/cadastrar")
    public String getCadastrarTarefa(Model model) {

        List<M_Usuario> usuario = r_usuario.findAll();

        model.addAttribute("usuarios", usuario);

        return "cadastro-tarefa";
    }

    @PostMapping("/cadastrar")
    public String CadastrarTarefa(@RequestParam("tarefaDesc") String descricao,
                                  @RequestParam("tarefaSetor") String setor,
                                  @RequestParam("tarefaUsuario") Long usuario,
                                  @RequestParam("prioridadeTarefa") String prioridade,
                                  Model model) {

        if (s_tarefa.cadastraTarefa(descricao, setor, usuario, prioridade)) {
            model.addAttribute("message", "Sucesso ao cadastrar tarefa");
        } else {
            model.addAttribute("message", "Erro ao cadastrar tarefa");
        }

        return "cadastro-tarefa";
    }


}
