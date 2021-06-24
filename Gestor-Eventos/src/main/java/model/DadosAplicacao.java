package model;

import java.io.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DadosAplicacao implements Serializable{

    private LinkedList<Evento> eventos;

    public DadosAplicacao(){
        eventos = new LinkedList<>();
        lerRecordesDoDisco();
    }

    private void guardarRecordesDisco() {
        ObjectOutputStream oos = null;
        try {
            File f = new File(System.getProperty("user.home") + File.separator + "atletas.dados");
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(this);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(DadosAplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lerRecordesDoDisco() {
        ObjectInputStream ois = null;
        File f = new
                File(System.getProperty("user.home")+File.separator+"minesfinder.recordes");
        if (f.canRead()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(f));
                DadosAplicacao temp;
                temp = (DadosAplicacao) ois.readObject();
                ois.close();
                Singleton.getInstance().dadosAplicacao = temp;
            } catch (IOException ex) {
                Logger.getLogger(DadosAplicacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DadosAplicacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public LinkedList<Evento> getEventos() {
        return eventos;
    }

    /**
     * 2181218
     * adds an event to the list of events, if the event is not null and if it is not in the list of events already
     */
    public void adicionarEvento(Evento evento){
        if(!eventos.contains(evento) && evento != null){
            eventos.add(evento);
        }
    }


    /**
     * 2181218
     * If a certain event exists it will remove it from the list of events
     */
    public void removerEvento(Evento evento){
        if(eventos.contains(evento)){
            eventos.remove(evento);
        }
    }

}
