package view;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaCriarEvento extends JFrame{
    private JButton buttonConfirmar;
    private JButton buttonCancelar;
    private JTextField textFieldNomeEvento;
    private JTextField textFieldPais;
    private JTextField textFieldDataInicio;
    private JTextField textFieldDataFim;
    private JTextField textFieldLocal;
    private JPanel content;
    private JFrame voltar;

    public JanelaCriarEvento(JFrame anterior){
        super("Eventos");

        voltar = anterior;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(content);

        pack();

        buttonConfirmar.addActionListener(this::buttonCancelarActionPerformed);
        buttonCancelar.addActionListener(this::buttonConfirmarActionPerformed);
    }

    private void buttonConfirmarActionPerformed(ActionEvent event) {

    }

    private void buttonCancelarActionPerformed(ActionEvent event) {
        this.dispose();
        voltar.setVisible(true);
    }
}
