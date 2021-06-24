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
        this(nome, dataInicio, dataFim, local, pais, new LinkedList<>());
    }

    //adds a prova to the list of provas, if the prova is not null and if it is not in the list already
    public void addProva(Prova prova){
        if(!provas.contains(prova) && prova != null){
            provas.add(prova);
        }
    }

    //If a certain prova exists it will remove it from the list
    public Prova removeProva(Prova prova){
        if(provas.contains(prova) && prova != null){
            provas.remove(prova);
            prova.setEvento(null);
        }
        return prova;
    }

    // returns null if everything is ok, else a string with the error.
    public String isValid(){
        return null;
    }

    @Override
    public String toString() {
        return nome + '{' + dataInicio +" -> " + dataFim + "}  @" + local + ", " + pais;
    }
}
