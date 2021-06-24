package view;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaAtletas extends JFrame {
    private JButton buttonAdicionar;
    private JButton buttonEditar;
    private JButton editarButton;
    private JButton buttonSair;
    private JPanel atletasPanel;
    private JFrame voltar;

    public JanelaAtletas(JFrame anterior){
        super("Atletas");
        voltar=anterior;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(atletasPanel);

        pack();

        //updateList();

        buttonAdicionar.addActionListener(this::buttonAdicionarActionPerformed);
        buttonSair.addActionListener(this::buttonSairActionPerformed);
        buttonEditar.addActionListener(this::buttonEditarActionPerformed);


    }

    private void buttonEditarActionPerformed(ActionEvent event) {

    }

    public void buttonSairActionPerformed(ActionEvent event) {
        this.dispose();
        voltar.setVisible(true);
    }

    private void buttonAdicionarActionPerformed(ActionEvent event) {
        this.setVisible(false);
        new JanelaCriarAtleta(this).setVisible(true);

    }


}
