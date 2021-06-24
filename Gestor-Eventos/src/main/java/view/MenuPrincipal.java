package view;

import model.DadosAplicacao;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame{
    private JButton buttonEventos;
    private JButton buttonAtletas;
    private JButton buttonProvas;
    private JButton buttonRecordes;
    private JButton buttonSair;
    private JPanel mainPanel;


    public MenuPrincipal() {
        super("Menu Principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        new DadosAplicacao();
        pack();

        buttonSair.addActionListener(this::buttonSairActionPerformed);
        buttonRecordes.addActionListener(this::buttonRecordesActionPerformed);
        buttonProvas.addActionListener(this::buttonProvasActionPerformed);
        buttonEventos.addActionListener(this::buttonEventosActionPerformed);
        buttonAtletas.addActionListener(this::buttonAtletasActionPerformed);
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new SaveOnExit());
        new MenuPrincipal().setVisible(true);
    }

    private void buttonSairActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void buttonProvasActionPerformed(ActionEvent evt){
        return;
    }

    private void buttonRecordesActionPerformed(ActionEvent evt){
        this.setVisible(false);
        new JanelaRecordes(this).setVisible(true);
    }

    private void buttonEventosActionPerformed(ActionEvent event) {
        this.setVisible(false);
        new JanelaEventos(this).setVisible(true);
    }

    private void buttonAtletasActionPerformed(ActionEvent event){
        this.setVisible(false);
        new JanelaAtletas(this).setVisible(true);
    }


    static class SaveOnExit extends Thread {

        public void run() {
            DadosAplicacao.salvarDadosAplicacao();
        }
    }

}
