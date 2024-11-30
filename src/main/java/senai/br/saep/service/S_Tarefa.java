package senai.br.saep.service;

import org.springframework.stereotype.Service;
import senai.br.saep.model.M_Tarefa;
import senai.br.saep.model.M_Usuario;
import senai.br.saep.repository.R_Usuario;

@Service
public class S_Tarefa {

    private static S_Usuario s_usuario;

    public S_Tarefa(S_Usuario s_usuario) {
        this.s_usuario = s_usuario;
    }

    public Boolean cadastraTarefa(String descricao, String setor, Long usuario, String prioridade) {

        boolean podeSalvar = true;

        if (descricao != null || descricao.trim().isEmpty()) {
            podeSalvar = true;
        } else {
            podeSalvar = false;
        }

        if (setor != null || setor.trim().isEmpty()) {
            podeSalvar = false;
        } else {
            podeSalvar = false;
        }
        if (usuario != null) {
            podeSalvar = false;
        } else {
            podeSalvar = false;
        }
        if (prioridade != null || prioridade.trim().isEmpty()) {
            podeSalvar = false;
        } else {
            podeSalvar = false;
        }

        if (podeSalvar){
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setId(usuario);

            M_Tarefa m_tarefa = new M_Tarefa();

            m_tarefa.setDescricaoTarefa(descricao);
            m_tarefa.setNomeSetor(setor);
            m_tarefa.setUsuario(m_usuario);
            m_tarefa.setPrioridade(prioridade);

            return true;
        }else{
            return false;
        }

    }

}
