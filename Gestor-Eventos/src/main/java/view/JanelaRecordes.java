package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JanelaRecordes extends JFrame{
    private JPanel recordsPanel;
    private JButton buttonMedalhasPaises;
    private JButton buttonRecordesPessoais;
    private JButton buttonRecordesProvas;
    private JButton buttonVoltar;
    private JFrame voltar;

    public JanelaRecordes(JFrame anterior){
        super("Recordes");

        voltar = anterior;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(recordsPanel);

        pack();

        buttonVoltar.addActionListener(this::buttonVoltarActionPerformed);
    }

    private void buttonVoltarActionPerformed(ActionEvent evt){
        this.dispose();
        voltar.setVisible(true);
    }
}
