package senai.br.saep.service;

import org.springframework.stereotype.Service;
import senai.br.saep.model.M_Tarefa;
import senai.br.saep.model.M_Usuario;
import senai.br.saep.repository.R_Tarefa;
import senai.br.saep.repository.R_Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class S_Tarefa {

    private static R_Tarefa r_tarefa;
    private static S_Usuario s_usuario;

    public S_Tarefa(S_Usuario s_usuario, R_Tarefa r_tarefa) {
        this.s_usuario = s_usuario;
        this.r_tarefa = r_tarefa;
    }

    public Boolean cadastraTarefa(String descricao, String setor, Long usuario, String prioridade) {

        boolean podeSalvar = true;

        if (descricao != null || descricao.trim().isEmpty()) {
            podeSalvar = true;
        } else {
            podeSalvar = false;
        }

        if (setor != null || setor.trim().isEmpty()) {
            podeSalvar = true;
        } else {
            podeSalvar = false;
        }
        if (usuario != null) {
            podeSalvar = true;
        } else {
            podeSalvar = false;
        }
        if (prioridade != null || prioridade.trim().isEmpty()) {
            podeSalvar = true;
        } else {
            podeSalvar = false;
        }

        if (podeSalvar){
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setId(usuario);

            M_Tarefa m_tarefa = new M_Tarefa();

            LocalDate dataAgora = LocalDate.now();

            m_tarefa.setDescricaoTarefa(descricao);
            m_tarefa.setNomeSetor(setor);
            m_tarefa.setUsuario(m_usuario);
            m_tarefa.setPrioridade(prioridade);
            m_tarefa.setDataCadastro(dataAgora);

            r_tarefa.save(m_tarefa);

            return true;
        }else{
            return false;
        }

    }

}
