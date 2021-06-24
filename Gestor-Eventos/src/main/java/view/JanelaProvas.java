package view;

import model.Prova;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaProvas extends JFrame{
    private JButton NovaButton;
    private JPanel mainPanel;
    private JList listProvas;
    private JButton selecionarButton;
    private JButton voltarButton;
    private JFrame anterior;
    private LinkedList<Prova> provas;

    public JanelaProvas(JFrame anterior, LinkedList<Prova> provas){
        super("Prova");
        this.anterior = anterior;
        this.provas = provas;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        pack();
         {
            updateList();
        }

        selecionarButton.addActionListener(this::buttonSelecionarActionPerformed);
        voltarButton.addActionListener(this::buttonVoltarActionPerformed);
    }

    private void buttonVoltarActionPerformed(ActionEvent evt) {
        this.dispose();
        anterior.setVisible(true);
    }

    private void buttonSelecionarActionPerformed(ActionEvent evt) {
        Prova prova = getSelectedEvent();
        setVisible(false);
        new JanelaProva(this,prova);
    }

    private void updateList(){

        DefaultListModel<String> l1 = new DefaultListModel<>();
        if(provas.isEmpty()){
            l1.addElement("Não existem provas!");
            selecionarButton.setEnabled(false);
        }else{
            for (Prova p: provas) {
                l1.addElement(p.toString());
            }
        }

        listProvas.setModel(l1);
    }

    private Prova getSelectedEvent(){
        for (Prova p : provas) {
            if(p.toString().equals(listProvas.getSelectedValue().toString())){
                return p;
            }
        }
        return null;
    }
}
