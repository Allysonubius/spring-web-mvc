package com.Jackson.Binder.Dto;

import com.Jackson.Binder.Enum.Raça;

public class Perfil {
    private Long id;
    private String cpf;
    private String nome;
    private Raça raça;
    private String arma;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Raça getRaça() {
        return raça;
    }

    public void setRaça(Raça raça) {
        this.raça = raça;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
