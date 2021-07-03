package view;

import model.Evento;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaDetalhesEvento extends JFrame{
    private JButton buttonPrograma;
    private JButton buttonProvas;
    private JButton buttonEditar;
    private JButton buttonVoltar;
    private JTextField textFieldNomeEvento;
    private JTextField textFieldPais;
    private JTextField textFieldDataInicio;
    private JTextField textFieldDataFim;
    private JTextField textFieldLocal;
    private JPanel content;
    private JanelaEventos voltar;

    private Evento evento;

    public JanelaDetalhesEvento(JanelaEventos anterior, Evento evento){
        super("Editar Evento");

        voltar = anterior;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(content);

        this.evento = evento;

        textFieldNomeEvento.setText(evento.getNome());
        textFieldDataInicio.setText(evento.getDataInicio().toString());
        textFieldDataFim.setText(evento.getDataFim().toString());
        textFieldLocal.setText(evento.getLocal());
        textFieldPais.setText(evento.getPais());

        pack();

        buttonVoltar.addActionListener(this::buttonVoltarActionPerformed);
    }

    private void buttonVoltarActionPerformed(ActionEvent event) {
        this.dispose();
        voltar.setVisible(true);
    }
}
