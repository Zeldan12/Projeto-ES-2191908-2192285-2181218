package view;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaCalendarioProva extends JFrame{
    private JTable tableCalendario;
    private JButton voltarButton;
    private JPanel mainPanel;
    private JFrame anterior;

    public JanelaCalendarioProva(JFrame anterior){
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
}
