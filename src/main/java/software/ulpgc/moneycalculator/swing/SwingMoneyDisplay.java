package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.money.Money;
import software.ulpgc.moneycalculator.money.MoneyDisplay;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void show(Money money) {
        this.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        this.setText(money.toString());
    }
}
