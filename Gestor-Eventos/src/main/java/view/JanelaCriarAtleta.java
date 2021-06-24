package view;

import model.DadosAplicacao;
import model.Evento;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class JanelaCriarAtleta extends JFrame {
    private JPanel content;
    private JTextField textFieldNomeEvento;
    private JTextField textFieldPais;
    private JTextField textFieldDataInicio;
    private JTextField textFieldLocal;
    private JButton buttonConfirmar;
    private JButton buttonCancelar;
    private JRadioButton sexoRadio;
    private JRadioButton femininoRadio;
    private JPanel criarAtletaPanel;
    private JFrame voltar;

    public JanelaCriarAtleta (JFrame anterior){
        super("Criar atleta");

        voltar = anterior;


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(criarAtletaPanel);

        pack();

        //updateList();


        buttonCancelar.addActionListener(this::buttonCancelarActionPerformed);
        buttonConfirmar.addActionListener(this::buttonConfirmarActionPerformed);

    }

    private void buttonConfirmarActionPerformed(ActionEvent event) {

        /*
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

        */



        this.dispose();


    }

    private void buttonCancelarActionPerformed(ActionEvent event) {
        this.dispose();
        voltar.setVisible(true);
    }
}
