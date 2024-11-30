package senai.br.saep.service;

import org.springframework.stereotype.Service;
import senai.br.saep.model.M_Usuario;
import senai.br.saep.repository.R_Usuario;

@Service
public class S_Usuario {

    private static R_Usuario r_usuario;

    public S_Usuario(R_Usuario r_usuario) {
        this.r_usuario = r_usuario;
    }

    public Boolean cadastraUsuario(String nome, String email){

        boolean podeSalvar = false;

        if (nome != null && !nome.trim().isEmpty()) {
            podeSalvar = true;
        } else {
            podeSalvar = false;
        }

        if (email != null && !email.trim().isEmpty()) {
            podeSalvar = true;
        } else {
            podeSalvar = false;
        }

        if (podeSalvar){
            M_Usuario m_usuario = new M_Usuario();

            m_usuario.setNome(nome);
            m_usuario.setEmail(email);

            r_usuario.save(m_usuario);

            return true;
        } else{
            return false;
        }
    }

}
