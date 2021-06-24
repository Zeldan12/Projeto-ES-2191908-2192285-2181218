package view;

import model.Atleta;
import model.Prova;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaAtletasInscritos extends JFrame{
    private JPanel mainPanel;
    private JButton voltarButton;
    private JButton adicionarButton;
    private JButton removerButton;
    private JList listAtletas;
    private JFrame anterior;
    private LinkedList<Atleta> atletas;

    public JanelaAtletasInscritos(JFrame anterior, LinkedList<Atleta> atletas){
        super("Prova");
        this.anterior = anterior;
        this.atletas = atletas;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        pack();

        updateList();

        voltarButton.addActionListener(this::buttonVoltarActionPerformed);
    }

    private void buttonVoltarActionPerformed(ActionEvent evt) {
        this.dispose();
        anterior.setVisible(true);
    }

    private void updateList(){

        DefaultListModel<String> l1 = new DefaultListModel<>();
        for (Atleta a: atletas) {
                l1.addElement(a.toString());
        }

        listAtletas.setModel(l1);
    }

    private Atleta getSelectedEvent(){
        for (Atleta a: atletas) {
            if(a.toString().equals(listAtletas.getSelectedValue().toString())){
                return a;
            }
        }
        return null;
    }
}
