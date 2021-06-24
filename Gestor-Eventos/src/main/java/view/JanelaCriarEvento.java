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

    private void buttonConfirmarActionPerformed(ActionEvent event) {
        try {
            Evento tempEvento = new Evento(textFieldNomeEvento.getText(), LocalDate.parse(textFieldDataInicio.getText()), LocalDate.parse(textFieldDataFim.getText()),textFieldLocal.getText(),textFieldPais.getText());
            if(tempEvento.isValid()){
                Singleton.getInstance().dadosAplicacao.adicionarEvento(tempEvento);
            }
        }catch(Exception e){
            ErrorMessage.show("Error", e.getMessage());
        }
    }

    private void buttonCancelarActionPerformed(ActionEvent event) {
        this.dispose();
        voltar.setVisible(true);
    }
}
