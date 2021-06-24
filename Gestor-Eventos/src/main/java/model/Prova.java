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

    public Prova(String nome, double minimos){
        this(nome, minimos, new LinkedList<>(), new Etapa(), new LinkedList<>());
    }

    public Etapa addEtapa(Etapa etapa){
        //TODO
        return null;
    }

    public Etapa removeEtapa(Etapa etapa){
        //TODO
        return null;
    }

    public Atleta addAtleta(Atleta atleta){
        //TODO
        return null;
    }

    public Atleta removeAtleta(Atleta atleta){
        //TODO
        return null;
    }

    private void atualizarCalendarioEtapas(){

        return;
    }

    private void limparCalendarioEtapas(){

    }
}
