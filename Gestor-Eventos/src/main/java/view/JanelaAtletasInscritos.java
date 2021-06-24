package view;

import model.Atleta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaAtletasInscritos extends JFrame{
    private JPanel mainPanel;
    private JButton voltarButton;
    private JButton adicionarButton;
    private JButton removerButton;
    private JFrame anterior;
    private LinkedList<Atleta> atletas;

    public JanelaAtletasInscritos(JFrame anterior, LinkedList<Atleta> atletas){
        super("Prova");
        this.anterior = anterior;
        this.atletas = atletas;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        //Mostrar a lista dos atletas

        pack();

        voltarButton.addActionListener(this::buttonVoltarActionPerformed);
    }

    private void buttonVoltarActionPerformed(ActionEvent evt) {
        this.dispose();
        anterior.setVisible(true);
    }
}
