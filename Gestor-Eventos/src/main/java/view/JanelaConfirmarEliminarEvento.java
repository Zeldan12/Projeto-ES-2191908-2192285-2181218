package view;

import model.DadosAplicacao;
import model.Evento;

import javax.swing.*;
import java.awt.event.*;

public class JanelaConfirmarEliminarEvento extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel eventoLabel;

    public JanelaConfirmarEliminarEvento(Evento evento) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        eventoLabel.setText(evento.toString());

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(evento);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK(Evento e) {
        DadosAplicacao.removerEvento(e);
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public static void show(Evento e) {
        JanelaConfirmarEliminarEvento dialog = new JanelaConfirmarEliminarEvento(e);
        dialog.pack();
        dialog.setVisible(true);
    }
}
