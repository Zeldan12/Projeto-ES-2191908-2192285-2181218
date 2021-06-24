package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedList;

public class Etapa<T> {

    @Getter @Setter
    private LocalDate diaAno;

    @Getter @Setter
    private int diaCompeticao;

    @Getter @Setter
    private int hora;

    @Getter @Setter
    private Genero genero;

    @Getter @Setter
    private Atleta[] pistas;

    @Getter @Setter
    private double[] resultados;

    public Etapa(){}

    public Etapa(LocalDate diaAno, int diaCompeticao, int hora, Genero genero) {
        this.diaAno = diaAno;
        this.diaCompeticao = diaCompeticao;
        this.hora = hora;
        this.genero = genero;
    }
}
