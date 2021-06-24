package model;

import java.io.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DadosAplicacao implements Serializable{

    private LinkedList<Evento> eventos;

    public DadosAplicacao(){
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

    public void adicionarEvento(Evento evento){
        if(!eventos.contains(evento) && evento != null){
            eventos.add(evento);
        }
    }

    public void removerEvento(Evento evento){
        if(eventos.contains(evento)){
            eventos.remove(evento);
        }
    }

}
