package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedList;

public class  Etapa<T> {

    @Getter@Setter
    private LocalDate diaAno;
    @Getter@Setter
    private int diaCompeticao;
    private Atleta[] atletas;
    private T[] resultados;

}
