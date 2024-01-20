package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.command.Command;
import software.ulpgc.moneycalculator.currency.CurrencyDialog;
import software.ulpgc.moneycalculator.money.MoneyDialog;
import software.ulpgc.moneycalculator.money.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final JTextField textField;
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;

    public MainFrame() throws HeadlessException {
        ImageIcon icon = new ImageIcon("src/main/resources/Money-Calculator.png");
        this.setTitle("Money calculator");
        this.setIconImage(icon.getImage());
        this.setSize(1000,650);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.textField = new JTextField();
        this.add(new JLabel(" Date: " + Main.date), BorderLayout.NORTH);
        this.add(createMainPanel(), BorderLayout.CENTER);
        this.add(new JLabel(""), BorderLayout.SOUTH);
    }

    private Component createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(createNorthPanel(), BorderLayout.NORTH);
        panel.add(createCenterPanel(), BorderLayout.CENTER);
        panel.add(createSouthPanel(), BorderLayout.SOUTH);
        return panel;
    }

    private Component createNorthPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Amount:");
        label.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        panel.add(label);
        textField.setColumns(10);
        textField.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        panel.add(textField);
        return panel;
    }

    private Component createCenterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(createDialogs(), BorderLayout.NORTH);
        panel.add(new SwingNumericPanel(textField));
        return panel;
    }

    private Component createSouthPanel() {
        JPanel panel = new JPanel();
        panel.add(createButton());
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        panel.add(display);
        return panel;
    }

    private Component createDialogs() {
        JPanel panel = new JPanel();
        SwingMoneyDialog moneyDialog = new SwingMoneyDialog(textField);
        this.moneyDialog = moneyDialog;
        panel.add(moneyDialog);
        SwingCurrencyDialog currencyDialog = new SwingCurrencyDialog("To:");
        this.currencyDialog = currencyDialog;
        panel.add(currencyDialog);
        return panel;
    }

    private Component createButton() {
        JButton button = new JButton("Convert");
        button.addActionListener(e -> {
            try {
                commands.get("exchange money").execute();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        button.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        return button;
    }

    public void add(String name, Command command) {
        commands.put(name, command);
    }

    public MoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    public CurrencyDialog currencyDialog() {
        return currencyDialog;
    }

    public MoneyDialog moneyDialog() {
        return moneyDialog;
    }
}
