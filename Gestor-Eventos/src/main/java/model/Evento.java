package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedList;

@AllArgsConstructor
public class Evento {

    @Getter@Setter
    private String nome;
    @Getter@Setter
    private LocalDate dataInicio;
    @Getter@Setter
    private LocalDate dataFim;
    @Getter@Setter
    private String local;
    @Getter@Setter
    private String pais;
    @Getter
    private LinkedList<Prova> provas;

    public Evento(String nome, LocalDate dataInicio, LocalDate dataFim, String local, String pais) {
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

    public boolean isValid(){
        return true;
    }
}
