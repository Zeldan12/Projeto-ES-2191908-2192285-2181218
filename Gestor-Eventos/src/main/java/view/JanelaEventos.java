package view;

import model.Evento;
import model.Singleton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;


/**
 * 2181218
 * JanelaEventos, Janela para gerir eventos
 * Options: Criar Evento, Editar Evento, Eliminar Evento, Adicionar prova ao evento, Remover prova do evento
 */
public class JanelaEventos extends JFrame{
    private JButton buttonCriarEvento;
    private JButton buttonVoltar;
    private JPanel eventosPanel;
    private JButton buttonEditarEvento;
    private JButton buttonEliminar;
    private JButton importButton;
    private JList list1;
    private JFrame voltar;

    public JanelaEventos(JFrame anterior){
        super("Eventos");

        voltar = anterior;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(eventosPanel);

        pack();
        /*
        String[][] data = new String[Singleton.getInstance().dadosAplicacao.getEventos().size()][5];
        int i =0;
        for (Evento e: Singleton.getInstance().dadosAplicacao.getEventos()) {
            String[] str = {e.getNome(), e.getDataInicio().toString()};
            data[i] = str;
            i++;
        }
        String column[]={"Nome","Data Inicio","Data Fim", "Local", "Pais"};
        table = new JTable(data,column);*/

        DefaultListModel<String> l1 = new DefaultListModel<>();
        for (Evento e: Singleton.getInstance().dadosAplicacao.getEventos()) {
            l1.addElement(e.toString());
        }
        list1.setModel(l1);

        buttonVoltar.addActionListener(this::buttonVoltarActionPerformed);
        buttonCriarEvento.addActionListener(this::buttonCriarEventoActionPerformed);
    }

    private void changed(ActionEvent evt){
        this.dispose();
        voltar.setVisible(true);
    }

    private void buttonVoltarActionPerformed(ActionEvent evt){
        this.dispose();
        voltar.setVisible(true);
    }
    private void buttonCriarEventoActionPerformed(ActionEvent evt){
        this.setVisible(false);
        new JanelaCriarEvento(this).setVisible(true);
    }
}
