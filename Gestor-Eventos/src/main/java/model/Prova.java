package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@AllArgsConstructor
public class Prova {

    @Getter @Setter
    private String nome;
    @Getter @Setter
    private double minimos;
    @Getter
    private LinkedList<Etapa> eliminatorias;
    private Etapa etapaFinal;
    @Getter
    private LinkedList<Atleta> atletas;

    @Getter@Setter
    private Evento evento;

    public Prova(String nome, double minimos, Evento evento){
        this(nome, minimos, new LinkedList<Etapa>(), null, new LinkedList<>(), evento);
    }

    public Etapa addEtapa(Etapa etapa){
        return null;
    }

    public Etapa removeEtapa(Etapa etapa){
        //TODO
        return null;
    }

    public Atleta inscreverAtleta(Atleta atleta){
        //TODO
        return null;
    }

    public Atleta removeAtleta(Atleta atleta){
        //TODO
        return null;
    }


}
