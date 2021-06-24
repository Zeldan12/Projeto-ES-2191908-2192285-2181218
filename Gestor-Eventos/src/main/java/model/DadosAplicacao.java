package model;

import java.io.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DadosAplicacao implements Serializable{

    private static LinkedList<Evento> eventos;
    private static LinkedList<Atleta> atletas;

    public DadosAplicacao(){
        eventos = new LinkedList<>();
        lerDadosAplicacao();
    }

    public static void salvarDadosAplicacao() {
        ObjectOutputStream oos = null;
        try {
            File f = new File(System.getProperty("user.home") + File.separator + "gestor-eventos.dados");
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(eventos);
            oos.writeObject(atletas);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(DadosAplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void lerDadosAplicacao() {
        ObjectInputStream ois = null;
        File f = new File(System.getProperty("user.home")+File.separator+"gestor-eventos.dados");
        if (f.canRead()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(f));
                DadosAplicacao temp;
                eventos = (LinkedList<Evento>) ois.readObject();
                atletas = (LinkedList<Atleta>) ois.readObject();
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(DadosAplicacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DadosAplicacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static LinkedList<Evento> getEventos() {
        return eventos;
    }

    /**
     * adds an event to the list of events, if the event is not null and if it is not in the list of events already
     */
    public static void adicionarEvento(Evento evento){
        if(!eventos.contains(evento) && evento != null){
            eventos.add(evento);
        }
    }


    /**
     * If a certain event exists it will remove it from the list of events
     */
    public static void removerEvento(Evento evento){
        if(eventos.contains(evento)){
            eventos.remove(evento);
        }
    }

}
