package view;

import model.Etapa;
import model.Prova;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaCalendarioProva extends JFrame{
    private JButton voltarButton;
    private JPanel mainPanel;
    private JList listCalendario;
    private JFrame anterior;
    private Prova prova;

    public JanelaCalendarioProva(JFrame anterior, Prova prova){
        super("Calendario Prova");
        this.anterior = anterior;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        pack();

        voltarButton.addActionListener(this::buttonVoltarActionPerformed);
    }

    private void buttonVoltarActionPerformed(ActionEvent evt) {
        this.dispose();
        anterior.setVisible(true);

    }

    private void updateList(){

        DefaultListModel<String> l1 = new DefaultListModel<>();
        LinkedList<Etapa> etapas = prova.getEliminatorias();
        etapas.add(prova.getEtapaFinal());
        for(Etapa e : etapas){
            l1.addElement(e.getDiaAno().toString() +" "+e.getHora()+" "+e.getGenero().name()+" ");
        }

        listCalendario.setModel(l1);
    }

}
