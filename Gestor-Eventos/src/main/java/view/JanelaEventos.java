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
    public JFrame voltar;

    public JanelaEventos(JFrame anterior){
        super("Eventos");

        voltar = anterior;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(eventosPanel);

        pack();

        updateList();

        buttonVoltar.addActionListener(this::buttonVoltarActionPerformed);
        buttonCriarEvento.addActionListener(this::buttonCriarEventoActionPerformed);
    }

    public void buttonVoltarActionPerformed(ActionEvent evt){
        this.dispose();
        voltar.setVisible(true);
    }
    private void buttonCriarEventoActionPerformed(ActionEvent evt){
        this.setVisible(false);
        new JanelaCriarEvento(this).setVisible(true);
    }

    private void updateList(){
        DefaultListModel<String> l1 = new DefaultListModel<>();
        for (Evento e: Singleton.getInstance().dadosAplicacao.getEventos()) {
            l1.addElement(e.toString());
        }
        list1.setModel(l1);
    }


}
