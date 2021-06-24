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
    private JButton button1;
    private JButton button2;
    private JButton importButton;
    private JTable table;
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


        String data[][]={ {"101","Amit","670000"},
                {"102","Jai","780000"},
                {"101","Sachin","700000"}};
        String column[]={"ID","NAME","SALARY"};
        JTable table=new JTable(data,column);
        table.setBounds(30,40,200,300);

        buttonVoltar.addActionListener(this::buttonVoltarActionPerformed);
        buttonCriarEvento.addActionListener(this::buttonCriarEventoActionPerformed);
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
