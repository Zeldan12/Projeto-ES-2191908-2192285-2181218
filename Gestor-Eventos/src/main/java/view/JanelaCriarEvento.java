package view;

import model.DadosAplicacao;
import model.Evento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;


/**
 * JanelaCriarEvento, Janela com campos para o utilizador criar um evento
 */
public class JanelaCriarEvento extends JFrame{
    private JButton buttonConfirmar;
    private JButton buttonCancelar;
    private JTextField textFieldNomeEvento;
    private JTextField textFieldPais;
    private JTextField textFieldDataInicio;
    private JTextField textFieldDataFim;
    private JTextField textFieldLocal;
    private JPanel content;
    private JanelaEventos voltar;

    public JanelaCriarEvento(JanelaEventos anterior){
        super("Eventos");

        voltar = anterior;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(content);

        pack();

        buttonCancelar.addActionListener(this::buttonCancelarActionPerformed);
        buttonConfirmar.addActionListener(this::buttonConfirmarActionPerformed);
    }

    /**
     * creates event and saves it to dadosAplicacao, shows error messages if necessary
     */
    private void buttonConfirmarActionPerformed(ActionEvent event) {
        try {
            Evento tempEvento = new Evento(textFieldNomeEvento.getText(), LocalDate.parse(textFieldDataInicio.getText()), LocalDate.parse(textFieldDataFim.getText()),textFieldLocal.getText(),textFieldPais.getText());
            String s = tempEvento.isValid();
            if(s == null){
                DadosAplicacao.adicionarEvento(tempEvento);
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
