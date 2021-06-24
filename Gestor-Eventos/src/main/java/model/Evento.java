package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@AllArgsConstructor
public class Evento {

    @Getter@Setter
    private String nome;
    @Getter@Setter
    private Data dataInicio;
    @Getter@Setter
    private Data dataFim;
    @Getter@Setter
    private String local;
    @Getter@Setter
    private String pais;
    @Getter
    private LinkedList<Prova> provas;

    public Evento(String nome, Data dataInicio, Data dataFim, String local, String pais) {
        this(nome,dataInicio,dataFim,local,pais, new LinkedList<>());
    }

    public Prova addProva(Prova prova){
        //TODO
        return null;
    }

    public Prova removeProva(Prova prova){
        //TODO
        return null;
    }
}
