package software.ulpgc.moneycalculator.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingNumericPanel extends JPanel implements ActionListener {
    private final JTextField textField;
    private final String[] keys = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "C"};

    public SwingNumericPanel(JTextField textField) {
        this.setLayout(new GridLayout(3, 4));
        this.textField = textField;
        createButtons();
    }

    private void createButtons() {
        for (int i = 0; i <= 11; i++) {
            JButton b = new JButton(keys[i]);
            b.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
            b.addActionListener(this);
            this.add(b);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b.getText().equals("C")) {
            textField.setText("");
        } else {
            textField.setText(textField.getText() + b.getText());
        }
    }
}
