package software.ulpgc.moneycalculator.swing;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

public class DateFrame extends JFrame implements ActionListener {
    private String date;
    private JDateChooser dateChooser;
    private JButton accept;
    private JButton cancel;

    public DateFrame() throws MalformedURLException {
        URL url = new URL("https://cdn-icons-png.flaticon.com/512/10059/10059897.png");
        ImageIcon icon = new ImageIcon(url);
        this.setIconImage(icon.getImage());
        this.setTitle("Money calculator");
        this.setSize(340, 160);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(createPanel());
    }

    private Component createPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Select a date (YYYY-MM-DD):");
        label.setBounds(10, 10, 200, 30);
        this.add(label);
        createAcceptButton();
        createCancelButton();
        createDateChooser();
        this.add(accept);
        this.add(cancel);
        this.add(dateChooser);
        return panel;
    }

    private void createAcceptButton() {
        accept = new JButton("Accept");
        accept.setBounds(10, 75, 80, 25);
        accept.addActionListener(this);
    }

    private void createCancelButton() {
        cancel = new JButton("Cancel");
        cancel.setBounds(100, 75, 80, 25);
        cancel.addActionListener(this);
    }

    private void createDateChooser() {
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setBounds(10, 40, 300, 25);
    }

    public String getDate() {
        return date;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accept) {
            this.date = new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());
        } else if (e.getSource() == cancel) {
            System.exit(0);
        }
    }
}
