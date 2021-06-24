package view;

import model.Etapa;
import model.Prova;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaProva extends JFrame {
    private JButton calendarioButton;
    private JButton atletasButton;
    private JButton resultadosButton;
    private JButton eliminarButton;
    private JButton voltarButton;
    private JLabel labelNome;
    private JLabel labelSexo;
    private JLabel labelMinimos;
    private JLabel labelEstado;
    private JPanel mainPanel;
    private JFrame anterior;
    private Prova prova;

    public JanelaProva(JFrame anterior, Prova prova){
        super("Prova");
        this.anterior = anterior;
        this.prova = prova;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        pack();

        labelNome.setText(prova.getNome());
        labelSexo.setText(prova.getGenero().name());
        labelMinimos.setText(prova.getNome());
        labelEstado.setText(prova.getNome());


        calendarioButton.addActionListener(this::buttonCalendarioActionPerformed);
        atletasButton.addActionListener(this::buttonAtletasActionPerformed);
        resultadosButton.addActionListener(this::buttonResultadosActionPerformed);
        voltarButton.addActionListener(this::buttonVoltarActionPerformed);
    }

    private void buttonVoltarActionPerformed(ActionEvent evt) {
        this.dispose();
        anterior.setVisible(true);

    }

    private void buttonResultadosActionPerformed(ActionEvent evt) {

    }

    private void buttonAtletasActionPerformed(ActionEvent evt) {
        if(!prova.getAtletas().isEmpty()){
            setVisible(false);
            new JanelaAtletasInscritos(this,prova.getAtletas());
        }else{
            ErrorMessage.show("Warning","Não existem inscrições nesta prova.");
        }

    }

    private void buttonCalendarioActionPerformed(ActionEvent evt) {
        setVisible(false);
        new JanelaCalendarioProva(this, prova);
    }

}
