package view;

import model.Evento;
import model.Singleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;


/**
 * 2181218
 * JanelaCriarEvento, Janela com campos para o utilizador criar um evento
 */
public class JanelaEditarEvento extends JFrame{

    private JButton buttonConfirmar;
    private JButton buttonCancelar;
    private JTextField textFieldNomeEvento;
    private JTextField textFieldPais;
    private JTextField textFieldDataInicio;
    private JTextField textFieldDataFim;
    private JTextField textFieldLocal;
    private JPanel content;
    private JanelaEventos voltar;
    private Evento evento;

    public JanelaEditarEvento(JanelaEventos anterior, Evento evento){
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

        buttonCancelar.addActionListener(this::buttonCancelarActionPerformed);
        buttonConfirmar.addActionListener(this::buttonConfirmarActionPerformed);
    }

    /**
     * 2181218
     * creates event and saves it to dadosAplicacao, shows error messages if necessary
     */
    private void buttonConfirmarActionPerformed(ActionEvent event) {
        try {
            Evento tempEvento = new Evento(textFieldNomeEvento.getText(), LocalDate.parse(textFieldDataInicio.getText()), LocalDate.parse(textFieldDataFim.getText()),textFieldLocal.getText(),textFieldPais.getText());
            String s = tempEvento.isValid();
            if(s == null){
                Singleton.getInstance().dadosAplicacao.removerEvento(evento);
                evento.setNome(tempEvento.getNome());
                evento.setDataInicio(tempEvento.getDataInicio());
                evento.setDataFim(tempEvento.getDataFim());
                evento.setLocal(tempEvento.getLocal());
                evento.setPais(tempEvento.getPais());
                Singleton.getInstance().dadosAplicacao.adicionarEvento(evento);
            }else{
                ErrorMessage.show("Error", s);
            }
        }catch(Exception e){
            ErrorMessage.show("Error", e.getMessage());
        }
        this.dispose();
        voltar.buttonVoltarActionPerformed(event);
    }

    private void buttonCancelarActionPerformed(ActionEvent event) {
        this.dispose();
        voltar.setVisible(true);
    }
}