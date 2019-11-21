/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import bTree.*;



/**
 *
 * @author Administrador
 */
public class Candidato {
    private long cpf;
    private String nome;

    public Candidato(long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Candidato{" + "cpf=" + cpf + ", nome=" + nome + '}';
    }
    
    
    
}
