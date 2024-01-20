package software.ulpgc.moneycalculator.command;

import software.ulpgc.moneycalculator.currency.Currency;
import software.ulpgc.moneycalculator.currency.CurrencyDialog;
import software.ulpgc.moneycalculator.exchangerate.ExchangeRate;
import software.ulpgc.moneycalculator.exchangerate.ExchangeRateLoader;
import software.ulpgc.moneycalculator.money.Money;
import software.ulpgc.moneycalculator.money.MoneyDialog;
import software.ulpgc.moneycalculator.money.MoneyDisplay;

import java.io.IOException;
import java.text.DecimalFormat;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class ExchangeMoneyCommand implements Command {
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public ExchangeMoneyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() throws IOException {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();
        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency);
        Money result = new Money(money.amount() * exchangeRate.rate(), currency);
        moneyDisplay.show(result);
    }
}
