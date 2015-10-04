package com.example.marcos.topmetas;


import java.util.Date;

public class Meta {
    public int id;
    public String descricao;
    public int tempo;
    public int porcentagem;
    public Date dataFim;

    public Meta() {
        super();
    }

    public Meta(Date dataFim, int id, String descricao, int tempo, int porcentagem) {
        this.dataFim = dataFim;
        this.id = id;
        this.descricao = descricao;
        this.tempo = tempo;
        this.porcentagem = porcentagem;
    }
}
