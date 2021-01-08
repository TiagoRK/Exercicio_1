/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio_1;

import java.util.List;

/**
 *
 * @author TIAGO
 */
public class Pai {

    private String nome;
    private List<Filho> listaDeFilhos;

    public Pai() {
    }

    public Pai(String nome) {
        this.nome = nome;
    }

    public Pai(String nome, List<Filho> listaDeFilhos) {
        this.nome = nome;
        this.listaDeFilhos = listaDeFilhos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Filho> getListaDeFilhos() {
        return listaDeFilhos;
    }

    public void setListaDeFilhos(List<Filho> listaDeFilhos) {
        this.listaDeFilhos = listaDeFilhos;
    }
}
