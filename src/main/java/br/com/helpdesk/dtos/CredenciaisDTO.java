package br.com.helpdesk.dtos;

public class CredenciaisDTO {
    private String email;
    private String senha;

    public CredenciaisDTO() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
