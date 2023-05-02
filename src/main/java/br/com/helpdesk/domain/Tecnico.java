package br.com.helpdesk.domain;

import br.com.helpdesk.domain.enums.Perfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Pessoa {

    public Tecnico() {
        super();
        addPerfil(Perfil.TECNICO);
    }

    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();


    public Tecnico(Integer id, String nome, String cpf, String email, String senha, List<Chamado> chamados) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.TECNICO);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
