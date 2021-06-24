package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 2181218
 * ErrorMessage Dialog, use it to show a pop up with and error message
 * Use: ErrorMessage.show(title,message)
 */
public class ErrorMessage extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel messageLabel;

    public ErrorMessage(String title,String message) {
        this.setTitle(title);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        messageLabel.setText(message);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public static void show(String title, String message) {
        ErrorMessage dialog = new ErrorMessage(title, message);
        dialog.pack();
        dialog.setVisible(true);
    }
}
