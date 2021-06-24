package view;

import model.DadosAplicacao;
import model.Evento;
import model.Singleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.concurrent.atomic.DoubleAccumulator;


/**
 * 2181218
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
    private JFrame voltar;

    public JanelaCriarEvento(JFrame anterior){
        super("Eventos");

        voltar = anterior;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(content);

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
                Singleton.getInstance().dadosAplicacao.adicionarEvento(tempEvento);
            }else{
                ErrorMessage.show("Error", s);
            }
        }catch(Exception e){
            ErrorMessage.show("Error", e.getMessage());
        }
        buttonCancelarActionPerformed(event);
    }

    private void buttonCancelarActionPerformed(ActionEvent event) {
        this.dispose();
        voltar.setVisible(true);
    }
}
