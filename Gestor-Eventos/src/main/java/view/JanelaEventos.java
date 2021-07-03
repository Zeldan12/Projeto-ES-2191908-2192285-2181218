package view;

import model.DadosAplicacao;
import model.Evento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
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
    private JList listEventos;
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
        buttonEditarEvento.addActionListener(this::buttonEditarEventoActionPerformed);
        buttonEliminar.addActionListener(this::buttonEliminarEventoActionPerformed);
        JanelaEventos temp = this;
        listEventos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    listEventos.setSelectedIndex(index);
                    Evento e = getSelectedEvent();
                    temp.setVisible(false);
                    new JanelaDetalhesEvento(temp, e).setVisible(true);
                }
            }
        });
    }



    public void buttonVoltarActionPerformed(ActionEvent evt){
        this.dispose();
        voltar.setVisible(true);
    }
    private void buttonCriarEventoActionPerformed(ActionEvent evt){
        this.setVisible(false);
        new JanelaCriarEvento(this).setVisible(true);
    }

    private void buttonEditarEventoActionPerformed(ActionEvent evt){
        this.setVisible(false);
        Evento e = getSelectedEvent();
        if(e != null){
            new JanelaEditarEvento(this,e).setVisible(true);
        }
        else{
            ErrorMessage.show("Erro","Nenhum evento está selecionado");
        }
    }

    private void buttonEliminarEventoActionPerformed(ActionEvent event) {
        Evento e = getSelectedEvent();
        if(e != null){
            JanelaConfirmarEliminarEvento.show(e);
            updateList();
        }
        else{
            ErrorMessage.show("Erro","Nenhum evento está selecionado");
        }
    }

    private void updateList(){
        DefaultListModel<String> l1 = new DefaultListModel<>();
        for (Evento e: DadosAplicacao.getEventos()) {
            l1.addElement(e.toString());
        }
        listEventos.setModel(l1);
    }


    private Evento getSelectedEvent(){
        for (Evento e : DadosAplicacao.getEventos()) {
            if(e.toString().equals(listEventos.getSelectedValue().toString())){
                return e;
            }
        }
        return null;
    }



}
